package org.shcoobz.oven;

import org.shcoobz.cake.Cake;
import org.shcoobz.cake.Flavour;

/**
 * Oven implementation for baking pancakes.
 */
public class PancakeOven implements Oven {
  private boolean hasOil;

  /**
   * Constructs a PancakeOven instance.
   *
   * @param hasOil Indicates whether the oven has oil for baking pancakes.
   */
  public PancakeOven(boolean hasOil) {
    this.hasOil = hasOil;
  }

  /**
   * Bakes a cake with the specified flavour.
   * If there is no oil in the oven, an IllegalStateException is thrown.
   *
   * @param flavour The flavour of the cake to be baked.
   * @return A new Cake instance with the specified flavour and a base price.
   * @throws IllegalStateException if there is no oil in the oven.
   */
  @Override
  public Cake bakeCake(Flavour flavour) {
    if (!hasOil) {
      throw new IllegalStateException("No oil available!");
    }

    return new Cake(flavour, 100);
  }
}

