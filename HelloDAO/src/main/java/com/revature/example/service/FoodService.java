package com.revature.example.service;

import java.util.List;

import com.revature.example.Food;

public interface FoodService {
	
	public List<Food> getAllFood();
	public Food getFood(Food food);
	
	public void accountCreate(String user);
	
	public boolean checkUserNameAndPassword(String u, String p);
	public boolean login(String u, String p);
}
