package me.osrecki.prog.java.ctci.chapter1;

/**
 * Question:  Given a string, write a function to check if it is a permutation
 *            of a palindrome. A palindrome is a word or phrase that is the same
 *            forwards and backwards. A permutation is a rearrangement of letters.
 *            The palindrome does not need to be limited to just dictionary words.
 * Author:    Dinko Osrecki
 * Date:      21/12/2016
 */
public class Question4 {
  private static final char FIRST_LETTER = 'a';
  private static final char LAST_LETTER = 'z';

  /**
   * Idea:  Count the number of occurrences of each character. Only one character
   *        can have an odd number of occurrences for a string to be a permutation
   *        of a palindrome.
   *        Assumption: Ignore anything except letters and ignore case.
   * Time:  O(max(N, A)) where |A| is the size of alphabet
   * Space: O(A) where |A| is the size of alphabet
   */
  public static boolean isPalindromePermutation1(String string) {
    int[] counts = new int[LAST_LETTER - FIRST_LETTER + 1];

    for(char character : string.toCharArray()) {
      character = Character.toLowerCase(character);

      if(FIRST_LETTER <= character && character <= LAST_LETTER) {
        int index = character - FIRST_LETTER;
        counts[index]++;
      }
    }

    boolean foundOddLetter = false;
    for(int count : counts) {
      if(count % 2 != 0) {
        if(foundOddLetter) return false;
        else foundOddLetter = true;
      }
    }

    return true;
  }

  /**
   * Idea:  Reduce space usage by using a bit vector. If the bit is set to one,
   *        that character occurs odd number of times in the string. Use XOR to
   *        count the number of occurrences of the character (odd vs. even).
   * Time:  O(max(N, A)) where |A| is the size of alphabet
   * Space: O(A) where |A| is the size of alphabet
   * @see   #isPalindromePermutation1(String)
   */
  public static boolean isPalindromePermutation2(String string) {
    int vector = 0; // enough for 'a' - 'z' alphabet (26 letters)

    for(char character : string.toCharArray()) {
      character = Character.toLowerCase(character);

      if(FIRST_LETTER <= character && character <= LAST_LETTER) {
        int index = character - FIRST_LETTER;
        vector ^= (1 << index);
      }
    }

    // e.g. 00100 - 00001 = 00011
    //      00100 & 00011 = 00000 (OK)
    // e.g. 10100 - 00001 = 10011
    //      10100 & 10011 = 10000 (NOK)
    return vector == 0 || (vector & (vector - 1)) == 0;
  }
}
