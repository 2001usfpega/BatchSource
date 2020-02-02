package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Food;

public class FoodDAOimpl implements FoodDAO {
	
	private static String url = System.getenv("Training_DB_URL");
	private static String username = System.getenv("Training_DB_Username");
	private static String password = System.getenv("Training_DB_password");
	

	@Override
	public int insertFood(Food food) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Food> selectAllFood() {
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

	@Override
	public Food selectFoodByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food selectFoodByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateFood(Food food) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFood(Food food) {
		// TODO Auto-generated method stub
		return 0;
	}

}
