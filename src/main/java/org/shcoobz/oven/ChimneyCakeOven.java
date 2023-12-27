package org.shcoobz.oven;

import org.shcoobz.cake.Cake;
import org.shcoobz.cake.Flavour;

public class ChimneyCakeOven implements Oven{
  /**
   * Oven implementation for baking chimney cakes.
   */

  @Override
  public Cake bakeCake(Flavour flavour) {
    return new Cake(flavour, 200); // chimney cake base price is 2 euros
  }
}
