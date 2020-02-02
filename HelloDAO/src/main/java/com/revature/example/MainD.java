package com.revature.example;

import java.util.List;

import com.revature.example.service.FoodService;
import com.revature.example.service.FoodServiceImpl;

public class MainD {

	public static void main(String[] args) {
		FoodService foodServ = new FoodServiceImpl();
		List<Food> foods = foodServ.getAllFood();
		System.out.println("printing");

		for(Food f: foods) {
			System.out.println(f);
		}
	}

}
