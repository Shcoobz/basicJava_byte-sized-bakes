package org.shcoobz.shop;

import org.shcoobz.oven.Oven;
import org.shcoobz.oven.ChimneyCakeOven;
import org.shcoobz.oven.PancakeOven;

/**
 * Factory class for creating different types of ovens.
 */
public class OvenFactory {

  /**
   * Creates a new PancakeOven.
   *
   * @param hasOil Indicates if the oven has oil.
   * @return A new instance of PancakeOven.
   */
  public Oven createPancakeOven(boolean hasOil) {
    return new PancakeOven(hasOil);
  }

  /**
   * Creates a new ChimneyCakeOven.
   *
   * @return A new instance of ChimneyCakeOven.
   */
  public Oven createChimneyCakeOven() {
    return new ChimneyCakeOven();
  }
}