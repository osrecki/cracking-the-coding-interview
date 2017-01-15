package me.osrecki.prog.java.ctci.chapter5;

/**
 * Question:  Explain what the following code does: ( ( n & ( n-1)) == 0).
 * Author:    Dinko Osrecki
 * Date:      15/01/2017
 */
public class Question5 {
  static boolean isPowerOfTwo(int number) {
    return (number & (number - 1)) == 0;
  }
}
