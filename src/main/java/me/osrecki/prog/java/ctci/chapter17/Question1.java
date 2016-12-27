package me.osrecki.prog.java.ctci.chapter17;

/**
 * Question:  Write a function that adds two numbers. You should not use + or
 *            any arithmetic operators.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
public class Question1 {
  /**
   * Idea:  Use bitwise operations to add two numbers in a manner similar to
   *        that of the full adder. XORing two numbers means adding them without
   *        regard to carry. ANDing two numbers and then shifting means
   *        calculating the carry. Repeat the process until carry becomes zero.
   */
  public static int add(int a, int b) {
    if(b == 0) return a;

    return add(a ^ b, (a & b) << 1);
  }
}
