package me.osrecki.prog.java.ctci.chapter8;

/**
 * Question:  A child is running up a staircase with n steps and can hop either
 *            1 step, 2 steps, or 3 steps at a time. Implement a method to count
 *            how many possible ways the child can run up the stairs.
 */
public class Question1 {
  public static int tripeStep(int n, int[] cache) {
    if (n < 0) return 0;
    else if (n == 0) return 1;
    else if (cache[n] > 0) return cache[n];
    else {
      cache[n] = tripeStep(n - 1, cache) + tripeStep(n - 2, cache) + tripeStep(n - 3, cache);
      return cache[n];
    }
  }
}
