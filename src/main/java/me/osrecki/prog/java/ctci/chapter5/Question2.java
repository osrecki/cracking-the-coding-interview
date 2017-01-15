package me.osrecki.prog.java.ctci.chapter5;

/**
 * Question:  Given a real number between O and 1 (e.g., 0.72) that is passed
 *            in as a double, print the binary representation. If the number
 *            cannot be represented accurately in binary with at most 32
 *            characters, print "ERROR."
 * Author:    Dinko Osrecki
 * Date:      15/01/2017
 */
class Question2 {
  static String toBinaryString(double number) {
    if (number <= 0 || number >= 1)
      return "ERROR";

    StringBuilder binary = new StringBuilder(".");
    while (number > 0) {
      if (binary.length() > 32)
        return "ERROR";

      double result = number * 2;
      if(result >= 1) {
        binary.append(1);
        number = result - 1;
      } else {
        binary.append(0);
        number = result;
      }
    }

    return binary.toString();
  }
}
