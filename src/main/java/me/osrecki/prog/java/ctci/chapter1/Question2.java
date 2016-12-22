package me.osrecki.prog.java.ctci.chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Question:  Given two strings, write a method to decide if one is a permutation
 *            of the other.
 * Author:    Dinko Osrecki
 * Date:      21/12/2016
 */
public class Question2 {
  // 8-bit ASCII alphabet
  private static final int ALPHABET_SIZE = 256;

  /**
   * Idea:  Sort both strings and check if they are equal.
   * Time:  O(N logN)
   * Space: TODO
   */
  public static boolean checkPermutation1(String first, String second) {
    if(first.length() != second.length()) return false;

    char[] firstChars = first.toCharArray();
    Arrays.sort(firstChars);
    char[] secondChars = second.toCharArray();
    Arrays.sort(secondChars);

    for(int i = 0; i < first.length(); i++) {
      if(firstChars[i] != secondChars[i]) return false;
    }

    return true;
  }

  /**
   * @see #checkPermutation1(String, String)
   */
  public static boolean checkPermutation2(String first, String second) {
    if(first.length() != second.length()) return false;

    String firstSorted = Stream.of(first.split("")).sorted().collect(Collectors.joining());
    String secondSorted = Stream.of(second.split("")).sorted().collect(Collectors.joining());

    return firstSorted.equals(secondSorted);
  }


  /**
   * Idea:  Build hash map for each string which maps character to number of its
   *        occurrences and then compare two hash maps.
   * Time:  O(N)
   * Space: O(min(N, A)) where |A| is the size of alphabet
   */
  public static boolean checkPermutation3(String first, String second) {
    if(first.length() != second.length()) return false;

    HashMap<Character, Integer> firstMap = new HashMap<>();
    HashMap<Character, Integer> secondMap = new HashMap<>();

    for(int i = 0; i < first.length(); i++) {
      char firstChar = first.charAt(i);
      firstMap.put(firstChar, firstMap.getOrDefault(firstChar, 0) + 1);

      char secondChar = second.charAt(i);
      secondMap.put(secondChar, secondMap.getOrDefault(secondChar, 0) + 1);
    }

    return firstMap.equals(secondMap);
  }

  /**
   * Idea:  Use one instead of two hash maps.
   * Time:  O(N)
   * Space: O(min(N, A)) where |A| is the size of alphabet
   * @see #checkPermutation3(String, String)
   */
  public static boolean checkPermutation4(String first, String second) {
    if(first.length() != second.length()) return false;

    HashMap<Character, Integer> firstMap = new HashMap<>();
    for(int i = 0; i < first.length(); i++) {
      char character = first.charAt(i);

      firstMap.put(character, firstMap.getOrDefault(character, 0) + 1);
    }

    for(int i = 0; i < second.length(); i++) {
      char character = second.charAt(i);

      int count = firstMap.getOrDefault(character, 0) - 1;
      if(count < 0) return false;
      else firstMap.put(character, count);
    }

    return true;
  }

  /**
   * Idea:  Assumptions of fixed-size alphabet so I can use fixed-size integer
   *        array instead of a hash map.
   * Time:  O(N)
   * Space: O(A) where |A| is the size of alphabet
   * @see   #checkPermutation4(String, String)
   * @see   #checkPermutation3(String, String)
   */
  public static boolean checkPermutation5(String first, String second) {
    if(first.length() != second.length()) return false;

    int[] occurrences = new int[ALPHABET_SIZE];

    for(int i = 0; i < first.length(); i++) {
      occurrences[(int) first.charAt(i)]++;
    }

    for(int i = 0; i < second.length(); i++) {
      int character = (int) second.charAt(i);
      occurrences[character]--;

      if(occurrences[character] < 0) return false;
    }

    return true;
  }
}
