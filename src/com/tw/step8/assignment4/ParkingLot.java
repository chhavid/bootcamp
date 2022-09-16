package com.tw.step8.assignment4;

import java.util.ArrayList;

public class ParkingLot {

  private int filledSlots;
  private String id;
  private int capacity;

  public ParkingLot(String id, int capacity) {
    this.id = id;
    this.capacity = capacity;
    this.filledSlots = 0;
  }

//  public ArrayList<Status> getStatus(){
//    ArrayList<Status> statusList = new ArrayList<>();
//    if(isLotFull()){
//      statusList.add(Status.LOT_FULL);
//    }
//    if(isEightyPercentFull()){
//      statusList.add(Status.EIGHTY_PERCENT_FILLED);
//    }
//    if(isLessThanTwentyPercentFull()){
//      statusList.add(Status.TWENTY_PERCENT_FILLED);
//    }
//    return statusList;
//  }

  Status add(){
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

  public boolean isLessThanTwentyPercentFull() {
    return filledSlots <= 0.2 * capacity;
  }
}
