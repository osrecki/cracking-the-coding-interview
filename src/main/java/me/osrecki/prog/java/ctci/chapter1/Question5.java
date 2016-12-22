package me.osrecki.prog.java.ctci.chapter1;

/**
 * Question:  There are three types of edits that can be performed on strings:
 *            insert a character, remove a character, or replace a character.
 *            Given two strings, write a function to check if they are one edit
 *            (or zero edits) away.
 * Author:    Dinko Osrecki
 * Date:      22/12/2016
 */
public class Question5 {
  /**
   * Idea:  If strings are the same length, check if they differ only in one
   *        character. If strings are of different lengths, check if smaller string
   *        equals to the longer one with one character removed.
   * Time:  O(N) where |N| is the size of the smaller string (strings may differ
   *        in size at most by one)
   * Space: O(1)
   */
  public static boolean oneAway(String first, String second) {
    if(Math.abs(first.length() - second.length()) > 1) return false;

    String shorter = (first.length() < second.length()) ? first : second;
    String longer = (first.length() < second.length()) ? second : first;

    int indexShorter = 0;
    int indexLonger = 0;
    boolean foundDifference = false;

    while(indexShorter < shorter.length() && indexLonger < longer.length()) {
      if(shorter.charAt(indexShorter) != longer.charAt(indexLonger)) {
        if(foundDifference) return false;

        foundDifference = true;

        if(shorter.length() == longer.length()) indexShorter++;
      } else {
        indexShorter++;
      }

      indexLonger++;
    }

    return true;
  }
}
