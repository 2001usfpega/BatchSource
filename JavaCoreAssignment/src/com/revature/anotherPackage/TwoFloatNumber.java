package com.revature.anotherPackage;

public class TwoFloatNumber {
	
	float box1, box2;
	
	public TwoFloatNumber() {
		this.box1 = 2.3f;
		this.box2 = 2.4f;
	}
	
	
	public float[] getFloatInString() {
		
		float[] fl = new float[2];
		fl[0] = box1;
		fl[1] = box2;
		return fl;
	}
}
