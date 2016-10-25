package com.senor;

import java.util.ArrayList;
import com.senor.exception.*;
import com.senor.RandomGenerator;

public class PasswordGenerator {
  //Default to True for Highest Security
  boolean numbers = true;
  boolean symbols = true;
  boolean uppercase = true;
  boolean lowercase = true;
  
  int digits;
  int x = 0;

  ArrayList<String> history = new ArrayList<String>();
  ArrayList<String> historyRange = new ArrayList<String>();
  ArrayList<Double> rawHistory = new ArrayList<Double>();
  ArrayList<Double> rawHistoryRange = new ArrayList<Double>();

  RandomGenerator random;

  public PasswordGenerator() {
    //Default to 64 for Very Good Security
    this.digits = 64;
  }
  
  //Support Numbers, Symbols, Uppercase, Lowercase
  //Take in Digits as Argument
  public PasswordGenerator(int digits) {
    this.digits = digits;
  }

  public PasswordGenerator(boolean numbers, boolean symbols, boolean uppercase, boolean lowercase) {
    this.digits = 64;
    this.numbers = numbers;
    this.symbols = symbols;
    this.uppercase = uppercase;
    this.lowercase = lowercase;
  }

  public PasswordGenerator(int digits, boolean numbers, boolean symbols, boolean uppercase, boolean lowercase) {
    this.digits = digits;
    this.numbers = numbers;
    this.symbols = symbols;
    this.uppercase = uppercase;
    this.lowercase = lowercase;
  }

  /*
  boolean numbers = true;
  boolean symbols = true;
  boolean uppercase = true;
  boolean lowercase = true;
  
  int digits;
  */
  public void setNumbers(boolean numbers) {
    this.numbers = numbers;
  }

  public boolean getNumbers() {
    return this.numbers;
  }

  public void setSymbols(boolean symbols) {
    this.symbols = symbols;
  }

  public boolean getSymbols() {
    return this.symbols;
  }

  public void setUppercase(boolean uppercase) {
    this.uppercase = uppercase;
  }

  public boolean getUppercase() {
    return this.uppercase;
  }

  public void setLowercase(boolean lowercase) {
    this.numbers = numbers;
  }

  public boolean getLowercase() {
    return this.lowercase;
  }

  public void setDigits(int digits) {
    this.digits = digits;
  }

  public int getDigits() {
    return this.digits;
  }

  public String generatePassword() {
    x++;
    this.random = new RandomGenerator();

    //Password Here

    this.rawHistory.add(this.random.getRaw());
    this.history.add("Password: " + this.x);
    return "Password: " + this.x;
  }

  public ArrayList<String> generateXPasswords(int x) {
    int y = 0;

    while(y<x) {
      this.generatePassword();
      y++;
    }
    return this.history;
  }

  public ArrayList<String> getHistory() {
    return this.history;
  }

  public ArrayList<String> getHistory(int start, int stop) throws InvalidRangeException, IndexOutOfBoundsException {
      this.historyRange.clear();

      if(stop >= start) {
        for(int x=start;x<=stop;x++) {
          this.historyRange.add(this.history.get(x));
        }
      } else {
        throw new InvalidRangeException("Start: " + start + " | " + "Stop: " + stop);
      }
      return this.historyRange;
  }

  //Below is Mostly for Debugging - Have At It
  public double getRaw() {
    return this.random.getRaw();
  }

  public ArrayList<Double> getRawHistory() {
    return this.rawHistory;
  }

  public ArrayList<Double> getRawHistory(int start, int stop) throws InvalidRangeException, IndexOutOfBoundsException {
    this.rawHistoryRange.clear();

    if(stop >= start) {
        for(int x=start;x<=stop;x++) {
          this.rawHistoryRange.add(this.rawHistory.get(x));
        }
      } else {
        throw new InvalidRangeException("Start: " + start + " | " + "Stop: " + stop);
      }
      return this.rawHistoryRange;
  }
}
