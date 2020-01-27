package com.revature;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	
	private static ArrayList<Account> allAccounts =new ArrayList<Account>();
	private static int nextAccountNumber=1000;
	
	private int AccountNum;
	private double AccountBal;
	private boolean isAproved;
	
	public int getAccountNum() {
		return AccountNum;
	}
	
	public void setAccountNum(int accountNum) {
		AccountNum = accountNum;
	}
	
	public double getAccountBal() {
		return AccountBal;
	}
	
	public void setAccountBal(double newBal) {
		AccountBal = newBal;
	}
	
	Scanner accountInfo = new Scanner(System.in);
	
	public Account() {
		AccountBal=0;
		AccountNum=nextAccountNumber;
		nextAccountNumber++;
		
		allAccounts.add(this);
		
	}

	public void deposit(){
		Scanner accountInfo = new Scanner(System.in);
		double depositValue;
		System.out.println(" Enter Deposit Amount: ");
		depositValue = accountInfo.nextFloat();
		
		
		if(depositValue>0) {
			this.AccountBal = this.AccountBal + depositValue;
			System.out.println("Deposit Successsful! ");
		}
		else
		{
			System.out.println("Invalid Amount");

			
		}
		
		}
	
	public void Withdraw() {
		Scanner accountInfo = new Scanner(System.in);
		float withdrawValue;
		System.out.println(" Enter Withdrawl Amount: ");
		withdrawValue = accountInfo.nextFloat();
		
		
		if(withdrawValue<=AccountBal&& withdrawValue>0) {
			System.out.println("Withdrawal Successsful! ");
			AccountBal=AccountBal-withdrawValue;
		}
		else
		{
			System.out.println("Invalid Amount: Withdrawal Amount Exceeds Account Balance");
			
			
		}
	
		
		
	}
	public void Transfer(float amount, Account other) {
	
		
		double newBal=other.getAccountBal()+amount;
		other.setAccountBal(newBal);
		}	
	
	
	@Override
	public String toString() {
		return null;
	}
}
