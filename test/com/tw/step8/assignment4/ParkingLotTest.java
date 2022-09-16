package com.tw.step8.assignment4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

  @Test
  void shouldParkACar(){
    ParkingLot parking = new ParkingLot("P1", 10);
    assertEquals(Status.PARKED, parking.add());
  }

  @Test
  void shouldTellParkingIsNotAvailableWhileParking() {
    ParkingLot parking = new ParkingLot("P1", 0);
    assertEquals(Status.PARKING_NOT_AVAILABLE,parking.add());
  }

  @Test
  void shouldReturnFalseWhenParkingSlotIsNotFull() {
    ParkingLot parking = new ParkingLot("P1", 10);
    assertFalse(parking.isLotFull());
  }

  @Test
  void shouldReturnTrueWhenParkingSlotIsFull() {
    ParkingLot parking = new ParkingLot("P1", 1);
    parking.add();
    assertTrue(parking.isLotFull());
  }

  @Test
  void shouldReturnFalseWhenParkingLotIsNoT80PercentFull() {
    ParkingLot parking = new ParkingLot("P1", 2);
    parking.add();
    assertFalse(parking.isEightyPercentFull());
  }

  @Test
  void shouldReturnTrueWhenParkingLotIs80PercentFull() {
    ParkingLot parkingLot = new ParkingLot("P1", 5);
    parkingLot.add();
    parkingLot.add();
    parkingLot.add();
    parkingLot.add();
    assertTrue(parkingLot.isEightyPercentFull());
  }

@Test
  void shouldReturnTrueWhenParkingLotLessThanTwentyPercent() {
    ParkingLot parkingLot = new ParkingLot("P1", 6);
    parkingLot.add();
    assertTrue(parkingLot.isLessThanTwentyPercentFull());
  }

@Test
  void shouldReturnFalseWhenParkingLotMoreThanTwentyPercent() {
    ParkingLot parkingLot = new ParkingLot("P1", 4);
    parkingLot.add();
    assertFalse(parkingLot.isLessThanTwentyPercentFull());
  }


  @Test
  void shouldGiveStatusOfParkingSlot() {
    ParkingLot parkingLot = new ParkingLot("P1", 7);
    parkingLot.add();
    ArrayList<Status> actualStatusList = new ArrayList<Status>();

    assertTrue(parkingLot.isEightyPercentFull());
  }
}