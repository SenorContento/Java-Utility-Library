package com.senor;

public class Colors {
    /*
      Black        0;30     Dark Gray     1;30
      Red          0;31     Light Red     1;31
      Green        0;32     Light Green   1;32
      Brown/Orange 0;33     Yellow        1;33
      Blue         0;34     Light Blue    1;34
      Purple       0;35     Light Purple  1;35
      Cyan         0;36     Light Cyan    1;36
      Light Gray   0;37     White         1;37
    */

    enum Color { Black(0, 30), Red(0, 31), Green(0, 32), Brown(0, 33),
    	Orange(0, 33), Blue(0, 34), Purple(0, 35),
    	Cyan(0, 36), Light_Gray(0, 37), Dark_Gray(1, 30),
    	Light_Red(1, 31), Light_Green(1, 32), Yellow(1, 33),
    	Light_Blue(1, 34), Light_Purple(1, 35), Light_Cyan(1, 36),
    	White(1, 37), None(0);

        private final String ANSI;

    	Color(int number, int number2) {
          this.ANSI = "\033[" + number + ";" + number2 + "m";
        }
        Color(int number) {
          this.ANSI = "\033[" + number + "m";
        }
    };
}
