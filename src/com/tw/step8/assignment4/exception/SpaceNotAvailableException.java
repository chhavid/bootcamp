package com.tw.step8.assignment4.exception;

public class SpaceNotAvailableException extends Throwable {
  public SpaceNotAvailableException(int capacity) {
    super(String.format("Space not available for parking. All %s slots are filled", capacity));
  }
}
