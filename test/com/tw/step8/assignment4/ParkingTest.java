package com.tw.step8.assignment4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {

  @Test
  void shouldParkACar() {
    ParkingLot parkingLot = new ParkingLot("P1",10);
    ArrayList<ParkingLot> parkingLots = new ArrayList<>();
    parkingLots.add(parkingLot);
    Parking parking = new Parking(parkingLots);
    assertEquals(Status.PARKED, parking.park());
  }

  @Test
  void shouldReturnTrueIfEachParkingLotsAreEightyPercentFull() {
    ParkingLot parkingLot1 = new ParkingLot("P1",1);
    ParkingLot parkingLot2 = new ParkingLot("P1",1);

    parkingLot1.add();
    parkingLot2.add();

    ArrayList<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(parkingLot1,parkingLot2));

    Parking parking = new Parking(parkingLots);
    assertTrue(parking.areEightyPercentFull());
  }

  @Test
  void shouldReturnFalseIfEachParkingLotsAreNotEightyPercentFull() {
    ParkingLot parkingLot1 = new ParkingLot("P1",6);
    ParkingLot parkingLot2 = new ParkingLot("P1",1);

    parkingLot1.add();
    parkingLot2.add();

    ArrayList<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(parkingLot1,parkingLot2));

    Parking parking = new Parking(parkingLots);
    assertFalse(parking.areEightyPercentFull());
  }
}