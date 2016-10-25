public class Unscrambler {
  ArrayList<String> words = new ArrayList<String>();
  ArrayList<String> unscrambled = new ArrayList<String>();
  String file;

  public Unscrambler() {
    //Do Nothing!
  }

  public Unscrambler(String[] words) {
    this.words = words;
  }

  public void setWords(String[] words) {
    this.words = words;
  }

  public void addWords(String word) {
    //this.words
  }

  public void setFile(String file) {
    this.file = file;
  }

  public ArrayList<String> unscrambleWords() throws IOException {
      for(int x=0; x < wordCount; x++) { //Pick a word from the scrambled words pile
        for(String line : Files.readAllLines(Paths.get(this.file))) { //Pick a line from the wordlist
          if(line.length() == word[x].length()) {
            boolean match = true;
            for(int y=0; y < word[x].length(); y++) { //Iterate through characters in word in wordlist
              int count = word[x].length() - word[x].replace(word[x].substring(y,y+1), "").length();
              int count2 = line.length() - line.replace(word[x].substring(y,y+1), "").length();
              //Both counts need to match for every character to be valid!!!
              if(count != count2) {
                match = false;
                break;
              }

              if(y == line.length() - 1 && match == true) {
                if(x != wordCount - 1) {
                  System.out.print(line + ",");
                } else {
                  System.out.println(line);
                }
              }
            }
          }
        }
      }

    return unscrambled;
  }
}
