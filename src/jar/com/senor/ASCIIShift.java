package com.senor;

//import java.util.regex.Pattern;
import com.senor.exception.UnsetValueException;

public class ASCIIShift {
  //Rename variables for clarity!!!
  String text; //What I need to do is (1) Determine if StringBuilder is better in this instance and (2) if so, fix it.
  int shift;
  int delimiter;
  String decoded; //Same Here
  String encoded;
  String[] stringArray; //Same Here (But Maybe ArrayList)
  String split;

  public ASCIIShift() {
    //Do Nothing!
  }

  public ASCIIShift(int shift, String text) {
    this.shift = shift;
    this.text = text;
  }

  public void setShift(int shift) {
    this.shift = shift;
  }

  public void setString(String text) {
    this.text = text;
  }

  public int getShift() {
    return this.shift;
  }

  public String getString() {
    return this.text;
  }

  public String getDelimiter() throws UnsetValueException { //Is this really necessary (UnsetValueException), If I could get it to not force the try statement on the programmer for such a small exception.
    if(this.split == null) {
      throw new UnsetValueException("getDelimiter: You need to run decode() or setDelimiter(String delimiter) first!");
    } else {
      return this.split;
    }
  }

  public void setDelimiter(String split) { //Useful for encode method
    this.split = split;
  }

  public String decode() throws NumberFormatException {
      this.decoded = "";

      for(int x=0; x < this.text.length(); x++) {
        if(!(this.text.charAt(x) >= '0' && this.text.charAt(x) <= '9')) { //Basically loops until it finds a non-numerical character. Only 1 type is in the string!!!
          this.delimiter = x;
        }
      }

      this.split = this.text.substring(this.delimiter,this.delimiter+1);
      this.stringArray = this.text.split("\\" + this.split); //This line of code causes a lot of problems when dealing with unknown delimiters in which you don't even know the position of the first one!!! To make things worse, some delimiters mess around with regex, so you must make it treat the delimiter literally!!!

      for(int x=0; x < this.stringArray.length; x++) {
        this.decoded += (char) (Integer.parseInt(this.stringArray[x]) - this.shift);
      }

      return this.decoded;
  }

  public String encode() throws NumberFormatException, UnsetValueException {
      this.encoded = "";
      if(this.split == null) {
        throw new UnsetValueException("encode: You need to run decode() or setDelimiter(String delimiter) first!");
      }

      for(int x=0; x < this.text.length(); x++) {
        this.encoded += (this.text.charAt(x) + this.shift) + this.split;
      }

      return this.encoded;
  }
}
