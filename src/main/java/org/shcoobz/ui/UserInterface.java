package org.shcoobz.ui;

import org.shcoobz.cake.Flavour;
import org.shcoobz.shop.OrderDetail;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
  private Scanner scanner;

  public UserInterface() {
    this.scanner = new Scanner(System.in);
  }

  public void displayIntro() {
    displayCakeShopLogo();
    displayWelcomeMessage();
  }

  public void displayCakeShopLogo() {
    System.out.println("    ____            _                           _                    _     ____            _                 ");
    System.out.println("   |  _ \\          | |                         (_)                  | |   |  _ \\          | |                ");
    System.out.println("   | |_) |  _   _  | |_    ___   ______   ___   _   ____   ___    __| |   | |_) |   __ _  | | __   ___   ___ ");
    System.out.println("   |  _ <  | | | | | __|  / _ \\ |______| / __| | | |_  /  / _ \\  / _` |   |  _ <   / _` | | |/ /  / _ \\ / __|");
    System.out.println("   | |_) | | |_| | | |_  |  __/          \\__ \\ | |  / /  |  __/ | (_| |   | |_) | | (_| | |   <  |  __/ \\__ \\");
    System.out.println("   |____/   \\__, |  \\__|  \\___|          |___/ |_| /___|  \\___|  \\__,_|   |____/   \\__,_| |_|\\_\\  \\___| |___/");
    System.out.println("             __/ |                                                                                           ");
    System.out.println("            |___/                                                                                            ");

  }

  public void displayWelcomeMessage() {
    System.out.println("\nWelcome to the Cake Shop!");
  }

  public void displayMenu(boolean firstItemOrdered) {
    System.out.println("\n1. Pancake");
    System.out.println("2. Chimney Cake");
    if (firstItemOrdered) {
      System.out.println("3. Pay and Receive Order");
    }
  }

  public void displayFlavoursAndPrices() {
    System.out.println("\nAvailable Flavours:");
    for (Flavour flavour : Flavour.values()) {
      System.out.println((flavour.ordinal() + 1) + ". " + flavour.name() +
          " (Additional cost: " + flavour.getAdditionalCost() + ")");
    }
  }

  public void displayOrderDetails(OrderDetail order) {
    System.out.println(order.getCakeType() + " - " + order.getFlavour() +
        " - Cost: " + formatPrice(order.getCost()));
  }

  public void displayOrderSummary(List<OrderDetail> orders) {
    System.out.println("\nOrder Summary:");
    for (OrderDetail order : orders) {
      displayOrderDetails(order);
    }
  }

  public void displayTotalCost(String totalCost) {
    System.out.println("\nYour total is: " + totalCost);
  }

  private String formatPrice(int cents) {
    int euros = cents / 100;
    int remainingCents = cents % 100;
    return String.format("%d,%02d €", euros, remainingCents);
  }

  public int getUserChoice() {
    System.out.print("\nPlease select an option: ");
    return scanner.nextInt();
  }

  public Flavour getUserFlavourChoice() {
    displayFlavoursAndPrices();
    int flavourChoice = scanner.nextInt();
    return Flavour.values()[flavourChoice - 1];
  }

  public void closeScanner() {
    if (scanner != null) {
      scanner.close();
    }
  }

}
