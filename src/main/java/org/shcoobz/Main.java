package org.shcoobz;

import org.shcoobz.cake.Flavour;
import org.shcoobz.oven.Oven;
import org.shcoobz.shop.CakeShop;
import org.shcoobz.shop.OrderManager;
import org.shcoobz.shop.OvenFactory;
import org.shcoobz.ui.UserInterface;

/**
 * Main class for the Cake Shop application.
 * Orchestrates the flow of the application by integrating all components.
 */
public class Main {

  /**
   * The entry point for the Cake Shop application.
   * <p>
   * This method sets up the necessary components for the cake shop, including the shop itself,
   * the order manager, oven factory, and user interface. It handles the user interactions for
   * choosing and processing cake orders and displays the summary and total cost at the end.
   *
   * @param args Command line arguments (not used in this application).
   */
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

  /**
   * Determines and returns the appropriate oven based on the user's choice.
   * <p>
   * This method allows the user to select between different types of ovens.
   * Returns a PancakeOven if the choice is 1, a ChimneyCakeOven if the choice is 2, or null otherwise.
   *
   * @param choice The user's choice of oven. Expected to be 1 for PancakeOven, 2 for ChimneyCakeOven.
   * @param pancakeOven The PancakeOven instance to be returned if the choice is 1.
   * @param chimneyCakeOven The ChimneyCakeOven instance to be returned if the choice is 2.
   * @return The selected Oven instance based on the choice, or null if the choice is neither 1 nor 2.
   */
  private static Oven getSelectedOven(int choice, Oven pancakeOven, Oven chimneyCakeOven) {
    return choice == 1 ? pancakeOven : (choice == 2 ? chimneyCakeOven : null);
  }
}


