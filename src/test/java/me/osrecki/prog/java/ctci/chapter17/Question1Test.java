package me.osrecki.prog.java.ctci.chapter17;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:  Write a function that adds two numbers. You should not use + or
 *            any arithmetic operators.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
public class Question1Test {
  @Test
  public void shouldAddPositiveNumbers() {
    int[] a = new int[]{1, 15, 19, 0};
    int[] b = new int[]{2, 30, 11, 100};

    for(int i = 0; i < a.length; i++) {
      Assert.assertEquals(a[i] +" + "+ b[i] +" = "+ a[i] + b[i], Question1.add(a[i], b[i]), a[i] + b[i]);
    }
  }

  @Test
  public void shouldAddNegativeNumbers() {
    int[] a = new int[]{-1, 1, 10, -3};
    int[] b = new int[]{1, -1, -5, -3};

    for(int i = 0; i < a.length; i++) {
      Assert.assertEquals(a[i] +" + "+ b[i] +" = "+ a[i] + b[i], Question1.add(a[i], b[i]), a[i] + b[i]);
    }
  }
}
