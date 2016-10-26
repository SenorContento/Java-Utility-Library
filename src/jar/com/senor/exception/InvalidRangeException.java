package com.senor.exception;

public class InvalidRangeException extends Exception
{
  public InvalidRangeException() {}

  public InvalidRangeException(String message)
  {
    super(message);
  }
}
