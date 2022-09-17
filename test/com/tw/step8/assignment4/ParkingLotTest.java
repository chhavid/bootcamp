package com.tw.step8.assignment4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

  @Test
  void shouldParkACar() {

    Notifier notifier = new Notifier();
    ParkingLot parking = new ParkingLot("P1", 10, notifier);
    assertEquals(Status.PARKED, parking.add());
  }

  @Test
  void shouldTellParkingIsNotAvailableWhileParking() {
    Notifier notifier = new Notifier();
    ParkingLot parking = new ParkingLot("P1", 0, notifier);
    assertEquals(Status.PARKING_NOT_AVAILABLE, parking.add());
  }

  @Test
  void shouldReturnFalseWhenParkingSlotIsNotFull() {
    Notifier notifier = new Notifier();
    ParkingLot parking = new ParkingLot("P1", 10, notifier);
    assertFalse(parking.isLotFull());
  }

  @Test
  void shouldReturnTrueWhenParkingSlotIsFull() {
    Notifier notifier = new Notifier();
    ParkingLot parking = new ParkingLot("P1", 1, notifier);
    parking.add();
    assertTrue(parking.isLotFull());
  }

  @Test
  void shouldReturnFalseWhenParkingLotIsNoT80PercentFull() {
    Notifier notifier = new Notifier();
    ParkingLot parking = new ParkingLot("P1", 2, notifier);
    parking.add();
    assertFalse(parking.isEightyPercentFull());
  }

  @Test
  void shouldReturnTrueWhenParkingLotIs80PercentFull() {
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = new ParkingLot("P1", 5, notifier);
    parkingLot.add();
    parkingLot.add();
    parkingLot.add();
    parkingLot.add();
    assertTrue(parkingLot.isEightyPercentFull());
  }

  @Test
  void shouldReturnTrueWhenParkingLotLessThanTwentyPercent() {
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = new ParkingLot("P1", 6, notifier);
    parkingLot.add();
    assertTrue(parkingLot.isLessThanTwentyPercentFull());
  }

  @Test
  void shouldReturnFalseWhenParkingLotMoreThanTwentyPercent() {
    Notifier notifier = new Notifier();
    ParkingLot parkingLot = new ParkingLot("P1", 4, notifier);
    parkingLot.add();
    assertFalse(parkingLot.isLessThanTwentyPercentFull());
  }
}