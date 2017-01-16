package me.osrecki.prog.java.ctci.chapter8;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:  A child is running up a staircase with n steps and can hop either
 *            1 step, 2 steps, or 3 steps at a time. Implement a method to count
 *            how many possible ways the child can run up the stairs.
 */
public class Question1Test {
  private int[] cache = new int[40];

  @Test
  public void shouldCalculateNumberOfWaysToClimbSteps() {
    Assert.assertEquals(evaluate(0), 1);
    Assert.assertEquals(evaluate(1), 1);
    Assert.assertEquals(evaluate(2), 2);
    Assert.assertEquals(evaluate(3), 4);
    Assert.assertEquals(evaluate(4), 7);
    Assert.assertEquals(evaluate(39), 75300028);
  }

  private int evaluate(int n) {
    return Question1.tripeStep(n, cache);
  }
}
