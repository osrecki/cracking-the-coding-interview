package me.osrecki.prog.java.ctci.chapter10;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

/**
 * Question:  You are given two sorted arrays, A and B, where A has a large
 *            enough buffer at the end to hold B. Write a method to merge B
 *            into A in sorted order.
 */
public class Question1Test {
  @Test
  public void shouldMergeSortedArrays() {
    int[] a = new int[]{1, 3, 5, 7, 0, 0, 0, 0};
    int[] b = new int[]{2, 4, 6, 8};
    int[] sorted = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

    Assert.assertThat(evaluate(a, b), is(sorted));

    b = new int[]{-10, -8, -7, -4};
    sorted = new int[]{-10, -8, -7, -4, 1, 3, 5, 7};

    Assert.assertThat(evaluate(a, b), is(sorted));

    b = new int[]{100, 200, 300, 400};
    sorted = new int[]{1, 3, 5, 7, 100, 200, 300, 400};

    Assert.assertThat(evaluate(a, b), is(sorted));
  }

  private int[] evaluate(int[] a, int[] b) {
    int[] _a = a.clone();

    Question1.sortedMerge(_a, b);
    return _a;
  }
}
