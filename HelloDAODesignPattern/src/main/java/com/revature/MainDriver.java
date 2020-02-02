package com.revature;

import java.util.List;

import com.revature.model.Food;
import com.revature.service.FoodService;
import com.revature.service.FoodServiceImpl;

public class MainDriver {

	public static void main(String[] args) {
		FoodService foodServ = new FoodServiceImpl();
		List<Food> foods = foodServ.getAllFood();
		System.out.println("Printing all Foods!");
		
		for (Food f: foods) {
			System.out.println(f);
		}
		

	}

}
