package com.techelevator;

import java.math.BigDecimal;

public class CashOut {

	public void calculateChange(BigDecimal balance) {
	

		BigDecimal a10 = new BigDecimal(10);
		BigDecimal b5 = new BigDecimal(5);
		BigDecimal c1 = new BigDecimal(1);
		BigDecimal d25c = new BigDecimal(0.25);
		BigDecimal e10c = new BigDecimal(0.10);
		BigDecimal f5c = new BigDecimal(0.05);
		BigDecimal zero = new BigDecimal(0);
		String stringOfChangeReturned = "";
		
		
		
		int count = 0;
		while (balance.compareTo(a10) >= 0) {
			count++;
			balance = balance.subtract(a10);
		}
		System.out.println(count + " $10 bill");
		count = 0;
		while (balance.compareTo(b5) >= 0) {
			count++;
			balance = balance.subtract(b5);
		}
		System.out.println(count + " $5 bill");
		count = 0;
		while (balance.compareTo(c1) >= 0) {
			count++;
			balance = balance.subtract(c1);
		}
		System.out.println(count + " $1 bill");
		count = 0;
		while (balance.compareTo(d25c) >= 0) {
			count++;
			balance = balance.subtract(d25c);
		}
		System.out.println(count + " Quarters");
		count = 0;
		while (balance.compareTo(e10c) >= 0.10) {
			count++;
			balance = balance.subtract(e10c);
		}
		System.out.println(count + " Dimes");
		count = 0;
		while (balance.compareTo(f5c) >= 0.05) {
			count++;
			balance = balance.subtract(f5c);
		} 
		System.out.println(count + " Nickels");
	} 

	

}
