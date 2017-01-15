package me.osrecki.prog.java.ctci.chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:  Given a real number between O and 1 (e.g., 0.72) that is passed
 *            in as a double, print the binary representation. If the number
 *            cannot be represented accurately in binary with at most 32
 *            characters, print "ERROR."
 * Author:    Dinko Osrecki
 * Date:      15/01/2017
 */
public class Question2Test {
  @Test
  public void shouldPrintBinaryString() {
    Assert.assertEquals(evaluate(0.75), ".11");
    Assert.assertEquals(evaluate(0.5), ".1");
    Assert.assertEquals(evaluate(0.125), ".001");
  }

  @Test
  public void shouldPrintErrorForInvalidNumbers() {
    Assert.assertEquals(evaluate(-1), "ERROR");
    Assert.assertEquals(evaluate(1.5), "ERROR");
    Assert.assertEquals(evaluate(0.7), "ERROR");
  }

  private String evaluate(double number) {
    return Question2.toBinaryString(number);
  }
}
