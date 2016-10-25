import com.senor.*;
import com.senor.exception.*;
import java.util.*;
import java.io.IOException;

public class main {
  public static void main(String[] args) {
    Color none = Color.None;

    main main = new main();

    main.colorTest();
    System.out.println(none.getANSI());

    main.stringBuilderTest();
    System.out.println(none.getANSI());

    main.psuedoRandomTest();
    System.out.println(none.getANSI());

    main.asciiShift();
    System.out.println(none.getANSI());

    main.unscrambleWords();
    System.out.println(none.getANSI());

    main.pngMorse();
    System.out.println(none.getANSI());

    main.passwordGenerator();
  }

  public void colorTest() {
    Color black = Color.Black;
    Color red = Color.Red;
    Color green = Color.Green;
    Color brown = Color.Brown;
    Color orange = Color.Orange;
    Color blue = Color.Blue;
    Color purple = Color.Purple;
    Color cyan = Color.Cyan;
    Color light_gray = Color.Light_Gray;
    Color dark_gray = Color.Dark_Gray;
    Color light_red = Color.Light_Red;
    Color light_green = Color.Light_Green;
    Color yellow = Color.Yellow;
    Color light_blue = Color.Light_Blue;
    Color light_purple = Color.Light_Purple;
    Color light_cyan = Color.Light_Cyan;
    Color white = Color.White;
    Color none = Color.None;

    System.out.println(black.getANSI()+"Black"+" "
        		+red.getANSI()+"Red"+" "
        		+green.getANSI()+"Green"+" "
        		+brown.getANSI()+"Brown"+" "
        		+orange.getANSI()+"Orange"+" "
        		+blue.getANSI()+"Blue"+" "
        		+purple.getANSI()+"Purple"+" "
        		+cyan.getANSI()+"Cyan"+" "
        		+light_gray.getANSI()+"Light Gray"+" "
        		+dark_gray.getANSI()+"Dark Gray"+" "
        		+light_red.getANSI()+"Light Red"+" "
        		+light_green.getANSI()+"Light Green"+" "
        		+yellow.getANSI()+"Yellow"+" "
        		+light_blue.getANSI()+"Light Blue"+" "
        		+light_purple.getANSI()+"Light Purple"+" "
        		+light_cyan.getANSI()+"Light Cyan"+" "
        		+white.getANSI()+"White"+" "
        		+none.getANSI()+"None"+" "
        		);
  }

  public void stringBuilderTest() {
    sbTest test = new sbTest();
    sbTest testTwo = new sbTest();
    
    String second = "Hello";
    String first = " World!";

    Color none = Color.None;
    System.out.print(none.getANSI());

    test.create(second);
    test.insert(first);
    System.out.println("Inserted: " + test.toString());

    test.replace(" Brandon!");
    System.out.println("Replaced: " + test.toString());

    System.out.println();

    testTwo.create("What's");
    testTwo.insert(" up?");
    System.out.println("Inserted: " + testTwo.toString());

    testTwo.replace(" down?");
    System.out.println("Replaced: " + testTwo.toString());

    System.out.println();
    System.out.println("Your new string is \"" + test.toString() + "\"");
    System.out.println("Your new string is \"" + testTwo.toString() + "\"");
  }

  public void psuedoRandomTest() {
    RandomGenerator random = new RandomGenerator();

    random.setMaximum(100);
    random.setMinimum(0);
    
    random.generateXNumbers(100);

    Color white = Color.White;
    Color red = Color.Light_Red;
    Color green = Color.Light_Green;
    Color blue = Color.Light_Blue;

    System.out.print(white.getANSI());
    System.out.print("Generated Number History: ");
    System.out.println(red.getANSI() + random.getHistory());
    System.out.println();
    
    System.out.print(white.getANSI());
    System.out.print("Math.random() History: ");
    System.out.println(green.getANSI() + random.getRawHistory());
    
    System.out.println();
    System.out.print(white.getANSI());
    System.out.println("Try and Fail Ranges: ");
    try {
      System.out.println(blue.getANSI() + random.getHistory(0,-1));
    } catch(IndexOutOfBoundsException e) {
      System.out.println(blue.getANSI() + "IndexOutOfBoundsException: " + e);
    } catch(InvalidRangeException e) {
      System.out.println(blue.getANSI() + "InvalidRangeException: " + e);
    }
    try {
      System.out.println(blue.getANSI() + random.getHistory(-2,-1));
    } catch(IndexOutOfBoundsException e) {
      System.out.println(blue.getANSI() + "IndexOutOfBoundsException: " + e);
    } catch(InvalidRangeException e) {
      System.out.println(blue.getANSI() + "InvalidRangeException: " + e);
    }

    System.out.println();
    System.out.print(white.getANSI());
    System.out.println("Successful Range (40-50): "); 
    try {
      System.out.println(blue.getANSI() + random.getHistory(40,50));
    } catch(IndexOutOfBoundsException e) {
      System.out.println(blue.getANSI() + "IndexOutOfBoundsException: " + e);
    } catch(InvalidRangeException e) {
      System.out.println(blue.getANSI() + "InvalidRangeException: " + e);
    }

    System.out.println();
    System.out.print(white.getANSI());
    System.out.println("Successful Range (40-40): "); 
    try {
      System.out.println(blue.getANSI() + random.getHistory(40,40));
    } catch(IndexOutOfBoundsException e) {
      System.out.println(blue.getANSI() + "IndexOutOfBoundsException: " + e);
    } catch(InvalidRangeException e) {
      System.out.println(blue.getANSI() + "InvalidRangeException: " + e);
    }
  }

