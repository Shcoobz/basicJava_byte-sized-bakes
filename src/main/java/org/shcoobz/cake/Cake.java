package org.shcoobz.cake;

/**
 * Represents a cake with a specific flavour and base price.
 * The total price of the cake includes the base price and the additional cost of the flavour.
 */
public record Cake(Flavour flavour, int basePrice) {

  /**
   * Calculates and returns the total price of the cake.
   *
   * @return The total price as an integer, summing the base price and the additional cost of the flavour.
   */
  public int getPrice() {
    return basePrice + flavour.getAdditionalCost();
  }
}
