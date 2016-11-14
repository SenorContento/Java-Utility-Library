package com.senor;

//public class Colors {
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

    //https://en.wikipedia.org/wiki/ANSI_escape_code
    //It looks like I have a lot of work to do!
    //I may just only currently support codes that my terminal supports (for now), but I should add support for raw code handling so I can add them on the fly without recompiling this program.
    /*
      Blue(1, 34) - Light Blue
      Blue(2, 34) - Faint Blue
      Blue(3, 34) - Italic Blue
      Blue(3, 1, 34) - Italic Light Blue
      Red(4, 31) - Single Underline Red
      Purple(7, 35) - Flip Background and Foreground Purple
      Green(8, 32) - Concealed Green
      Brown(9, 33) - Crossed Out Brown
    */

    /* Test

      21 	Bold: off or Underline: Double 	Bold off not widely supported; double underline hardly ever supported.
      22 	Normal color or intensity 	Neither bold nor faint
      23 	Not italic, not Fraktur 	
      24 	Underline: None 	Not singly or doubly underlined
      25 	Blink: off 	
      	
      27 	Image: Positive 	
      28 	Reveal 	conceal off
      29 	Not crossed out 	
    */

    public enum Color { Black(0, 30), Red(0, 31), Green(0, 32), Brown(0, 33),
    	Orange(0, 33), Blue(0, 34), Purple(0, 35),
    	Cyan(0, 36), Light_Gray(0, 37), Dark_Gray(1, 30),
    	Light_Red(1, 31), Light_Green(1, 32), Yellow(1, 33),
    	Light_Blue(1, 34), Light_Purple(1, 35), Light_Cyan(1, 36),
    	White(1, 37), None(0),

        BG_Black(0, 40), BG_Red(21, 41), BG_Green(0, 42), BG_Brown(0, 43),
    	BG_Orange(0, 43), BG_Blue(0, 44), BG_Purple(0, 45),
    	BG_Cyan(0, 46), BG_Light_Gray(0, 47), BG_Dark_Gray(1, 40),
    	BG_Light_Red(1, 41), BG_Light_Green(1, 42), BG_Yellow(1, 43),
    	BG_Light_Blue(1, 44), BG_Light_Purple(1, 45), BG_Light_Cyan(1, 46),
    	BG_White(1, 47);

        private String ANSI;

        private Color(int number, int number2, int number3) {
          this.ANSI = "\033[" + number + ";" + number2 + ";" + number3 + "m";
        }
    	private Color(int number, int number2) {
          this.ANSI = "\033[" + number + ";" + number2 + "m";
        }
        private Color(int number) {
          this.ANSI = "\033[" + number + "m";
        }
        
        public String getANSI() {
          return this.ANSI;
        }

        /* Figure out how to set raw rgb and sgr parameters - may have to change from enum to class to do this!
        public String getANSIRAW(int number1, int number2, int number3) {
          return this.ANSI;
        }*/
    };
//}
