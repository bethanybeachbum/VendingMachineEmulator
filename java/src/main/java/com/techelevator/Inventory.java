package com.techelevator;

import java.math.BigDecimal;

public class Inventory {

	private String slotLocation;
	private String productName;
	private BigDecimal price;
	private int quantity;
	private String type;
	private String sound;

	public Inventory(String slotLocation, String productName, BigDecimal price, String type, int quantity) {
		super();
		this.slotLocation = slotLocation;
		this.productName = productName;
		this.price = price;
		this.type = type;
		this.quantity = quantity;

	}

	
	public Inventory() {

	}


	public String sound() {
		return "Hiya!";
	}

	public String getSlotLocation() {
		return slotLocation;
	}

	public String getProductName() {
		return productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setSlotLocation(String slotLocation) {
		this.slotLocation = slotLocation;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	// Mark added this
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = 5;
	}
	
	public void purchaseItem () {
		quantity--;
	}


	public char[] getSound() {
		
		return null;
	}
}
