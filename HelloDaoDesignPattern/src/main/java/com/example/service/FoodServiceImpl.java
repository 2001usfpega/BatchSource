package com.example.service;

import java.util.List;

import com.example.dao.FoodDao;
import com.example.dao.FoodDaoImpl;
import com.example.model.Food;

public class FoodServiceImpl implements FoodService {
	
	private FoodDao foodDao = new FoodDaoImpl();

	@Override
	public List<Food> getAllFood() {
		//our pre-DB call business logic would go here
		List<Food> myList = foodDao.selectAllFood();
		//our post-DB business logic would go here
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
	public boolean checkUsernameAndPassword(String u, String p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(String u, String p) {
		// TODO Auto-generated method stub
		return false;
	}

}
