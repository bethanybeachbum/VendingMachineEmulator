package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_END_PROGRAM = "Quit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_END_PROGRAM };

	private static final String purchase_menu_feed_money = "Feed Money";
	private static final String purchase_menu_select_product = "Select Product";
	private static final String purchase_menu_finish_transaction = "Finish Transaction";
	private static final String[] purchase_menu_options = { purchase_menu_feed_money, purchase_menu_select_product,
			purchase_menu_finish_transaction };

	private Menu menu;
	
	private Logger log;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {

		ReadCSV readFile = new ReadCSV();
		
		log = new Logger("vendingLogFile.txt");
		
		List<Inventory> inventoryList = readFile.parseData();

		// Instantiate FeedMoney object
		FeedMoney intakeMoney = new FeedMoney();
		BigDecimal balance = intakeMoney.getBalance(); 
		
		// BigDecimal balance = intakeMoney.getCurrentMoneyProvided();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			balance = new BigDecimal(0);
			
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				
				
				// display vending machine items
				System.out.println("Slot       Product                Price     Qty");
				System.out.println("=============================================\n");
				for (Inventory item : inventoryList) {

					System.out.println(String.format("%-10s", item.getSlotLocation())
							+ String.format("%-20s", item.getProductName()) + String.format("%7s", item.getPrice())
							+ String.format("%7s", item.getQuantity()));

				}// end of for loop (choice.equals

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				while (true) {
					String purchase = (String) menu.getChoiceFromOptions(purchase_menu_options);

					if (purchase.equals(purchase_menu_feed_money)) {

						// feed money loop
						balance = intakeMoney.getMoney();
						String logOutput = LocalDateTime.now() + "    FEED MONEY: $" + balance;
						log.write(logOutput);				

					} else if (purchase.equals(purchase_menu_select_product)) {
						System.out.println("Slot       Product           Price     Qty");
						System.out.println("==========================================\n");
						for (Inventory item : inventoryList) {

							System.out.println(String.format("%-10s", item.getSlotLocation())
									+ String.format("%-20s", item.getProductName()) + String.format("%7s", item.getPrice())
									+ String.format("%7s", item.getQuantity()));
						}
						
						Scanner foodChoice = new Scanner(System.in);
						System.out.println("Your current balance is: $" + balance);
						System.out.println("Enter the slot location you would like to purchase:  ");
						String foodChoiceSlot = foodChoice.nextLine();
						boolean found = false;

						for (Inventory item : inventoryList) {
							
							if (foodChoiceSlot.equalsIgnoreCase( item.getSlotLocation())) {
								found = true;
								System.out.println("Item found!"); // debugging purposes
								
								if (item.getQuantity() == 0) {
									System.out.println("Out of stock.");
								 
								 } else if (balance.compareTo(item.getPrice()) < 0) {
									System.out.println("Not enough money.");
								 
								 } else if (item.getQuantity() > 0  ) {	
									// take money out of users account 
									 
									 String logOutput = LocalDateTime.now() + " " + item.getProductName() + " " +
											 item.getSlotLocation() + " " + balance; 
									 
									balance = balance.subtract(item.getPrice());
									logOutput += " " + balance;
									log.write(logOutput);
									    // reduce stock by 1
									item.purchaseItem();
									System.out.println("You purchased " + item.getProductName()  + " for " + item.getPrice() + ".");
								    System.out.println("Your balance is " + balance + ".");
								    System.out.println(item.sound());
								    
								 }  // end of "else if"
							} // end of "if (fooChoiceSlot...
						} // end of "for" loop -Inventory		
						
						if (!found) {
							System.out.println("Not a valid choice.");
						}
						
					} else if (purchase.equals(purchase_menu_finish_transaction)) {
						CashOut cash = new CashOut();
						cash.calculateChange(balance);
						System.out.println("Thank you for shopping with us today!");

						// balance = intakeMoney.getMoney();  
						balance = new BigDecimal(0);
						System.out.println(" Final balance: " + balance );
						
						
						
						break;
					}
					//   intake.balance = new BigDecimal(0);
				}
				
			} else if (choice.equals(MAIN_MENU_END_PROGRAM)) {
				System.out.println("Thanks for shopping with us!");
				System.exit(1);
			}
		}
	}
		

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		// parseData();
		cli.run();
	}
}
