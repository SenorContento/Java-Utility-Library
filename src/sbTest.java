import java.util.Scanner;

public class sbTest {
  public sbTest() {
    //Do Nothing!!!
  }

  String starter;
  String inserter;
  String replacer;
  StringBuilder build;

  public static void main(String[] args) {
    sbTest test = new sbTest();
    //sbTest testTwo = new sbTest();
    
    //String second = "hello";
    //String first = " world!";
    
    Scanner input = new Scanner(System.in);

    System.out.print("Please insert the first word: ");
    String first = input.next();
    
    System.out.print("Please insert the second word: ");
    String second = input.next();

    test.create(second);
    test.insert(' ' + first); //Space without the direct hex code!
    test.replace((char) 0x20 + first); //Because "(char) 0x20" is totally valid!

    System.out.println(test.toString());

    /*
    test.create(input.next());
    test.insert(input.next());
    System.out.println("Inserted: " + test.toString());

    test.replace(input.next());
    System.out.println("Replaced: " + test.toString());

    System.out.println();

    StringBuilder buildTwo = new StringBuilder();
    testTwo.create("what's");
    testTwo.insert(" up?");
    System.out.println("Inserted: " + testTwo.toString());

    testTwo.replace(" down?");
    System.out.println("Replaced: " + testTwo.toString());

    System.out.println();
    System.out.println("Your new string is \"" + test.toString() + "\"");
    System.out.println("Your new string is \"" + testTwo.toString() + "\"");
    */
  }

  public void create(String starter) {
    this.build = new StringBuilder();
    this.starter = starter;

    this.build.append(this.starter);
  }

  public void replace(String replacer) {
    this.replacer = replacer;

    try {
      this.build.replace(this.starter.length(), this.starter.length()+this.replacer.length(), this.replacer);
    } catch(Exception e) {
      System.out.println("(Replacer) Exception: " + e);
    }
  }

  public void insert(String inserter) {
    this.inserter = inserter;

    try {
      //System.out.println(this.starter.length() + ", " + this.inserter + ", " +  0 + ", " +  this.inserter.length());
      this.build.insert(this.build.length(), this.inserter);
    } catch(Exception e) {
      System.out.println("(Inserter) Exception: " + e);
    }
  }

  public String toString() {
    return this.build.toString();
  }
}
