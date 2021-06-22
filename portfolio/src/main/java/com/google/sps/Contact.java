package com.google.sps;

public final class Contact {

  private final String userName;
  private final String userEmail;
  private final String userSMS;
  private final String userDate;

  public Contact(String userName, String userEmail, String userSMS, String userDate) {
    this.userName = userName;
    this.userEmail = userEmail;
    this.userSMS = userSMS;
    this.userDate = userDate;
  }
}