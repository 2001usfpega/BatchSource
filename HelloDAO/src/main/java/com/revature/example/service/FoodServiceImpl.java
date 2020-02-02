package com.revature.example.service;

import java.util.List;

import com.revature.example.Food;
import com.revature.example.dao.FoodDao;
import com.revature.example.dao.FoodDaoImpl;

public class FoodServiceImpl implements FoodService {
	
	private FoodDao foodDao = new FoodDaoImpl();

	
	@Override
	public List<Food> getAllFood() {

		List<Food>myList=foodDao.selectAllFood();
		return myList;
	}

	@Override
	public Food getFood(Food food) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accountCreate(String user) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkUserNameAndPassword(String u, String p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(String u, String p) {
		// TODO Auto-generated method stub
		return false;
	}

}
