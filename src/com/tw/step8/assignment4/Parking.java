package com.tw.step8.assignment4;

import java.util.ArrayList;

public class Parking {

  private final ArrayList<Vehicle> parkingSlot ;
  private int capacity;

  public Parking(int capacity) {
    this.capacity = capacity;
    this.parkingSlot =  new ArrayList<Vehicle>();
  }

  int park(Vehicle vehicle){
    parkingSlot.add(vehicle);
    return parkingSlot.indexOf(vehicle);
  }

  public boolean isLotAvailable() {
    return parkingSlot.size() < capacity;
  }
}
