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

  public void create(String starter) { //Should I throw IndexOutOfBoundsException here?
    this.build = new StringBuilder();
    this.starter = starter;

    this.build.append(this.starter);
  }

  public void replace(String replacer) throws StringIndexOutOfBoundsException {
    this.replacer = replacer;
    this.build.replace(this.starter.length(), this.starter.length()+this.replacer.length(), this.replacer);
  }

  public void insert(String inserter) throws StringIndexOutOfBoundsException {
    this.inserter = inserter;
    this.build.insert(this.build.length(), this.inserter);
  }

  public String toString() {
    return this.build.toString();
  }
}
