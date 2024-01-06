package org.shcoobz.ui;

import org.shcoobz.cake.Flavour;
import org.shcoobz.shop.OrderDetail;

import java.util.List;
import java.util.Scanner;

/**
 * Manages the user interface for the cake shop application.
 */
public class UserInterface {
  private Scanner scanner;

  /**
   * Constructor for UserInterface.
   * Initializes a new Scanner object for handling user input.
   */
  public UserInterface() {
    this.scanner = new Scanner(System.in);
  }

  /**
   * Displays the introductory message of the cake shop application.
   * This includes displaying the cake shop logo and a welcome message.
   */
  public void displayIntro() {
    displayCakeShopLogo();
    displayWelcomeMessage();
  }

  /**
   * Displays the ASCII art logo of the cake shop.
   */
  public void displayCakeShopLogo() {
    System.out.println("    ____            _                           _                    _   ");
    System.out.println("   |  _ \\          | |                         (_)                  | |  ");
    System.out.println("   | |_) |  _   _  | |_    ___   ______   ___   _   ____   ___    __| |  ");
    System.out.println("   |  _ <  | | | | | __|  / _ \\ |______| / __| | | |_  /  / _ \\  / _` |  ");
    System.out.println("   | |_) | | |_| | | |_  |  __/          \\__ \\ | |  / /  |  __/ | (_| |  ");
    System.out.println("   |____/   \\__, |  \\__|  \\___|          |___/ |_| /___|  \\___|  \\__,_|  ");
    System.out.println("             __/ |                                                        ");
    System.out.println("            |___/                                                         ");
    System.out.println("                  ____            _                                       ");
    System.out.println("                 |  _ \\          | |                                      ");
    System.out.println("                 | |_) |   __ _  | | __   ___   ___                      ");
    System.out.println("                 |  _ <   / _` | | |/ /  / _ \\ / __|                     ");
    System.out.println("                 | |_) | | (_| | |   <  |  __/ \\__ \\                     ");
    System.out.println("                 |____/   \\__,_| |_|\\_\\  \\___| |___/                     ");
    System.out.println("                                                                         ");
    System.out.println("                                                                         ");
  }

  /**
   * Displays a welcome message to the user.
   */
  public void displayWelcomeMessage() {
    System.out.println("\nWelcome to the Cake Shop!");
  }

  /**
   * Displays the main menu options to the user.
   * The menu options include selecting the type of cake and, after the first item is ordered,
   * the option to pay and receive the order.
   *
   * @param firstItemOrdered Indicates whether the first item has been ordered,
   *                         to decide whether to show the pay option.
   */
  public void displayMenu(boolean firstItemOrdered) {
    System.out.println("\n1. Pancake");
    System.out.println("2. Chimney Cake");
    if (firstItemOrdered) {
      System.out.println("3. Pay and Receive Order");
    }
  }

  /**
   * Displays the available cake flavours and their additional costs.
   */
  public void displayFlavoursAndPrices() {
    System.out.println("\nAvailable Flavours:");
    for (Flavour flavour : Flavour.values()) {
      System.out.println((flavour.ordinal() + 1) + ". " + flavour.name() +
          " (Additional cost: " + flavour.getAdditionalCost() + ")");
    }
  }

  /**
   * Prompts the user to select an option from the menu and reads their input.
   *
   * @return The integer choice entered by the user.
   */
  public int getUserChoice() {
    System.out.print("\nPlease select an option: ");
    return scanner.nextInt();
  }

  /**
   * Displays the available flavours and prices, then reads the user's flavour choice.
   *
   * @return The selected Flavour enum value based on the user's input.
   */
  public Flavour getUserFlavourChoice() {
    displayFlavoursAndPrices();
    int flavourChoice = scanner.nextInt();
    return Flavour.values()[flavourChoice - 1];
  }

  /**
   * Displays the details of a specific order, including cake type, flavour, and cost.
   *
   * @param order The OrderDetail object representing the order to be displayed.
   */
  public void displayOrderDetails(OrderDetail order) {
    System.out.println(order.getCakeType() + " - " + order.getFlavour() +
        " - Cost: " + formatPrice(order.getCost()));
  }

  /**
   * Displays a summary of all orders, showing details of each order.
   *
   * @param orders A list of OrderDetail objects representing all the orders made.
   */
  public void displayOrderSummary(List<OrderDetail> orders) {
    System.out.println("\nOrder Summary:");
    for (OrderDetail order : orders) {
      displayOrderDetails(order);
    }
  }

  /**
   * Displays the total cost of all orders.
   *
   * @param totalCost The formatted string representing the total cost.
   */
  public void displayTotalCost(String totalCost) {
    System.out.println("\nYour total is: " + totalCost);
  }

  /**
   * Formats the given price in cents to a string in euros and cents.
   *
   * @param cents The price in cents.
   * @return A string representing the formatted price in euros and cents.
   */
  private String formatPrice(int cents) {
    int euros = cents / 100;
    int remainingCents = cents % 100;
    return String.format("%d,%02d €", euros, remainingCents);
  }

  /**
   * Closes the Scanner object used for reading user input.
   */
  public void closeScanner() {
    if (scanner != null) {
      scanner.close();
    }
  }
}
