package org.shcoobz;

import org.shcoobz.cake.Flavour;
import org.shcoobz.oven.Oven;
import org.shcoobz.shop.CakeShop;
import org.shcoobz.shop.OrderManager;
import org.shcoobz.shop.OvenFactory;
import org.shcoobz.ui.UserInterface;

public class Main {

  public static void main(String[] args) {
    CakeShop shop = new CakeShop();
    OrderManager orderManager = new OrderManager(shop);
    OvenFactory ovenFactory = new OvenFactory();
    UserInterface ui = new UserInterface();

    Oven pancakeOven = ovenFactory.createPancakeOven(true);
    Oven chimneyCakeOven = ovenFactory.createChimneyCakeOven();
    boolean firstItemOrdered = false;

    ui.displayIntro();

    while (true) {
      ui.displayMenu(firstItemOrdered);
      int choice = ui.getUserChoice();

      if (firstItemOrdered && choice == 3) {
        break;
      }

      Oven selectedOven = getSelectedOven(choice, pancakeOven, chimneyCakeOven);
      if (selectedOven != null) {
        Flavour selectedFlavour = ui.getUserFlavourChoice();
        orderManager.processOrder(selectedOven, selectedFlavour);
        firstItemOrdered = true;
      }
    }
    ui.displayOrderSummary(orderManager.getOrders());
    ui.displayTotalCost(shop.getCost());
    ui.closeScanner();
  }

  private static Oven getSelectedOven(int choice, Oven pancakeOven, Oven chimneyCakeOven) {
    return choice == 1 ? pancakeOven : (choice == 2 ? chimneyCakeOven : null);
  }
}


