package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Inventory {

	public Gum(String slotLocation, String productName, BigDecimal price, String type, int quantity) {
		super(slotLocation, productName, price, productName, quantity);
	}

	public String sound() {
		return "Chew Chew, Yum!";
	}

}
