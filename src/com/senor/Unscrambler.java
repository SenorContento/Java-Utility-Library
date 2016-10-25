package com.senor;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;

//Add support for multiple possible matches!!!

public class Unscrambler {
  ArrayList<String> words = new ArrayList<String>();
  ArrayList<String> unscrambled = new ArrayList<String>();
  String file;

  public Unscrambler() {
    //Do Nothing!
  }

  public Unscrambler(ArrayList<String> words) {
    this.words = words;
  }

  public Unscrambler(String file, ArrayList<String> words) {
    this.file = file;
    this.words = words;
  }

  public void setWords(ArrayList<String> words) {
    this.words = words;
  }

  public ArrayList<String> getWords() {
    return this.words;
  }

  public void addWords(String word) {
    this.words.add(word);
  }

  public void removeWord(int position) {
    this.words.remove(position);
  }

  public void removeWord(String word) {
    for(int x = 0; x < this.words.size(); x++) //This is to remove all occurences of the same word from the list
      this.words.remove(word);
  }

  public void setFile(String file) {
    this.file = file;
  }

  public String getFile() {
    return this.file;
  }

  public ArrayList<String> getUnscrambledWords() {
    return this.unscrambled;
  }

  public ArrayList<String> unscrambleWords() throws IOException {
      this.unscrambled.clear();

      for(int x=0; x < this.words.size(); x++) { //Pick a word from the scrambled words pile
        for(String line : Files.readAllLines(Paths.get(this.file))) { //Pick a line from the wordlist
          if(line.length() == this.words.get(x).length()) {
            boolean match = true;
            for(int y=0; y < this.words.get(x).length(); y++) { //Iterate through characters in word in wordlist
              int count = this.words.get(x).length() - this.words.get(x).replace(this.words.get(x).substring(y,y+1), "").length();
              int count2 = line.length() - line.replace(this.words.get(x).substring(y,y+1), "").length();
              //Both counts need to match for every character to be valid!!!
              if(count != count2) {
                match = false;
                break;
              }

              if(y == line.length() - 1 && match == true) {
                this.unscrambled.add(line);
              }
            }
          }
        }
      }

    return this.unscrambled;
  }
}
