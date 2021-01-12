package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Inventory {

	public Drink(String slotLocation, String productName, 
			BigDecimal price, String type, int quantity) {
		super(slotLocation, productName, price, productName, quantity);
	}

	public String sound() {
		return "Glug Glug, Yum!";
		
	}
}

