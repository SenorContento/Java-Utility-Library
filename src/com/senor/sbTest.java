package com.senor;

import java.util.Scanner;

public class sbTest {
  public sbTest() {
    //Do Nothing!!!
  }

  String starter;
  String inserter;
  String replacer;
  StringBuilder build;

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
