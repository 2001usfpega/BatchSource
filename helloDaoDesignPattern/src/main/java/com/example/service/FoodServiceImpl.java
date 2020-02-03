package com.example.service;

import java.util.List;
import com.example.dao.FoodDao;
import com.example.dao.FoodDaoImpl;
import com.example.model.Food;

public class FoodServiceImpl implements FoodService {

	private FoodDao foodDao = new FoodDaoImpl();
	//private List<Food> myLi =new ArrayList();

	@Override
	public List<Food> getAllFood() {
		// TODO Auto-generated method stub
		List<Food> myList = foodDao.selectAllFood();
		
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
	public boolean checUSERnameANdPassword(String u, String p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(String u, String p) {
		// TODO Auto-generated method stub
		return false;
	}

}
