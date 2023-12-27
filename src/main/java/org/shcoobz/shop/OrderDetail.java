package org.shcoobz.shop;

/**
 * Represents the details of a cake order.
 */
public class OrderDetail {
  private String cakeType;
  private String flavour;
  private int cost;

  /**
   * Constructor for OrderDetail.
   *
   * @param cakeType The type of cake.
   * @param flavour  The flavour of the cake.
   * @param cost     The cost of the cake.
   */
  public OrderDetail(String cakeType, String flavour, int cost) {
    this.cakeType = cakeType;
    this.flavour = flavour;
    this.cost = cost;
  }

  /**
   * Retrieves the type of cake for this order.
   *
   * @return A string representing the type of the cake in this order.
   */
  public String getCakeType() {
    return cakeType;
  }

  /**
   * Retrieves the flavour of the cake for this order.
   *
   * @return A string representing the flavour of the cake in this order.
   */
  public String getFlavour() {
    return flavour;
  }

  /**
   * Retrieves the cost of the cake for this order.
   *
   * @return An integer representing the cost of the cake in this order.
   */
  public int getCost() {
    return cost;
  }
}
