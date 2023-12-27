package org.shcoobz.oven;

import org.shcoobz.cake.Cake;
import org.shcoobz.cake.Flavour;

/**
 * Oven implementation for baking pancakes.
 */

public class PancakeOven implements Oven {
  private boolean hasOil;

  public PancakeOven(boolean hasOil) {
    this.hasOil = hasOil;
  }

  @Override
  public Cake bakeCake(Flavour flavour) {
    if (!hasOil) {
      throw new IllegalStateException("No oil available!"); // exception if no oil
    }

    return new Cake(flavour, 100); // pancake base price is 1 euro
  }
}

