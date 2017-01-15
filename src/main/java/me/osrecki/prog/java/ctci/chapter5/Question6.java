package me.osrecki.prog.java.ctci.chapter5;

/**
 * Question:  Write a function to determine the number of bits you would need
 *            to flip to convert integer A to integer B.
 * Author:    Dinko Osrecki
 * Date:      15/01/2017
 */
public class Question6 {
  /**
   * Idea:  XOR a and b, and count number of bits set to 1.
   */
  public static int flipBits(int a, int b) {
    int count = 0;
    for (int c = a ^ b; c != 0; c = c >> 1) {
      if ((c & 1) == 1)
        count++;
    }

    return count;
  }

  /**
   * Idea:  XOR a and b, and clear lowest significant bit from resulting
   *        number, until it becomes zero.
   */
  public static int flipBits2(int a, int b) {
    int count = 0;
    for (int c = a ^ b; c != 0; c = c & (c - 1)) {
      count++;
    }

    return count;
  }
}
