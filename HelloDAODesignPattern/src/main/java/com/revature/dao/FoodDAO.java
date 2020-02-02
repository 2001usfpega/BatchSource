package com.revature.dao;

import java.util.List;

import com.revature.model.Food;

public interface FoodDAO {
	
	///CRUD methods only
	
	//CREATE
	public int insertFood(Food food);
	//read
	public List<Food> selectAllFood();
	public Food selectFoodByID(int id);
	public Food selectFoodByName(String name);
	//UPDATE
	public int updateFood(Food food);
	//DELET
	public int deleteFood(Food food);

}
