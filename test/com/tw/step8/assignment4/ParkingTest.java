package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.SpaceNotAvailableException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {
  @Test
  void shouldThrowExceptionForParkWhenAllSlotsAreFilled() {
    Parking parking = new Parking(0);
    assertThrows(SpaceNotAvailableException.class,()-> parking.park(Vehicle.CAR));
  }

  @Test
  void shouldParkACar() throws SpaceNotAvailableException {
    Parking parking = new Parking(10);
    assertEquals(0, parking.park(Vehicle.CAR));
  }

  @Test
  void shouldReturnFalseWhenParkingSlotIsNotFull() {
    Parking parking = new Parking(10);
    assertFalse(parking.isLotFull());
  }

  @Test
  void shouldReturnTrueWhenParkingSlotIsFull() throws SpaceNotAvailableException {
    Parking parking = new Parking(1);
    parking.park(Vehicle.CAR);
    assertTrue(parking.isLotFull());
  }
}