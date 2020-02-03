package com.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Food;

public class MainDriver 
{
	
	/*
	 * 
	 * private static String url =
	 * "jdbc:oracle:thin:@
	 * jdbc:oracle:thin:@localhost:1521:xe
	 * 
	 * */
	private static String url= System.getenv("TRAINING_DB_URL");
	private static String username = System.getenv("TRAINING_DB_USERNAME");
	private static String password = System.getenv("TRAINING_DB_PASSWORD");
	
	
	public static void main(String[] args) 
	{
		//System.out.println(url);
		//System.out.println(username);
		//System.out.println(password);
		statementExample("omele du fromage", "Dexters lab");
	}
	
	public static List<Food> selectAllFood()
	{
		List<Food> foods = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql = "SELECT *FROM food";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				foods.add(new Food(rs.getInt(1), rs.getString(2), rs.getString("recipe")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return foods;
	}
	
	
	
	
	
	//prepared statement example
	public static void preparedStatementExample(String f_name, String f_recipe) 
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql = "INSERT INTO food(food_name, recipe) VALUES(?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, f_name);
			ps.setString(2, f_recipe);
			
			
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	//statement
	public static void statementExample(String f_name, String f_recipe) 
	{
		try(Connection conn = DriverManager.getConnection(url, username, password))
		{
			String sql = " INSERT INTO food(food_name, recipe) VALUES('" + f_name+"' , '"+f_recipe+"')";
			
			
			
			Statement statement = conn.createStatement();
			
			int numOfRowsChanged = statement.executeUpdate(sql);
			System.out.println("The # of rows changed: "+ numOfRowsChanged);
			
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	//callable statement example
		public static void callableStatementExample(String f_name, String f_recipe) 
		{
			try(Connection conn = DriverManager.getConnection(url, username, password))
			{
				String sql = "{ call insert_foo_null_id(?,?) }";
				
				CallableStatement cs = conn.prepareCall(sql);
				cs.setString(1, f_name);
				cs.setString(2, f_recipe);
				
				int status = cs.executeUpdate(); 
				System.out.println("Callable statement returns: " + status);
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}

}
