package org.shcoobz.shop;

import org.shcoobz.cake.Cake;
import org.shcoobz.cake.Flavour;
import org.shcoobz.oven.Oven;
import org.shcoobz.oven.PancakeOven;

/**
 * Represents a cake shop that can sell different types of cakes.
 */

public class CakeShop {
  private int income;

  // constructor
  public CakeShop() {
    this.income = 0; // at beginning initialize with 0
  }

  private String capitalizeFirstLetter(String input) {
    if (input == null || input.isEmpty()) {
      return input;
    }
    return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
  }

  // determines type of cake based on oven used
  private String getCakeType(Oven oven) {
    return oven instanceof PancakeOven ? "Pancake" : "Chimney Cake";
  }

  // sells cake of specified flavour using provided oven
  // increments income based on cake's price
  public void sellCake(Oven oven, Flavour flavour) {
    String capitalizedFlavour = capitalizeFirstLetter(flavour.name());
    String cakeType = getCakeType(oven);

    try {
      Cake cake = oven.bakeCake(flavour);
      income += cake.getPrice();
      String priceInEuros = formatPrice(cake.getPrice());

      System.out.println(cakeType + " - " + capitalizedFlavour +
          " - " + priceInEuros);
    } catch (IllegalStateException e) {
      System.out.println("Sorry, cannot bake: " + cakeType + " - " + capitalizedFlavour +
          " - " + e.getMessage());
    }
  }

  // formats price in euros and cents
  private String formatPrice(int cents) {
    int euros = cents / 100;
    int remainingCents = cents % 100;

    return String.format("%d,%02d €", euros, remainingCents);
  }

  // gets total income of cake shop in a formatted string
  public String getIncome() {
    return formatPrice(income);
  }
}
