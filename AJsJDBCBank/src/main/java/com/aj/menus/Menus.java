package com.aj.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aj.models.Account;
import com.aj.models.User;
import com.aj.service.AccountServiceImpl;
import com.aj.service.UserServiceImpl;

public class Menus {
	public static int numInput;
	public static String strInput;
	public static UserServiceImpl userSvc = new UserServiceImpl();
	public static AccountServiceImpl accSvc = new AccountServiceImpl();
	public static User currentUser = null;
	public static List<User> users = new ArrayList<>();
	public static List<Account> currUserAccs = new ArrayList<>();
	static boolean flag, isValid;

	public static User mainMenu(Scanner scan) {
		users = userSvc.getAllUsers();
		return welcomeMenu(scan);
	}

	public static User welcomeMenu(Scanner scan) {

		do {
			flag = true;
			System.out.println("Welcome to JDBC Bank.\n");
			System.out.println("Please select an option from the menu below:\n");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Quit");

			try {
				numInput = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				numInput = 4;
			}

			switch (numInput) {
			case 1: {
				currentUser = loginMenu(scan);

				break;
			}
			case 2: {
				currentUser = registerMenu(scan);
				accountsMenu(scan, currentUser);
				break;
			}
			case 3:
				mainMenu(scan);
				break;
			case 4: {
				System.out.println("Please enter the number next to the menu item you want to choose.");
				break;
			}

			}
		} while (flag);
		return currentUser;
	}

	public static User loginMenu(Scanner scan) {
		String user, pw;
		do {

			flag = true;
			System.out.println("Please enter your username:");
			@SuppressWarnings("resource")
			Scanner scan1 = new Scanner(System.in);
			user = scan1.nextLine();
			isValid = UserServiceImpl.userExists(user);
			if (isValid) {
				System.out.println("Please enter your password:");
				pw = scan1.nextLine();
				userSvc.logIn(user, pw);
				flag = false;

			} else {
				System.out.println("We're sorry, we don't recognize that username. " + "Please try again.");
			}

		} while (flag);
		System.out.println("Welcome, " + UserServiceImpl.getCurrentUser().getFname() + "!");
		delayTime(3);
		currentUser = UserServiceImpl.getCurrentUser();
		accountsMenu(scan, currentUser);

		return UserServiceImpl.getCurrentUser();
	}

	public static User registerMenu(Scanner scan) {
		// Create new empty user object
		User newUser = new User();
		boolean isUsernameValid = false;
		boolean isPwValid = false;
		String user = null;
		while (!isUsernameValid) {
			user = scan.nextLine();
			System.out.println("Please enter a username that is 8 or more characters long.");
			user = scan.nextLine();
			isUsernameValid = userSvc.validateUsername(user);
		}
		newUser.setUname(user);

		System.out.println(
				"Please enter a password that is greater than 8 characters long and contains both upper and lowercase characters.");
		String pw = scan.nextLine();
		System.out.println(isPwValid = userSvc.validatePassword(pw));
		while (!isPwValid) {
			System.out.println(
					"Please enter a password that is greater than 8 characters long, contains at least one number, and contains both upper and lowercase characters.");
			pw = scan.nextLine();
			isPwValid = userSvc.validatePassword(pw);
		}
		newUser.setPw(pw);
		System.out.println("Please enter your first name:");
		String fname = scan.nextLine();
		newUser.setFname(fname);
		System.out.println("Please enter your last name:");
		String lname = scan.nextLine();
		newUser.setLname(lname);
		newUser.setRole("cust");

		return userSvc.createUser(newUser);

	}

	public static void existingUserMenu(Scanner scan, User user) {
		System.out.println("What would you like to do?");
		System.out.println("1. View Account Details");
		System.out.println("2. Open New Account");
		System.out.println("3. Logout");
		int input = scan.nextInt();

		switch (input) {
		case 1: {
			delayTime(3);
			for (Account a : currUserAccs) {
				System.out.println("------------------------------------------");
				System.out.println(a.getType() + " account balance: " + "$" + a.getBalance() + "0");
			}
			delayTime(3);
			whichAccount(currUserAccs, scan);
			break;
		}
		case 2: {
			delayTime(3);
			Account newAccount = new Account();
			newAccount.setCust_id(user.getUser_id());
			System.out.println("Please select the account type:");
			System.out.println("1. Checking Account");
			System.out.println("2. Savings Account");
			int type = scan.nextInt();

			switch (type) {
			case 1: {
				newAccount.setType("checking");
			}
			case 2: {
				newAccount.setType("savings");
			}
			}
			delayTime(3);
			System.out.println("How much money would you like to deposit into your new" + " " + newAccount.getType()
					+ " account?");
			float deposit = scan.nextFloat();
			newAccount.setBalance(deposit);
			accSvc.createAccount(newAccount);
			break;

		}
		case 3: {
			mainMenu(scan);
			break;
		}
		}
	}

