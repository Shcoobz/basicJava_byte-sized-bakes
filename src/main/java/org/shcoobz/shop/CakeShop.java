package org.shcoobz.shop;

import org.shcoobz.cake.Cake;
import org.shcoobz.cake.Flavour;
import org.shcoobz.oven.Oven;
import org.shcoobz.oven.PancakeOven;

/**
 * Represents a cake shop capable of selling different types of cakes.
 */
public class CakeShop {
  private int price;

  /**
   * Constructor for CakeShop.
   */
  public CakeShop() {
    this.price = 0;
  }

  /**
   * Sells a cake of the specified flavour using the provided oven.
   * Increments income based on the cake's price.
   *
   * @param oven    The oven to use for baking the cake.
   * @param flavour The flavour of the cake.
   * @return An OrderDetail object representing the sold cake; null if an exception occurs.
   */
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

  /**
   * Formats the price in euros and cents.
   *
   * @param cents The price in cents.
   * @return The formatted price as a string.
   */
  private String formatPrice(int cents) {
    int euros = cents / 100;
    int remainingCents = cents % 100;

    return String.format("%d,%02d €", euros, remainingCents);
  }

  /**
   * Retrieves the total income of the cake shop in a formatted string.
   *
   * @return The total income formatted as a string.
   */
  public String getCost() {
    return formatPrice(price);
  }

  /**
   * Determines the type of cake based on the oven used. This method checks if the oven is an instance
   * of PancakeOven or ChimneyCakeOven and returns the corresponding cake type.
   *
   * @param oven The oven object to check its type.
   * @return A string representing the type of cake. Returns "Pancake" if the oven is an instance of
   *         PancakeOven, and "Chimney Cake" otherwise.
   */
  private String getCakeType(Oven oven) {
    return oven instanceof PancakeOven ? "Pancake" : "Chimney Cake";
  }

  /**
   * Capitalizes the first letter of a given string and makes the rest of the letters lowercase.
   * If the input string is null or empty, it returns the original input.
   *
   * @param input The string to be modified.
   * @return The modified string with the first letter capitalized and the rest in lowercase.
   *         Returns the original string if it is null or empty.
   */
  private String capitalizeFirstLetter(String input) {
    if (input == null || input.isEmpty()) {
      return input;
    }
    return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
  }
}
