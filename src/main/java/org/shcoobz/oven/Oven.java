package org.shcoobz.oven;

import org.shcoobz.cake.Cake;
import org.shcoobz.cake.Flavour;

/**
 * Interface representing an oven that can bake cakes.
 */

public interface Oven {
  //  bakes a cake with the specified flavour
  Cake bakeCake(Flavour flavour);
}
