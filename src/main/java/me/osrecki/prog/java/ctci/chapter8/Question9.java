package me.osrecki.prog.java.ctci.chapter8;

import java.util.ArrayList;
import java.util.List;

/**
 * Question:  Implement an algorithm to print all valid (e.g., properly opened
 *            and closed) combinations of n pairs of parentheses.
 */
class Question9 {
  static List<String> parens(int n) {
    char[] prefix = new char[2 * n];

    List<String> results = new ArrayList<>();
    parensRec(n, n, prefix, 0, results);
    return results;
  }

  private static void parensRec(int openRem, int closedRem, char[] prefix, int index, List<String> results) {
    if (openRem == 0 && closedRem == 0) {
      results.add(String.valueOf(prefix));
      return;
    }

    if (openRem > 0) {
      prefix[index] = '(';
      parensRec(openRem - 1, closedRem, prefix, index + 1, results);
    }

    if (openRem < closedRem) {
      prefix[index] = ')';
      parensRec(openRem, closedRem - 1, prefix, index + 1, results);
    }
  }
}
