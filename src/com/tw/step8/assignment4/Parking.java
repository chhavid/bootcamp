package com.tw.step8.assignment4;

import java.util.ArrayList;

public class Parking {
  private final ArrayList<ParkingLot> parkingLots;

  public Parking(ArrayList<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public Status park(Vehicle vehicle) {
    for (ParkingLot parkingLot : this.parkingLots) {
      if (!parkingLot.isLotFull()){
        return parkingLot.add(vehicle);
      }
    }
    return Status.PARKING_NOT_AVAILABLE;
  }
}
