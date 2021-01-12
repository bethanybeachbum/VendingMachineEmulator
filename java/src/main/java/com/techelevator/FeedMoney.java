package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class FeedMoney {

	BigDecimal a = new BigDecimal(1.00);
	BigDecimal b = new BigDecimal(2.00);
	BigDecimal c = new BigDecimal(5.00);
	BigDecimal d = new BigDecimal(10.00);
	BigDecimal balance = new BigDecimal(0.00);

	

	public BigDecimal getMoney() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Your current balance is: " + balance);
		System.out.println("Would you like to add money to make a purchase?  (y/n) ");
		String userInput2 = "y";

		while (userInput2.equalsIgnoreCase("y")) {
			userInput2 = userInput.nextLine();
			System.out.println("How much would you like to add in incremenets of $1, $2, $5 and $10?");
			String dollarRequest = userInput.nextLine();

			if (dollarRequest.equals("1")) {
				balance = balance.add(a);

			} else if (dollarRequest.equals("2")) {
				balance = balance.add(b);

			} else if (dollarRequest.equals("5")) {
				balance = balance.add(c);

			} else if (dollarRequest.equals("10")) {
				balance = balance.add(d);
			}

			System.out.println("Would you like to add some more money to make a purchase?  (y/n) ");
			userInput2 = userInput.nextLine();

		}
		return balance;
	}
	
	// public BigDecimal getCurrentMoneyProvided() {
	public BigDecimal getBalance() {
		return balance;
	}

	// public void setCurrentMoneyProvided(BigDecimal balance) {
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
