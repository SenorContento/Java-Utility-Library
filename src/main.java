import com.senor.*;
import com.senor.exception.*;

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
    Random random = new Random();
    int x = 0;

    random.setMaximum(100);
    random.setMinimum(0);
    while(x<100) {
      random.generateNumber();
      x++;
    }

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
      System.out.println(white.getANSI() + "Decoded: " + blue.getANSI() + shift.decode());
      System.out.println(white.getANSI() + "Delimiter: " + blue.getANSI() + shift.getDelimiter());
      System.out.println();

      shift.setString(shift.decode());
      System.out.println(white.getANSI() + "String: " + blue.getANSI() + shift.getString());
      System.out.println(white.getANSI() + "Encoded: " + blue.getANSI() + shift.encode());
      System.out.println(white.getANSI() + "Delimiter: " + blue.getANSI() + shift.getDelimiter());
    } catch(UnsetValueException e) {
      System.out.println(white.getANSI() + "UnsetValueException: " + red.getANSI() + e);
    }
  }
}
