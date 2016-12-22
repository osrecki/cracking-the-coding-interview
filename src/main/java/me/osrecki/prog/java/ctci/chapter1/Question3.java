package me.osrecki.prog.java.ctci.chapter1;

/**
 * Question:  Write a method to replace all spaces in a string with '%20'. You
 *            may assume that the string has sufficient space at the end to hold
 *            the additional characters, and that you are given the "true" length
 *            of the string.
 * Author:    Dinko Osrecki
 * Date:      21/12/2016
 */
public class Question3 {
  /**
   * Idea:  First calculate the number of spaces and then move characters
   *        to the right starting from the end of the string, and encode
   *        spaces.
   * Time:  O(N)
   * Space: O(1)
   */
  public static String encodeForUrl(String string) {
    char[] chars = string.toCharArray();

    // Count the spaces in the string
    int i = chars.length - 1;
    while(chars[i] == ' ') i--;

    int spacesCount = 0;
    while(i >= 0) {
      if(chars[i--] == ' ') spacesCount++;
    }

    // Move the characters to the right and encode spaces as '%20'
    i = chars.length - 1;
    while(spacesCount > 0) {
      char current = chars[i - spacesCount * 2];

      if(current == ' ') {
        chars[i - 2]  = '%';
        chars[i - 1]  = '2';
        chars[i]      = '0';

        spacesCount--;
        i -= 3;
      } else {
        chars[i--] = current;
      }
    }

    return new String(chars);
  }
}
