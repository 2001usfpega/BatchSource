package com.revature.example.dao;

import java.util.List;

import com.revature.example.Food;

public interface FoodDao {

	///CRUD METHODS ONLY
	
	//CREATE
	public int insertFood(Food food);
	//READ
	public List<Food> selectAllFood();
	public Food selectFoodById(int id);
	public Food selectFoodByName(String name);
	//UPDATE
	public int updateFood(Food food);
	//DELETE
	public int deleteFood(Food food);
}