package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadCSV {

	public List<Inventory> parseData() throws FileNotFoundException {
		// public static void parseData(String str) {
		List<Inventory> inventoryList = new ArrayList<>();
		Scanner sc = null;
		sc = new Scanner(new File("vendingmachine.csv"));

		Inventory inv = new Inventory();

		String slotLocation, productName, type;
		BigDecimal price;
		while (sc.hasNext()) {
			String[] scArray = sc.nextLine().split("\\|");
			slotLocation = scArray[0];
			productName = scArray[1];
			String strPrice = scArray[2];
			price = new BigDecimal(strPrice);
			type = scArray[3];

//			System.out.println("SlotLocation: " + slotLocation + " ProductName: " + productName + " Price: " + price
//					+ " Type: " + type);
			if (type.equals("Chip")) {
				Chip chip = new Chip(slotLocation, productName, price, type, 5);
				inventoryList.add(chip);
			} else if (type.equals("Gum")) {
				Gum gum = new Gum(slotLocation, productName, price, type, 5);
				inventoryList.add(gum);
			} else if (type.equals("Candy")) {
				Candy candy = new Candy(slotLocation, productName, price, type, 5);
				inventoryList.add(candy);
			} else if (type.equals("Drink")) {
				Drink drink = new Drink(slotLocation, productName, price, type, 5);
				inventoryList.add(drink);
			}
		}
		sc.close();
		return inventoryList;

	}
}
