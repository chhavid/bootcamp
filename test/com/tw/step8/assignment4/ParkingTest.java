package com.tw.step8.assignment4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {

  @Test
  void shouldParkACar() {
    ParkingLot parkingLot = new ParkingLot(10);
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    parkingLots.add(parkingLot);
    Parking parking = new Parking(parkingLots);
    assertEquals(Status.PARKED, parking.park(Vehicle.CAR));
  }
}