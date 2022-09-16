package com.tw.step8.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

  @Test
  void shouldParkACar(){
    ParkingLot parking = new ParkingLot(10);
    assertEquals(Status.PARKED, parking.add(Vehicle.CAR));
  }

  @Test
  void shouldTellParkingIsNotAvailableWhileParking() {
    ParkingLot parking = new ParkingLot(0);
    assertEquals(Status.PARKING_NOT_AVAILABLE,parking.add(Vehicle.CAR));
  }

  @Test
  void shouldReturnFalseWhenParkingSlotIsNotFull() {
    ParkingLot parking = new ParkingLot(10);
    assertFalse(parking.isLotFull());
  }

  @Test
  void shouldReturnTrueWhenParkingSlotIsFull() {
    ParkingLot parking = new ParkingLot(1);
    parking.add(Vehicle.CAR);
    assertTrue(parking.isLotFull());
  }

  @Test
  void shouldReturnFalseWhenParkingLotIsNoT80PercentFull() {
    ParkingLot parking = new ParkingLot(2);
    parking.add(Vehicle.CAR);
    assertFalse(parking.isEightyPercentFull());
  }

  @Test
  void shouldReturnTrueWhenParkingLotIs80PercentFull() {
    ParkingLot parkingLot = new ParkingLot(5);
    parkingLot.add(Vehicle.CAR);
    parkingLot.add(Vehicle.CAR);
    parkingLot.add(Vehicle.CAR);
    parkingLot.add(Vehicle.CAR);
    assertTrue(parkingLot.isEightyPercentFull());
  }
}