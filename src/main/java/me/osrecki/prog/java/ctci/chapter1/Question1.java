package me.osrecki.prog.java.ctci.chapter1;

import java.util.BitSet;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Question:  Implement an algorithm to determine if a string has all unique
 *            characters. What if you cannot use additional data structures?
 * Author:    Dinko Osrecki
 * Date:      21/12/2016
 */
public class Question1 {
  // 8-bit ASCII alphabet
  private static final int ALPHABET_SIZE = 256;
  // a-z alphabet
  private static final char FIRST_LETTER = 'a';
  private static final char LAST_LETTER = 'z';

  /**
   * Idea:  Compare every character of the string to every other character of
   *        the string.
   * Time:  O(N^2)
   * Space: O(1)
   */
  public static boolean hasAllUniqueChars1(String string) {
    for(int i = 0; i < string.length(); i++) {
      for(int j = i + 1; j < string.length(); j++) {
        if(string.charAt(i) == string.charAt(j)) return false;
      }
    }

    return true;
  }

  /**
   * Idea:  Store characters in a hash set and check for each character if it
   *        is already in the hash set.
   * Time:  O(N)
   * Space: O(N) or O(A) where |A| is the size of alphabet
   */
  public static boolean hasAllUniqueChars2(String string) {
    HashSet<Character> characters = new HashSet<>();

    for(Character character : string.toCharArray()) {
      if (characters.contains(character)) return false;
      else characters.add(character);
    }

    return true;
  }

  /**
   * Idea:  Sort the string and then linearly check the string for neighbouring
   *        characters that are identical.
   * Time:  O(N logN)
   * Space: TODO
   */
  public static boolean hasAllUniqueChars3(String string) {
    String sorted = Stream.of(string.split("")).sorted().collect(Collectors.joining());

    for(int i = 1; i < sorted.length(); i++) {
      if(sorted.charAt(i - 1) == sorted.charAt(i)) return false;
    }

    return true;
  }

  /**
   * Idea:  Create boolean array of flags and linearly check if element is
   *        already in the array.
   * Time:  O(N) or O(A) where |A| is the size of alphabet
   * Space: O(A) where |A| is the size of alphabet
   */
  public static boolean hasAllUniqueChars4(String string) {
    if(string.length() > ALPHABET_SIZE) return false;

    boolean[] characters = new boolean[ALPHABET_SIZE];
    for(int i = 0; i < string.length(); i++) {
      int ascii_code = (int) string.charAt(i);

      if(characters[ascii_code]) return false;
      else characters[ascii_code] = true;
    }

    return true;
  }

  /**
   * Idea:  Reduce space consumption 8 times by using bit vector instead
   *        of array of booleans.
   * Time:  O(N) or O(A) where |A| is the size of alphabet
   * Space: O(A) where |A| is the size of alphabet
   * @see   #hasAllUniqueChars4(String)
   */
  public static boolean hasAllUniqueChars5(String string) {
    if(string.length() > ALPHABET_SIZE) return false;

    BitSet vector = new BitSet(ALPHABET_SIZE);
    for(int i = 0; i < string.length(); i++) {
      int ascii_code = (int) string.charAt(i);

      if(vector.get(ascii_code)) return false;
      else vector.set(ascii_code);
    }

    return true;
  }

  /**
   * Idea:  Use a-z alphabet (26 characters) and integer as a bit vector
   *        (32 flags).
   * Time:  O(N) or O(A) where |A| is the size of alphabet
   * Space: O(A) where |A| is the size of alphabet
   * @see   #hasAllUniqueChars4(String)
   * @see   #hasAllUniqueChars5(String)
   */
  public static boolean hasAllUniqueChars6(String string) {
    if(string.length() > LAST_LETTER - FIRST_LETTER + 1) return false;

    int vector = 0;

    for(int i = 0; i < string.length(); i++) {
      int value = string.charAt(i) - FIRST_LETTER;

      if((vector & (1 << value)) > 0) return false;
      else vector |= (1 << value);
    }

    return true;
  }
}
