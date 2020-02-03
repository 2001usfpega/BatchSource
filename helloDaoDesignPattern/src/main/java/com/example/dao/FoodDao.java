package com.example.dao;

import java.util.List;

import com.example.model.Food;

public interface FoodDao 
{
	public int insertFood(Food food);
	
	public List<Food> selectAllFood();
	public Food selectFoodByID(int id);
	public Food selectFoodByName(String name);
	
	public int udateFood(Food food);
	
	public int deleteFood(Food food);
}
