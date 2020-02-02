package com.revature;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Food;

public class MainDriver {

	
	private static String url = System.getenv("Training_DB_URL");
	private static String username = System.getenv("Training_DB_Username");
	private static String password = System.getenv("Training_DB_password");
	
	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		*/
		//statementExample("omele du fromage", "egg and cheese");
		//preparedStatementExample("Bacon wrapped Shrimp", "two yummy foods");
		//callableStatementExample("King's Hawaiian Rolls", "Sloppy Joe");
		System.out.println(selectAllFood());
	}
	
	//THIS IS an example of how to query using JDBC
	public static List<Food> selectAllFood(){
		List<Food> foods = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM food";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				foods.add(
						new Food(rs.getInt(1), rs.getString(2), rs.getString("recipe")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foods;
	}


	//callable  statement example - Do these not the others; safer in terms of SQL injection
		public static void callableStatementExample(String f_name, String f_recipe) {
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				/*
				 * callable statements guard against SQL injection because it is pre-compiled
				 * (this also makes it faster)
				 */
				String sql = "{ call insert_food_null_id(?,?)}"; // { }are necessary if you want to return values
				CallableStatement cs = conn.prepareCall(sql);
				cs.setString(1,  f_name);//first question mark
				cs.setString(2,  f_recipe);//second question mark
				int status = cs.executeUpdate();
				System.out.println("Callable Statement returns: "+status);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	//prepared statement example - Do these not the others; safer in terms of SQL injection
	public static void preparedStatementExample(String f_name, String f_recipe) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			/*
			 * prepared statements guard against SQL injection because it is pre-compiled
			 * (this also makes it faster)
			 */
			String sql = "INSERT INTO food(food_name, recipe) VALUES(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  f_name);//first question mark
			ps.setString(2,  f_recipe);//second question mark
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//statement - prone for SQL injection
	public static void statementExample(String f_name, String f_recipe) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "INSERT INTO food(food_name, recipe) VALUES('"+f_name+"','"+f_recipe+"')";
			/*f_recipe = "; DROP TABLE food;";
			 * THIS is SQL injection - where someone puts malicious code in yours to eff you up
			 */
			Statement statement = conn.createStatement();
			int numOfRowsChanged = statement.executeUpdate(sql);
			System.out.println("The # of rows changed: "+numOfRowsChanged);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
