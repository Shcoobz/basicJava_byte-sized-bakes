package org.shcoobz.shop;

import org.shcoobz.cake.Flavour;
import org.shcoobz.oven.Oven;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the ordering process in the cake shop.
 */
public class OrderManager {
  private final CakeShop shop;
  private final List<OrderDetail> orders;

  /**
   * Constructs an OrderManager associated with a specific CakeShop.
   * Initializes the list of orders managed by this OrderManager.
   *
   * @param shop The CakeShop that this OrderManager will manage orders for.
   */
  public OrderManager(CakeShop shop) {
    this.shop = shop;
    this.orders = new ArrayList<>();
  }

  /**
   * Processes an order for a cake baked in the specified oven with the given flavour.
   *
   * @param oven    The oven to bake the cake.
   * @param flavour The flavour of the cake.
   */
  public void processOrder(Oven oven, Flavour flavour) {
    OrderDetail order = shop.sellCake(oven, flavour);
    if (order != null) {
      orders.add(order);
    }
  }

  /**
   * Retrieves the list of orders that have been processed by this OrderManager.
   *
   * @return A list of {@link OrderDetail} instances representing all the orders managed by this OrderManager.
   */
  public List<OrderDetail> getOrders() {
    return orders;
  }
}