package com.tw.step8.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {
  @Test
  void shouldParkACar() {
    Parking parking = new Parking(10);
    assertEquals(0, parking.park(Vehicle.CAR));
  }

  @Test
  void shouldReturnTrueWhenParkingSlotIsAvailable() {
    Parking parking = new Parking(10);
    assertTrue(parking.isLotAvailable());
  }

  @Test
  void shouldReturnFalseWhenParkingSlotIsNotAvailable() {
    Parking parking = new Parking(1);
    parking.park(Vehicle.CAR);
    assertFalse(parking.isLotAvailable());
  }
}