package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.SpaceNotAvailableException;

import java.util.ArrayList;

public class Parking {

  private final ArrayList<Vehicle> parkingSlot ;
  private int capacity;

  public Parking(int capacity) {
    this.capacity = capacity;
    this.parkingSlot =  new ArrayList<Vehicle>();
  }

  int park(Vehicle vehicle) throws SpaceNotAvailableException {
    if(isLotFull()){
      throw new SpaceNotAvailableException(this.capacity);
    }
    parkingSlot.add(vehicle);
    return parkingSlot.indexOf(vehicle);
  }

  public boolean isLotFull() {
    return parkingSlot.size() >= capacity;
  }
}
