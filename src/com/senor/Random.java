package com.senor;

import java.util.ArrayList;
import com.senor.exception.*;

public class Random {
  double minimum, maximum, number, raw;
  ArrayList<Double> history = new ArrayList<Double>();
  ArrayList<Double> historyRange = new ArrayList<Double>();
  ArrayList<Double> rawHistory = new ArrayList<Double>();
  ArrayList<Double> rawHistoryRange = new ArrayList<Double>();


  public Random() {
    //Do Nothing!
  }
  public Random(double minimum, double maximum) {
    this.minimum = minimum;
    this.maximum = maximum;
  }


  public void setMinimum(double minimum) {
    this.minimum = minimum;
  }
  public void setMaximum(double maximum) {
    this.maximum = maximum;
  }

  public double getMinimum() {
    return this.minimum;
  }
  public double getMaximum() {
    return this.maximum;
  }

  public double generateNumber() {
    this.raw = Math.random();
    this.number = this.minimum + (this.raw * ((this.maximum - this.minimum) + 1));

    this.rawHistory.add(this.raw);
    this.history.add(this.number);

    return this.number;
  }

  public ArrayList<Double> getHistory() {
    return this.history;
  }

  public ArrayList<Double> getHistory(int start, int stop) throws InvalidRangeException, IndexOutOfBoundsException {
      this.historyRange.clear();

      if(stop >= start) {
        for(int x=start;x<=stop;x++) {
          this.historyRange.add(this.history.get(x));
        }
      } else {
        throw new InvalidRangeException("Start: " + start + " | " + "Stop: " + stop);
      }
      return this.historyRange;
  }

  //Below is Mostly for Debugging - Have At It
  public double getRaw() {
    return this.raw;
  }

  public ArrayList<Double> getRawHistory() {
    return this.rawHistory;
  }

  public ArrayList<Double> getRawHistory(int start, int stop) throws InvalidRangeException, IndexOutOfBoundsException {
    this.rawHistoryRange.clear();

    if(stop >= start) {
        for(int x=start;x<=stop;x++) {
          this.rawHistoryRange.add(this.rawHistory.get(x));
        }
      } else {
        throw new InvalidRangeException("Start: " + start + " | " + "Stop: " + stop);
      }
      return this.rawHistoryRange;
  }
}
