package me.osrecki.prog.java.ctci.chapter8;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:  Write a recursive function to multiply two positive integers
 *            without using the * operator.You can use addition, subtraction,
 *            and bit shifting, but you should minimize the number of those
 *            operations.
 */
public class Question5Test {
  @Test
  public void shouldMultiplyTwoNumbers() {
    Assert.assertEquals(0, evaluate(100, 0));
    Assert.assertEquals(0, evaluate(0, 10));

    Assert.assertEquals(100, evaluate(100, 1));
    Assert.assertEquals(100, evaluate(1, 100));

    Assert.assertEquals(220, evaluate(20, 11));
    Assert.assertEquals(220, evaluate(11, 20));

    Assert.assertEquals(169, evaluate(13, 13));

    Assert.assertEquals(10000, evaluate(100, 100));
  }

  private int evaluate(int a, int b) {
    return Question5.multiply(a, b);
  }
}
