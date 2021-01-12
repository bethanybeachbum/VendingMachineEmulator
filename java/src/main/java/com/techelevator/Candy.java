package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Inventory implements VendPrint{
	
	public Candy(String slotLocation, String productName, 
			BigDecimal price, String type, int quantity) {
		super(slotLocation, productName, price, type, quantity);
	}

	public String sound() {
		return "Munch Munch, Yum!";
		
	}
	
}

