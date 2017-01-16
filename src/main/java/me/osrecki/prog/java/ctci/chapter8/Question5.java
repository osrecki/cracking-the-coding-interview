package me.osrecki.prog.java.ctci.chapter8;

/**
 * Question:  Write a recursive function to multiply two positive integers
 *            without using the * operator.You can use addition, subtraction,
 *            and bit shifting, but you should minimize the number of those
 *            operations.
 */
public class Question5 {
  static int multiply(int a, int b) {
    int bigger  = a > b ? a : b;
    int smaller = a < b ? a : b;

    return multiplyRec(smaller, bigger, 0);
  }

  /**
   * Time: O(log(smaller))
   */
  private static int multiplyRec(int smaller, int bigger, int acc) {
    if (smaller == 0) {
      return 0;
    } else if (smaller == 1) {
      return bigger + acc;
    } else {
      if ((smaller % 2) == 1) acc += bigger;
      return multiplyRec(smaller >> 1, bigger << 1, acc);
    }
  }
}
