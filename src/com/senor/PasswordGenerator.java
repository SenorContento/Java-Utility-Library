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
  int count = 0; //Temporary, will remove

  ArrayList<String> history = new ArrayList<String>();
  ArrayList<String> historyRange = new ArrayList<String>();
  ArrayList<Double> rawHistory = new ArrayList<Double>();
  ArrayList<Double> rawHistoryRange = new ArrayList<Double>();

  RandomGenerator random;

  String password; //Change to Characters

  char[] symbolsArray = {'!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/',':',';','<','=','>','?','@','[','\\',']','^','_','`'}; //This is to make randomly picking symbols easier.

  char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; //Doesn't matter case as I will choose it during generation time.

  //Should I make an extended alphabet array?

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
    count++;
    double generatedNumber;
    this.password = "";
    this.random = new RandomGenerator(0,100);
    RandomGenerator numeral = new RandomGenerator(0,9);
    RandomGenerator chooseSymbol = new RandomGenerator(0,this.symbolsArray.length-1);
    RandomGenerator chooseLetter = new RandomGenerator(0,this.alphabet.length-1);

    //I seriously need to find a better way to generate passwords. This can cause a headache!
    for(int x=0; x < this.digits; x++) {
      generatedNumber = this.random.generateNumber();
      if(generatedNumber <= 25) { //Numbers
        if(this.numbers) {
          this.password += (int) numeral.generateNumber();
        } else if(this.symbols) {
            this.password += this.symbolsArray[(int) chooseSymbol.generateNumber()];
        } else if(this.uppercase) {
            this.password += Character.toUpperCase(this.alphabet[(int) chooseLetter.generateNumber()]);
        } else if(this.lowercase) {
            this.password += Character.toLowerCase(this.alphabet[(int) chooseLetter.generateNumber()]);
        }
      } else if(generatedNumber > 25 && generatedNumber <= 50) { //Symbols
          if(this.symbols) {
            this.password += this.symbolsArray[(int) chooseSymbol.generateNumber()];          
          } else if(this.numbers) {
              this.password += (int) numeral.generateNumber();
          } else if(this.uppercase) {
              this.password += Character.toUpperCase(this.alphabet[(int) chooseLetter.generateNumber()]);
          } else if(this.lowercase) {
              this.password += Character.toLowerCase(this.alphabet[(int) chooseLetter.generateNumber()]);
          }
      } else if(generatedNumber > 50 && generatedNumber < 75) { //Uppercase
          if(this.uppercase) {
            this.password += Character.toUpperCase(this.alphabet[(int) chooseLetter.generateNumber()]);
          } else if(this.symbols) {
              this.password += this.symbolsArray[(int) chooseSymbol.generateNumber()];
          } else if(this.numbers) {
              this.password += (int) numeral.generateNumber();
          } else if(this.lowercase) {
              this.password += Character.toLowerCase(this.alphabet[(int) chooseLetter.generateNumber()]);
          }
      } else if(generatedNumber >= 75) { //Lowercase
          if(this.lowercase) {
            this.password += Character.toLowerCase(this.alphabet[(int) chooseLetter.generateNumber()]);
          } else if(this.numbers) {
              this.password += (int) numeral.generateNumber();
          } else if(this.uppercase) {
              this.password += Character.toUpperCase(this.alphabet[(int) chooseLetter.generateNumber()]);
          } else if(this.symbols) {
              this.password += this.symbolsArray[(int) chooseSymbol.generateNumber()];
          }
      }
    }

    this.rawHistory.add(this.random.getRaw());
    this.history.add(this.password);
    return this.password;
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
