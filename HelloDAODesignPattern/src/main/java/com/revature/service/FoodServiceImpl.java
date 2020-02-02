package com.revature.service;

import java.util.List;

import com.revature.dao.FoodDAO;
import com.revature.dao.FoodDAOimpl;
import com.revature.model.Food;

public class FoodServiceImpl implements FoodService {
	
	private FoodDAO foodDao = new FoodDAOimpl();

	@Override
	public List<Food> getAllFood() {
		// TODO Auto-generated method stub
		//our pre-DB call business login would go here
		List <Food> myList = foodDao.selectAllFood();
		//our post-DB call business logic would go here
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
