package org.shcoobz.cake;

/**
 * Enum representing different flavours of cake.
 * Each flavour has an associated additional cost.
 */
public enum Flavour {
  PLAIN(0),
  VANILLA(30),
  CHOCOLATE(40),
  STRAWBERRY(55);

  private int additionalCost; // Field to store the additional cost

  /**
   * Constructor for the Flavour enum.
   *
   * @param additionalCost The additional cost associated with this flavour.
   */
  Flavour(int additionalCost) {
    this.additionalCost = additionalCost;
  }

  /**
   * Retrieves the additional cost associated with this cake flavour.
   *
   * @return The additional cost as an integer.
   */
  public int getAdditionalCost() {
    return additionalCost;
  }
}
