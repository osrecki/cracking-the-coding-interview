package me.osrecki.prog.java.ctci.chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:  You are given two 32-bit numbers, N and M, and two bit positions,
 *            i and j. Write a method to insert M into N such that M starts at
 *            bit j and ends at bit i. You can assume that the bits j through i
 *            have enough space to fit all of M. That is, if M = 10011, you can
 *            assume that there are at least 5 bits between j and i. You would not,
 *            for example, have j = 3 and i = 2, because M could not fully fit
 *            between bit 3 and bit 2.
 * Author:    Dinko Osrecki
 * Date:      15/01/2017
 */
public class Question1Test {
  @Test
  public void shouldInsertMIntoN() {
    int n = 1024; // 10000000000
    int m = 19;   //     10011

    // 10001001100
    Assert.assertEquals(evaluate(n, m, 2, 6), 1100);

    n = 1100;     // 10001001100
    m = 16;       //     010000

    // 10000100000
    Assert.assertEquals(evaluate(n, m, 1, 6), 1056);
  }

  private int evaluate(int n, int m, int i, int j) {
    return Question1.insert(n, m ,i, j);
  }
}
