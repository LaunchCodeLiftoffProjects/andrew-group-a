package org.launchcode.andrewgroupa.Exceptions;


public class DuplicateUser extends RuntimeException {

  public DuplicateUser(String message) {
    super(message);
  }

  public DuplicateUser(String message, Throwable cause) {
    super(message, cause);
  }
}
