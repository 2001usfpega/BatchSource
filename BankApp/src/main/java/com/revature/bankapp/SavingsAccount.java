package com.revature.bankapp;

import java.util.*;
import java.text.*;
import java.io.*;

public interface SavingsAccount {

	final double rate = 0.04;
	final double limit = 10000;
	final double limit1 = 200;
	
	void deposit(double n, Date d);
	void withdraw(double n, Date d);
	
}
