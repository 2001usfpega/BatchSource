package com.revature.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainDriver {

	private static String url=System.getenv("TRAINING_DB_URL");
	private static String username=System.getenv("TRAINING_DB_USERNAME");
	private static String password=System.getenv("TRAINING_DB_PASSWORD");
	
	public static void main(String[] args) {
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		//prepExample("cake","eggs");
		//callExample("steak","cow");
		List<Food> a=selectAllFood();
		for(Food f:a) {
			System.out.println(f.toString());
		}
	}
	

	
	public static void statExample(String f_name, String f_recipe) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql = "INSERT INTO food(food_name,recipe) VALUES('"
					+f_name+"','"+f_recipe+"')";
			
			Statement statement = conn.createStatement();
			
			int numOFRowsChanged = statement.executeUpdate(sql);
			System.out.println(numOFRowsChanged);
			
			System.out.println(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//prepare
	public static void prepExample(String f_name, String f_recipe) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			
			String sql= "INSERT INTO food(food_name,recipe) VALUES(?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, f_name);
			ps.setString(2, f_recipe);
			
			System.out.println(ps.executeUpdate());
			
			System.out.println(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//prepare
	public static void callExample(String f_name, String f_recipe) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "{ call ins_food_null_id(?,?) }";
			
			CallableStatement ps = conn.prepareCall(sql);
			ps.setString(1, f_name);
			ps.setString(2, f_recipe);
			
			System.out.println(ps.executeUpdate());
			
			System.out.println(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<Food> selectAllFood() {
		List<Food> foods = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "SELECT * FROM food";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				foods.add(new Food(rs.getInt(1),rs.getString(2),rs.getString("recipe")));
			}
			
					
			System.out.println(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return foods;
	}
	
	
	
	
	
	
}
