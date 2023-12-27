package org.shcoobz.shop;

public class OrderDetail {
  private String cakeType;
  private String flavour;
  private int cost;

  public OrderDetail(String cakeType, String flavour, int cost) {
    this.cakeType = cakeType;
    this.flavour = flavour;
    this.cost = cost;
  }

  public String getCakeType() {
    return cakeType;
  }

  public String getFlavour() {
    return flavour;
  }

  public int getCost() {
    return cost;
  }
}
