package com.aj.exceptions;

public class IncreaseByNegativeException extends RuntimeException {

	private static final long serialVersionUID = -5335303916505036005L;

	public IncreaseByNegativeException() {
		System.out.println("You can't increase age by a negative number!");
	}
}
