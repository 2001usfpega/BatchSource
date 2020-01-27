package com.revature.banking.test;

public class Login {

	public boolean login(String a , String b) {

		//checks if the entered and stored password are the same
		if(a.equals(b)) {

			return true;

		}else {

			return false;
		}
	}
}