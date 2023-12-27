package org.shcoobz;

import org.shcoobz.cake.Flavour;
import org.shcoobz.oven.ChimneyCakeOven;
import org.shcoobz.oven.PancakeOven;
import org.shcoobz.shop.CakeShop;

public class Main {
  public static void main(String[] args) {
    CakeShop shop = new CakeShop();
    PancakeOven pancakeOven = new PancakeOven(true);
    PancakeOven pancakeOvenWithoutOil = new PancakeOven(false);
    ChimneyCakeOven chimneyCakeOven = new ChimneyCakeOven();

    System.out.println("Sold:");

    // selling pancakes
    shop.sellCake(pancakeOven, Flavour.PLAIN);
    shop.sellCake(pancakeOven, Flavour.VANILLA);
    shop.sellCake(pancakeOven, Flavour.CHOCOLATE);
    shop.sellCake(pancakeOven, Flavour.STRAWBERRY);

    System.out.println("");

    // selling pancake - no oil
    shop.sellCake(pancakeOvenWithoutOil, Flavour.PLAIN);

    System.out.println("");

    // selling chimney cakes
    shop.sellCake(chimneyCakeOven, Flavour.PLAIN);
    shop.sellCake(chimneyCakeOven, Flavour.VANILLA);
    shop.sellCake(chimneyCakeOven, Flavour.CHOCOLATE);
    shop.sellCake(chimneyCakeOven, Flavour.STRAWBERRY);

    System.out.println("\nTotal: " + shop.getIncome());
  }
}