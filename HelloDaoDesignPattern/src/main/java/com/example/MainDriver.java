package com.example;

import java.util.List;

import com.example.model.Food;
import com.example.service.FoodService;
import com.example.service.FoodServiceImpl;

public class MainDriver {

	public static void main(String[] args) {
		FoodService foodService = new FoodServiceImpl();
		
		List<Food> foods = foodService.getAllFood();
		System.out.println("PRINTING ALL FOODS");
		for(Food f: foods) {
			System.out.print(f);
		}

	}

}
