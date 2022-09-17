package com.tw.step8.assignment4;

import java.util.ArrayList;

public class Notifier {
  private final ArrayList<Notifiable> observers;

    public Notifier() {
      this.observers = new ArrayList<Notifiable>();
    }

    public void add(Notifiable observer) {
      observers.add(observer);
    }

    public void notifyObservers(String parkingLotId, Status status) {
      for (Notifiable observer : observers) {
        observer.notify(parkingLotId, status);
      }
    }
}
