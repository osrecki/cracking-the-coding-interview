package me.osrecki.prog.java.ctci.chapter5;

import org.junit.Assert;
import org.junit.Test;

import static me.osrecki.prog.java.ctci.TestHelper.testMethodsResults;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

/**
 * Question:  Write a function to determine the number of bits you would need
 *            to flip to convert integer A to integer B.
 * Author:    Dinko Osrecki
 * Date:      15/01/2017
 */
public class Question6Test {
  @Test
  public void shouldReturnNumberOfBitsToFlip() {
    int a = 29; // 11101
    int b = 15; // 01111

    Assert.assertThat(evaluate(a, b), everyItem(is(2)));

    b = 29;
    Assert.assertThat(evaluate(a, b), everyItem(is(0)));

    b = 2;  // 00010
    Assert.assertThat(evaluate(a, b), everyItem(is(5)));
  }

  private List<Integer> evaluate(int a, int b) {
    return testMethodsResults(Question6.class, "flipBits", a, b);
  }
}
