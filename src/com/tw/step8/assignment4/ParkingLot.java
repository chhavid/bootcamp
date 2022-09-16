package com.tw.step8.assignment4;

public class ParkingLot {

  private int filledSlots;
  private int capacity;

  public ParkingLot(int capacity) {
    this.capacity = capacity;
    this.filledSlots = 0;
  }

  Status add(Vehicle vehicle){
    if(isLotFull()){
      return Status.PARKING_NOT_AVAILABLE;
    }
    this.filledSlots++;
    return Status.PARKED;
  }

  public boolean isLotFull() {
    return filledSlots >= capacity;
  }

  public boolean isEightyPercentFull() {
    return filledSlots >= 0.8 * capacity;
  }
}
