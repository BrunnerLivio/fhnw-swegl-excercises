package com.swegl.app;

public class Deliverer {
  private int boxes;
  private int capacityPerBox;
  private int totalOrders;
  private boolean onTheRoad;

  public Deliverer(int boxes, int capacityPerBox) {
    this.boxes = boxes;
    this.capacityPerBox = capacityPerBox;
  }

  public int getBoxes() {
    return boxes;
  }

  public int totalCapacity() {
    return boxes * capacityPerBox;
  }

  public int getRemainingCapacity() {
    return totalCapacity() - totalOrders;
  }

  public boolean isOnTheRoad() {
    return onTheRoad;
  }

  public void setOnTheRoad(boolean onTheRoad) {
    this.onTheRoad = onTheRoad;
  }

  public boolean addDelivery(int orders) {
    if (onTheRoad) {
      return false;
    }
    if (getRemainingCapacity() >= orders) {
      totalOrders += orders;
      return true;
    }
    return false;
  }
}
