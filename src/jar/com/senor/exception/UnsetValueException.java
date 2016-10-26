package com.senor.exception;

public class UnsetValueException extends Exception
{
  public UnsetValueException() {}

  public UnsetValueException(String message)
  {
    super(message);
  }
}
