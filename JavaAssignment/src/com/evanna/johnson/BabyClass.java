package com.evanna.johnson;

public class BabyClass extends SuperClass{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	}

	@Override
	public boolean IsUpperCase(String e) {
		if(!e.equals(e.toLowerCase())) {
			return true;
		}else
		return false;
	}

	@Override
	public String convertLCase(String r) {
		String evanna= r.toUpperCase();
		
		return evanna;
	
	}
	@Override
	public int convert2String(String e) {
	 int j = Integer.parseInt(e);
	 
	 	j+=10;
	 	return j;
	}
}