  public void asciiShift() {
    Color white = Color.White;
    Color red = Color.Red;
    Color blue = Color.Light_Blue;

    ASCIIShift shift = new ASCIIShift();

    shift.setString("81*68*116*74*117*93*62*111*95*67*65*64*77*");
    shift.setShift(29);

    try {
      System.out.println(white.getANSI() + "String: " + blue.getANSI() + shift.getString());
      System.out.println(white.getANSI() + "Shift: " + blue.getANSI() + shift.getShift());
      System.out.println(white.getANSI() + "Decoded: " + blue.getANSI() + shift.decode());
      System.out.println(white.getANSI() + "Delimiter: " + blue.getANSI() + shift.getDelimiter());
      System.out.println();

      shift.setString(shift.decode());
      System.out.println(white.getANSI() + "String: " + blue.getANSI() + shift.getString());
      System.out.println(white.getANSI() + "Shift: " + blue.getANSI() + shift.getShift());
      System.out.println(white.getANSI() + "Encoded: " + blue.getANSI() + shift.encode());
      System.out.println(white.getANSI() + "Delimiter: " + blue.getANSI() + shift.getDelimiter());
    } catch(UnsetValueException e) {
      System.out.println(white.getANSI() + "UnsetValueException: " + red.getANSI() + e);
    }
  }
  
  public void unscrambleWords() {
    //This: eatnah,eydnsy,emcarl,dnistu,anjene,koioces,iangrvii,ifolmang,nmeniabj,llirke
    //Should Turn into This: athena,sydney,marcel,dustin,jeanne,cookies,virginia,flamingo,benjamin,killer

    Color white = Color.White;
    Color red = Color.Light_Red;
    Color green = Color.Light_Green;
    Color blue = Color.Light_Blue;

    ArrayList<String> scrambled = new ArrayList<String>();;
    scrambled.add("eatnah");
    scrambled.add("eydnsy");
    scrambled.add("emcarl");
    scrambled.add("dnistu");
    scrambled.add("anjene");
    scrambled.add("koioces");
    scrambled.add("iangrvii");
    scrambled.add("ifolmang");
    scrambled.add("nmeniabj");
    scrambled.add("llirke");

    try {
      Unscrambler unscrambled = new Unscrambler("wordlist.txt", scrambled); //I am using the wordlist from Hack This Site. I have to find out copyright or make my own.
      System.out.println(white.getANSI() + "Scrambled Words: " + red.getANSI() + unscrambled.getWords());
      System.out.println(white.getANSI() + "File: " + blue.getANSI() + unscrambled.getFile());
      System.out.println(white.getANSI() + "Unscrambled Words: " + green.getANSI() + unscrambled.unscrambleWords());
    } catch(IOException e) {
      System.out.println(red.getANSI() + e);
    }
  }

  public void pngMorse() {
    PNGMorse pngMorse = new PNGMorse();
    //pngMorse
  }

  public void passwordGenerator() {
    PasswordGenerator passwordGenerator = new PasswordGenerator();

    Color white = Color.White;
    Color green = Color.Light_Green;

    //I could change color depending on if good choice or not...
    System.out.println(white.getANSI() + "Numbers: " + green.getANSI() + passwordGenerator.getNumbers());
    System.out.println(white.getANSI() + "Symbols: " + green.getANSI() + passwordGenerator.getSymbols());
    System.out.println(white.getANSI() + "Uppercase: " + green.getANSI() + passwordGenerator.getUppercase());
    System.out.println(white.getANSI() + "Lowercase: " + green.getANSI() + passwordGenerator.getLowercase());
    System.out.println(white.getANSI() + "Digits: " + green.getANSI() + passwordGenerator.getDigits());

    System.out.println();

    System.out.println(white.getANSI() + "Password: " + green.getANSI() + passwordGenerator.generatePassword());

    passwordGenerator.generateXPasswords(99);
    System.out.println(white.getANSI() + "100 Passwords: " + green.getANSI() + passwordGenerator.getHistory());
  }
}
