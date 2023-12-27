package org.shcoobz.shop;

import org.shcoobz.oven.Oven;
import org.shcoobz.oven.ChimneyCakeOven;
import org.shcoobz.oven.PancakeOven;

public class OvenFactory {

  public Oven createPancakeOven(boolean hasOil) {
    return new PancakeOven(hasOil);
  }

  public Oven createChimneyCakeOven() {
    return new ChimneyCakeOven();
  }
}