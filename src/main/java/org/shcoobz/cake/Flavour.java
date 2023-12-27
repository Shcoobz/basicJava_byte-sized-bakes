package org.shcoobz.cake;

/**
 * Enum for representing different flavours of cake.
 * Each flavour has an associated additional cost.
 */

public enum Flavour {
  PLAIN(0),
  VANILLA(30),
  CHOCOLATE(40),
  STRAWBERRY(55);

  private int additionalCost; // Field to store the additional cost

  // constructor for the Flavour enum
  Flavour(int additionalCost) {
    this.additionalCost = additionalCost;
  }

  // gets additional cost associated with cake flavour
  public int getAdditionalCost() {
    return additionalCost;
  }
}
