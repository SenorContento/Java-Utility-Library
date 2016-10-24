import com.senor.sbTest;

public class test {
  public static void main(String[] args) {
    sbTest test = new sbTest();
    sbTest testTwo = new sbTest();
    
    String second = "Hello";
    String first = " World!";

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
}
