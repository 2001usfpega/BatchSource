package com.revature.bank.storage;

import com.revature.bank.data.Account;
import com.revature.bank.data.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A {@link StorageService} that connects to an Oracle SQL Database.
 * Connection properties must be defined in db.properties file:
 * url [url]
 * user [user]
 * pass [password]
 */
public class OracleSQLService implements StorageService {
    private final Connection con;

    public OracleSQLService() throws IOException {
        Map<String, String> settings = new HashMap<>();
        File file = new File("db.properties");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] setting = line.split(" ");

            settings.put(setting[0], setting[1]);
        }

        con = StorageService.databaseAction("Connecting to Revature Bank", () -> {
            try {
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                return DriverManager.getConnection("jdbc:oracle:thin:@" + settings.get("url") + ":1521:ORCL", settings.get("user"), settings.get("pass"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @Override
    public void insertUser(User user) {
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO users VALUES(?, ?, ?, '', ?)");

            statement.setString(1, user.getName());
            statement.setBytes(2, user.getPasswordHash());
            statement.setBytes(3, user.getSalt());
            statement.setInt(4, user.getPermission().ordinal());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String username, String loadMsg) {
        return StorageService.databaseAction(loadMsg, () -> {
            try {
                ResultSet result = con.prepareStatement("SELECT * FROM users WHERE username='" + username + "'").executeQuery();

                if (!result.next()) {
                    return null;
                }

                User user = new User(username, result.getBytes(2), result.getBytes(3), result.getString(4), User.Permission.values()[result.getInt(5)]);
                result = con.prepareStatement("SELECT account_id FROM holdings WHERE username='" + username + "'").executeQuery();

                while (result.next()) {
                    user.getAccounts().add(result.getInt("account_id"));
                }
                return user;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @Override
    public List<User> getAllUsers() {
        return StorageService.databaseAction("Fetching All Users", () -> {
            try {
                ResultSet result = con.prepareStatement("SELECT username, address, permission FROM users").executeQuery();
                List<User> users = new ArrayList<>();

                while (result.next()) {
                    users.add(new User(result.getString(1), null, null, result.getString(2), User.Permission.values()[result.getInt(3)]));
                }

                return users;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Collections.emptyList();
        });
    }

    @Override
    public void updateUser(User user) {
        StorageService.databaseAction("Updating User", () -> {
            try {
                PreparedStatement prep = con.prepareStatement("UPDATE users SET password_hash=?, salt=?, address=? WHERE username=?");

                prep.setBytes(1, user.getPasswordHash());
                prep.setBytes(2, user.getSalt());
                prep.setString(3, user.getAddress());
                prep.setString(4, user.getName());

                prep.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @Override
    public Account createAccount(User initialHolder) {
        return StorageService.databaseAction("Creating a new account", () -> {
            try {
                CallableStatement statement = con.prepareCall("BEGIN create_account(?, ?); END;");

                statement.setString(1, initialHolder.getName());
                statement.registerOutParameter(2, Types.NUMERIC);
                statement.execute();

                return new Account(statement.getInt(2), false, 0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @Override
    public Account getAccount(int id) {
        return StorageService.databaseAction(null, () -> {
            try {
                ResultSet result = con.prepareStatement("SELECT * FROM accounts WHERE id='" + id + "'").executeQuery();

                if (result.next()) {
                    Account account = new Account(id, result.getBoolean("approved"), result.getDouble("balance"));
                    ResultSet held = con.prepareStatement("SELECT username FROM holdings WHERE account_id='" + account.getId() + "'").executeQuery();

                    while (held.next()) {
                        account.getHolders().add(held.getString("username"));
                    }
                    return account;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @Override
    public List<Account> getAccounts() {
        return StorageService.databaseAction("Fetching accounts", () -> {
            try {
                ResultSet result = con.prepareStatement("SELECT * FROM accounts").executeQuery();
                List<Account> accounts = new ArrayList<>();

                if (result.next()) {
                    Account account = new Account(result.getInt("id"), result.getBoolean("approved"), result.getDouble("balance"));
                    ResultSet held = con.prepareStatement("SELECT username FROM holdings WHERE account_id='" + account.getId() + "'").executeQuery();

                    while (held.next()) {
                        account.getHolders().add(held.getString("username"));
                    }
                    accounts.add(account);
                }

                return accounts;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Collections.emptyList();
        });
    }

    @Override
    public List<Account> getAccountsNeedingApproval() {
        return StorageService.databaseAction("Fetching accounts needing approval", () -> {
            try {
                ResultSet result = con.prepareStatement("SELECT id FROM accounts WHERE approved=0").executeQuery();
                List<Account> accounts = new ArrayList<>();

                if (result.next()) {
                    Account account = new Account(result.getInt("id"), false, 0);
                    ResultSet held = con.prepareStatement("SELECT username FROM holdings WHERE account_id='" + account.getId() + "'").executeQuery();

                    while (held.next()) {
                        account.getHolders().add(held.getString("username"));
                    }
                    accounts.add(account);
                }

                return accounts;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Collections.emptyList();
        });
    }

    @Override
    public void updateAccount(Account account) {
        StorageService.databaseAction("Updating Account", () -> {
            try {
                PreparedStatement prep = con.prepareStatement("UPDATE accounts SET approved=?, balance=? WHERE id=?");

                prep.setBoolean(1, account.isApproved());
                prep.setDouble(2, account.getBalance());
                prep.setInt(3, account.getId());

                prep.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @Override
    public boolean deleteAccount(int id) {
        return StorageService.databaseAction("Deleting account " + id, () -> {
            try {
                con.prepareStatement("DELETE FROM accounts WHERE id='" + id + "'").execute();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        });
    }

    @Override
    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}