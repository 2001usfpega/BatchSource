package com.aj.corejava;

public class MathImpl implements MathInterface {

	@Override
	public int addition(int i, int j) {
		return i + j;
	}

	@Override
	public int subtraction(int i, int j) {
		if (i > j) {
			return i - j;
		}
		return j - i;
	}

	@Override
	public int multiplication(int i, int j) {
		return i * j;
	}

	@Override
	public int division(int i, int j) {
		return i / j;
	}
}
