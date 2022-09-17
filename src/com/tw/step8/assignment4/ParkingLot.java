package com.tw.step8.assignment4;

public class ParkingLot {

  private int filledSlots;
  private String id;
  private int capacity;
  private Notifier notifier;

  public ParkingLot(String id, int capacity, Notifier notifier) {
    this.id = id;
    this.capacity = capacity;
    this.notifier = notifier;
    this.filledSlots = 0;
  }

  private void notifyStaff(){
    if(isLotFull()){
      notifier.notifyObservers(id,Status.LOT_FULL);
    }
    if(isEightyPercentFull()){
      notifier.notifyObservers(id, Status.EIGHTY_PERCENT_FILLED);
    }
    if(isLessThanTwentyPercentFull()){
      notifier.notifyObservers(id, Status.TWENTY_PERCENT_FILLED);
    }
  }

  Status add(){
    if(isLotFull()){
      return Status.PARKING_NOT_AVAILABLE;
    }

    this.filledSlots++;
    notifyStaff();
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
