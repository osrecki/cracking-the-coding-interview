package me.osrecki.prog.java.ctci.chapter8;

import java.util.ArrayList;

/**
 * Question:  Write a method to compute all permutations of a string of unique
 *            characters.
 */
class Question7 {
  static ArrayList<String> permutations(String string) {
    ArrayList<String> result = new ArrayList<>();
    permutationsRec("", string, result);
    return result;
  }

  private static void permutationsRec(String prefix, String rest, ArrayList<String> result) {
    if (rest.length() == 0) {
      result.add(prefix);
    }

    for(int i = 0; i < rest.length(); i++) {
      String pre = rest.substring(0, i);
      String post = rest.substring(i + 1);

      char current = rest.charAt(i);
      permutationsRec(prefix + current, pre + post, result);
    }
  }
}