	public static void newUserMenu(Scanner scan, User user) {
		Account newAcc = new Account();
		newAcc.setCust_id(user.getUser_id());
		System.out.println("Thank you for choosing JDBC Bank!");
		System.out.println("What type of account would you like to create?");
		System.out.println("1. Checking");
		System.out.println("2. Savings");
		int choice = scan.nextInt();
		switch (choice) {
		case 1: {
			newAcc.setType("checking");
			System.out.println(
					"How much money would you like to deposit into your new " + newAcc.getType() + " account?");
			float amount = scan.nextFloat();
			newAcc.setBalance(amount);

			accSvc.createAccount(newAcc);
			accountsMenu(scan, user);
			break;
		}
		case 2: {
			newAcc.setType("savings");
			System.out.println(
					"How much money would you like to deposit into your new " + newAcc.getType() + " account?");
			float amount = scan.nextFloat();
			newAcc.setBalance(amount);

			accSvc.createAccount(newAcc);
			accountsMenu(scan, user);
			break;
		}
		}

	}

	public static void accountsMenu(Scanner scan, User user) {

		if (accsExist(user)) {
			existingUserMenu(scan, user);
		} else {
			newUserMenu(scan, user);
		}

	}

	public static Account whichAccount(List<Account> userAccs, Scanner scan) {
		int numOfAccs = userAccs.size();
		Account thisAccount = null;
		System.out.println("Which account would you like to modify?");
		System.out.println();
		for (int i = 0; i < numOfAccs; i++) {
			System.out.println((i + 1) + ". " + userAccs.get(i).getType() + ": $" + userAccs.get(i).getBalance() + "0");
		}

		int whichOne = scan.nextInt();

		if (whichOne > numOfAccs) {
			System.out.println("Please choose a number next to an existing account.");
			whichOne = scan.nextInt();
		}

		switch (whichOne) {
		case 1:
			thisAccount = userAccs.get(whichOne - 1);
			watDo(scan, thisAccount);
			break;
		case 2:
			thisAccount = userAccs.get(whichOne - 1);
			watDo(scan, thisAccount);
			break;
		case 3:
			thisAccount = userAccs.get(whichOne);
			watDo(scan, thisAccount);
			break;
		case 4:
			thisAccount = userAccs.get(whichOne);
			watDo(scan, thisAccount);
			break;
		}

		return thisAccount;
	}

	public static void watDo(Scanner scan, Account account) {
		System.out.println("What would you like to do?");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Logout");

		int choice = scan.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Please enter the amount you would like to deposit: ");
			float amount = scan.nextFloat();

			accSvc.depositMoney(account, amount);

			System.out.println("Your new account balance is $" + account.getBalance() + "0");
			break;
		}
		case 2: {
			System.out.println("Please enter the amount you would like to withdraw:");
			float amount = scan.nextFloat();

			if (!accSvc.withdrawMoney(account, amount)) {
				System.out.println("Please enter an amount to withdraw that is less than your balance of $" + account.getBalance() + "0.");
			}

			System.out.println("Your new account balance is $" + account.getBalance() + "0");
			break;
		}
		}

	}

	public static boolean accsExist(User user) {
		currUserAccs = accSvc.getAccountByCustId(user);

		if (currUserAccs.size() < 1) {
			return false;
		}
		return true;
	}

	public static Account openAccount(Scanner scan) {
		Account newAcc = new Account();

		return newAcc;
	}

	public static void delayTime(int count) {

		for (int i = 0; i < count; i++) {

			try {
				Thread.sleep(500);
				System.out.print(" .");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println();
	}
}
