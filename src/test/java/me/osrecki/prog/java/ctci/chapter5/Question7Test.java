package me.osrecki.prog.java.ctci.chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:  Write a program to swap odd and even bits in an integer with as
 *            few instructions as possible (e.g., bit 0 and bit 1 are swapped,
 *            bit 2 and bit 3 are swapped, and so on).
 * Author:    Dinko Osrecki
 * Date:      15/01/2017
 */
public class Question7Test {
  @Test
  public void shouldSwapOddAndEvenBits() {
    Assert.assertEquals(evaluate(0), 0);
    Assert.assertEquals(evaluate(1), 2);
    Assert.assertEquals(evaluate(45), 30);
  }

  private int evaluate(int number) {
    return Question7.swapBits(number);
  }
}
