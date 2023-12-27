package org.shcoobz.shop;

import org.shcoobz.cake.Cake;
import org.shcoobz.cake.Flavour;
import org.shcoobz.oven.Oven;
import org.shcoobz.oven.PancakeOven;

/**
 * Represents a cake shop that can sell different types of cakes.
 */

public class CakeShop {
  private int price;

  // constructor
  public CakeShop() {
    this.price = 0; // at beginning initialize with 0
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
  public OrderDetail sellCake(Oven oven, Flavour flavour) {
    String capitalizedFlavour = capitalizeFirstLetter(flavour.name());
    String cakeType = getCakeType(oven);

    try {
      Cake cake = oven.bakeCake(flavour);
      price += cake.getPrice();

      return new OrderDetail(cakeType, capitalizedFlavour, cake.getPrice());
    } catch (IllegalStateException e) {
      // Handle exception
      return null;
    }
  }

  // formats price in euros and cents
  private String formatPrice(int cents) {
    int euros = cents / 100;
    int remainingCents = cents % 100;

    return String.format("%d,%02d €", euros, remainingCents);
  }

  // gets total income of cake shop in a formatted string
  public String getCost() {
    return formatPrice(price);
  }
}
