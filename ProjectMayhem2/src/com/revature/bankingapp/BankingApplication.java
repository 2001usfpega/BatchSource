package com.revature.bankingapp;

//import java.util.Scanner;
//
//public class CreateAccount {
//	int accountNum;
//	String accountName;
//	String IFSCcode;
//	
//public CreateAccount (int accountNum, String accountName, String IFSCcode) {
//	this.accountNum = accountNum;
//	this.accountName= accountName;
//	this.IFSCcode = IFSCcode;
//}
///*
// * add deposit money with the balance
// */
//public double depositMulah() throws MiniumAmountDeposit{
//	double currentBalance = 0.00;
//	Scanner scn = new Scanner(System.in);
//	System.out.println("please enter deposit amount");
//	double Depositamount = scn.nextDouble();
//	currentBalance += Depositamount;
//	System.out.println("your currentbalance=" + currentBalance);
//	
//	return currentBalance;
//}
//
//public void WithdrawMoney() throws InsufficientBalException, MinimumAmouintDeposit{
//	double currentBalance = 0.00;
//	Scanner deposit = new Scanner(System.in);
//	System.out.println("please enter deposit amount");
//	double Depositamount = deposit.nextDobule();
//	currentBalance += Depositamount;
//	System.out.println("your currentbalance=" + currentBalance);
//	
////double currentBalance = depositMoney
////setDaily Withdrawl limit
//	
//	final double setDailyLimit = 2500.00;
//}
//
//}
//public class BankingApplication {
//
//}
import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int userChoice;

		boolean quit = false;

		float balance = 0f;

		do {

			System.out.println("1. Deposit money");

			System.out.println("2. Withdraw money");

			System.out.println("3. Check balance");

			System.out.print("Your choice, 0 to quit: ");

			userChoice = in.nextInt();

			switch (userChoice) {

			case 1:

				float amount;

				System.out.print("Amount to deposit: ");

				amount = in.nextFloat();

				if (amount <= 0)

					System.out.println("Can't deposit nonpositive amount.");

				else {

					balance += amount;

					System.out.println("$" + amount + " has been deposited.");

				}

				break;

			case 2:

				System.out.print("Amount to withdraw: ");

				amount = in.nextFloat();

				if (amount <= 0 || amount > balance)

					System.out.println("Withdrawal can't be completed.");

				else {

					balance -= amount;

					System.out.println("$" + amount + " has been withdrawn.");

				}

				break;

			case 3:

				System.out.println("Your balance: $" + balance);

				break;

			case 0:

				quit = true;

				break;

			default:

				System.out.println("Wrong choice.");

				break;

			}

			System.out.println();

		} while (!quit);

		System.out.println("Bye!");

	}

}