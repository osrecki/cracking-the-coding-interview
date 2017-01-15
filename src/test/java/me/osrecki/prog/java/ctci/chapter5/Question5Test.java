package me.osrecki.prog.java.ctci.chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:  Explain what the following code does: ( ( n & ( n-1)) == 0).
 * Author:    Dinko Osrecki
 * Date:      15/01/2017
 */
public class Question5Test {
  @Test
  public void shouldBeAPowerOfTwo() {
    Assert.assertTrue(evaluate(1));
    Assert.assertTrue(evaluate(2));
    Assert.assertTrue(evaluate(128));
    Assert.assertTrue(evaluate(1024));
  }

  @Test
  public void shouldNotBeAPowerOfTwo() {
    Assert.assertFalse(evaluate(100));
    Assert.assertFalse(evaluate(56));
  }

  private boolean evaluate(int number) {
    return Question5.isPowerOfTwo(number);
  }
}
