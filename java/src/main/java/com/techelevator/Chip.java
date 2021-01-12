package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Inventory {
	
	public Chip(String slotLocation, String productName, 
			BigDecimal price, String type, int quantity) {
		super(slotLocation, productName, price, type, quantity);
	}

	public String sound() {
		return "Crunch Crunch, Yum!";
		
	}
	
}
