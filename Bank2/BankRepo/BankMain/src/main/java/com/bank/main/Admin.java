package com.bank.main;
import java.util.ArrayList;

public class Admin extends Employee {
	
	public static final long serialVersionUID = -470081244094378942L;
	public Admin(String name, String password) {
		super(name, password);
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<Admin> adList = new ArrayList<Admin>();

}