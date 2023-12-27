package org.shcoobz.shop;

import org.shcoobz.cake.Flavour;
import org.shcoobz.oven.Oven;
import org.shcoobz.shop.CakeShop;
import org.shcoobz.shop.OrderDetail;
import org.shcoobz.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
  private final CakeShop shop;
  private final List<OrderDetail> orders;

  public OrderManager(CakeShop shop) {
    this.shop = shop;
    this.orders = new ArrayList<>();
  }

  public void processOrder(Oven oven, Flavour flavour) {
    OrderDetail order = shop.sellCake(oven, flavour);
    if (order != null) {
      orders.add(order);
    }
  }

  public List<OrderDetail> getOrders() {
    return orders;
  }
}