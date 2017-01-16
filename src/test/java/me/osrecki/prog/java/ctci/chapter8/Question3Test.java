package me.osrecki.prog.java.ctci.chapter8;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:  A magic index in an array A [0...n -1] is defined to be an index
 *            such that A[ i] = i. Given a sorted array of distinct integers,
 *            write a method to find a magic index, if one exists, in array A.
 *            What if the values are not distinct?
 */
public class Question3Test {
  @Test
  public void shouldReturnMagicIndex() {
    int[] array = new int[]{-20, 0, 2, 5, 6, 10, 20};
    Assert.assertEquals(Question3.magicIndex(array), 2);

    array = new int[]{-20, 0, 2, 3, 6, 10, 20};
    Assert.assertEquals(Question3.magicIndex(array), 3);

    array = new int[]{-20, 0, 1, 2, 4, 5, 20};
    Assert.assertEquals(Question3.magicIndex(array), 5);
  }

  @Test
  public void shouldReturnMagicIndexWithDuplicates() {
    int[] array = new int[]{-20, 0, 2, 2, 4, 5, 20};
    Assert.assertEquals(Question3.magicIndexDuplicates(array), 2);
  }
}
