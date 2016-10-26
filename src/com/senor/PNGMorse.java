package com.senor;

import java.awt.image.*;
import javax.imageio.*;
import java.nio.file.*;
import java.io.*;
import java.util.ArrayList;
import com.senor.exception.*;

public class PNGMorse {
  String file;
  int width, height;
  ArrayList<ArrayList<Integer>> imagePixels = new ArrayList<ArrayList<Integer>>();
  ArrayList<Character> morse = new ArrayList<Character>();  

  public PNGMorse() {
    //Do Nothing!
  }

  public void setFile(String file) {
    this.file = file;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public void setWidth() {
    this.width = width;
  }

  public void setHeight() {
    this.height = height;
  }

  public ArrayList<ArrayList<Integer>> readImage() throws IOException {
    BufferedImage img = ImageIO.read(new File(this.file));
    this.width = img.getWidth();
    this.height = img.getHeight();
    ArrayList<Integer> arrayWidth = null; //For Internal Array

    for(int y=0; y < this.height; y++) {
      arrayWidth = new ArrayList<Integer>();
      for(int x=0; x < this.width; x++) {
        arrayWidth.add(img.getRGB(x, y));
      }
      this.imagePixels.add(arrayWidth);
    }

    return this.imagePixels;
  }

  public ArrayList<Character> readMorseFromImage() {
    morse.clear();

    int morse0;
    int morse1 = 0;

    for(int y=0; y < this.height; y++) {
      for(int x=0; x < width; x++) {         
        if(this.imagePixels.get(y).get(x) == -1) { //-1 is White Pixel
          morse0 = morse1;
          morse1 = x+(y*this.width);

          morse.add((char) (morse1-morse0));
        }
      }
    }

    return this.morse;
  }

  /*public String readMorseFromImage(ArrayList<ArrayList<String>> imagePixels) { //Maybe I will Implement This. Hadn't Decided Yet!
    return this.morse;
  }*/

  public ArrayList<Character> morseToASCII() throws InvalidInputException {
    ArrayList<Character> morseCharacter = new ArrayList<Character>();
    ArrayList<Character> asciiWord = new ArrayList<Character>();

    for(int x=0; x < this.morse.size(); x++) {
      if(this.morse.get(x).equals(' ')) {
        asciiWord.add(readMorseCharacter(morseCharacter));
        morseCharacter.clear();
      } else if(this.morse.get(x).equals('.')) {
        morseCharacter.add('.');
      } else if(this.morse.get(x).equals('-')) {
        morseCharacter.add('-');
      } else {
        throw new InvalidInputException("You sure this is morse? '" + this.morse.get(x) + "' does not equal '-', '.', or ' '!!!");
      }
    }

    return asciiWord;
  }

  public char readMorseCharacter(ArrayList<Character> morseCharacter) throws InvalidInputException { //Should I Use Enum Instead? Probably? Will Chhange It Later, Trying to Get Working Code Now
    char ASCIIChar = 0;
    
    StringBuilder character = new StringBuilder();

    for(int x=0; x < morseCharacter.size(); x++) {
      character.append(morseCharacter.get(x));
    }

    switch(character.toString()) {
      case ".-": ASCIIChar = 'A';
                 break;
      case "-...": ASCIIChar = 'B';
                 break;
      case "-.-.": ASCIIChar = 'C';
                 break;
      case "-..": ASCIIChar = 'D';
                 break;
      case ".": ASCIIChar = 'E';
                 break;
      case "..-.": ASCIIChar = 'F';
                 break;
      case "--.": ASCIIChar = 'G';
                 break;
      case "....": ASCIIChar = 'H';
                 break;
      case "..": ASCIIChar = 'I';
                 break;
      case ".---": ASCIIChar = 'J';
                 break;
      case "-.-": ASCIIChar = 'K';
                 break;
      case ".-..": ASCIIChar = 'L';
                 break;
      case "--": ASCIIChar = 'M';
                 break;
      case "-.": ASCIIChar = 'N';
                 break;
      case "---": ASCIIChar = 'O';
                 break;
      case ".--.": ASCIIChar = 'P';
                 break;
      case "--.-": ASCIIChar = 'Q';
                 break;
      case ".-.": ASCIIChar = 'R';
                 break;
      case "...": ASCIIChar = 'S';
                 break;
      case "-": ASCIIChar = 'T';
                 break;
      case "..-": ASCIIChar = 'U';
                 break;
      case "...-": ASCIIChar = 'V';
                 break;
      case ".--": ASCIIChar = 'W';
                 break;
      case "-..-": ASCIIChar = 'X';
                 break;
      case "-.--": ASCIIChar = 'Y';
                 break;
      case "--..": ASCIIChar = 'Z';
                 break;

      case "-----": ASCIIChar = '0';
                 break;
      case ".----": ASCIIChar = '1';
                 break;
      case "..---": ASCIIChar = '2';
                 break;
      case "...--": ASCIIChar = '3';
                 break;
      case "....-": ASCIIChar = '4';
                 break;
      case ".....": ASCIIChar = '5';
                 break;
      case "-....": ASCIIChar = '6';
                 break;
      case "--...": ASCIIChar = '7';
                 break;
      case "---..": ASCIIChar = '8';
                 break;
      case "----.": ASCIIChar = '9';
                 break;

      //Below is just icing on the cake for the HTS mission (this was originally designed for Hack This Site)!!!
      //Below may cause problems with real usage (mostly due to ambiguity)

      case ".-.-": ASCIIChar = 'Ä';
                 break;
      case ".--.-": ASCIIChar = 'Á';
                 break;
      case "----": ASCIIChar = 'Ĥ';
                 break;
      case "..-..": ASCIIChar = 'É';
                 break;
      case "--.--": ASCIIChar = 'Ñ';
                 break;
      case "---.": ASCIIChar = 'Ö';
                 break;
      case "..--": ASCIIChar = 'Ü';
                 break;

      case ".-.-.-": ASCIIChar = '.';
                 break;
      case "--..--": ASCIIChar = ',';
                 break;
      case "---...": ASCIIChar = ':'; //Colon
                 break;
      case "..--..": ASCIIChar = '?';
                 break;
      case ".----.": ASCIIChar = '\''; //Apostrophe
                 break;
      case "-....-": ASCIIChar = '-'; //Hyphen or dash
                 break;
      case "-..-.": ASCIIChar = '/';
                 break;
      case "-.--.-": ASCIIChar = '('; //( or ). May cause problems due to ambiguity, had it been more than icing I would write a function that would determine which one by looking farther back into the string.
                 break;
      case ".-..-.": ASCIIChar = '"';
                 break;
      case ".--.-.": ASCIIChar = '@';
                 break;
      case "-...-": ASCIIChar = '=';
                 break;
      default: throw new InvalidInputException("ERROR: Unknown morse character '" + character.toString() + "'!!!");
    }
    
    return ASCIIChar;
  }

  public String asciiToMorse() {
    return "Not Implemented";
  }

  /*public void writeImage(ArrayList<ArrayList<Integer>> pixels) throws IOException { //I will write a method to produce these images!
    BufferedImage img = ImageIO.write(RENDERED_IMAGE_HERE,"PNG",new File(this.file));
    ArrayList<Integer> arrayWidth = null; //For Internal Array
  }*/
}
/*
              morse0 = morse1;
              morse1 = x+(y*maxX);
              morse = morse + png.decToASCII(morse1-morse0);
            } else {
              whiteOffset = "(" + x + "," + y + ")";

              morse1 = x+(y*maxX);
              morse = "" + png.decToASCII(morse1);
            }

            System.out.print(NONE+"W");
          } else {
            System.out.println(LIGHT_BLUE+"RGB: " + pixelRGB);
          }
        }
        System.out.println(); //For Forcing Newline
*/
