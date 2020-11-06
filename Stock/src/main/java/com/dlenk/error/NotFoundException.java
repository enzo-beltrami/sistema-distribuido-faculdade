package com.dlenk.error;

public class NotFoundException extends BaseException {

  public NotFoundException(String message) {
    super("Not found", message, 404);
  }
}