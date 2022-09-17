package com.tw.step8.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {
  @Test
  void shouldNotifyObservers() {
    Notifier notifier = new Notifier();
    final String[] message = new String[2];
    notifier.add(new Notifiable() {
      @Override
      public void notify(String parkingLotId, Status status) {
        message[0] = parkingLotId;
        message[1] = status.name();
      }
    });

    notifier.notifyObservers("P1", Status.LOT_FULL);
    String[] expectedMessage = new String[]{"P1", "LOT_FULL"};

    assertArrayEquals(expectedMessage,message);
  }
}