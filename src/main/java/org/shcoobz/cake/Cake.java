package org.shcoobz.cake;

/**
 * Represents a cake with a specific flavour and base price.
 * The total price of the cake includes the base price and the additional cost of the flavour.
 */

public record Cake(Flavour flavour, int basePrice) {

  // calc total price of cake
  public int getPrice() {
    return basePrice + flavour.getAdditionalCost();
  }
}
