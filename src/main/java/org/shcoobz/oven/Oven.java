package org.shcoobz.oven;

import org.shcoobz.cake.Cake;
import org.shcoobz.cake.Flavour;

/**
 * Interface representing an oven that can bake cakes.
 */
public interface Oven {

  /**
   * Bakes a cake with the specified flavour.
   *
   * @param flavour The flavour of the cake to be baked.
   * @return A Cake instance baked in this oven.
   */
  Cake bakeCake(Flavour flavour);
}
