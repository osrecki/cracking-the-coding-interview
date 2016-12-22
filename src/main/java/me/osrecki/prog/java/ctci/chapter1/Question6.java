package me.osrecki.prog.java.ctci.chapter1;

/**
 * Question:  Implement a method to perform basic string compression using the
 *            counts of repeated characters. For example, the string aabcccccaaa
 *            would become a2blc5a3. If the "compressed" string would not become
 *            smaller than the original string, your method should return the
 *            original string. You can assume the string has only uppercase and
 *            lowercase letters (a - z).
 * Author:    Dinko Osrecki
 * Date:      22/12/2016
 */
public class Question6 {
  private static int DEFAULT_LENGTH = 16;

  /**
   * Idea:  Iterate through string and when characters change append character
   *        and its number of occurrence to a string builder. If compressed string
   *        is smaller than the original one, return compressed string.
   * Time:  O(N)
   */
  public static String compress1(String string) {
    String compressed = _compressString(string, DEFAULT_LENGTH);

    return (compressed.length() < string.length()) ? compressed : string;
  }

  /**
   * Idea:  Little tweak to first calculate the length of the compressed
   *        string, and then decide if it makes sense to compress it.
   * Time:  O(N)
   * @see   #compress1(String)
   */
  public static String compress2(String string) {
    int compressedLength = _compressedLength(string);

    return (compressedLength < string.length()) ? _compressString(string, compressedLength) : string;
  }

  private static String _compressString(String string, int length) {
    StringBuilder compressed = new StringBuilder(length);
    int count = 0;
    for(int i = 0; i < string.length(); i++) {
      count++;

      if(i + 1 == string.length() || string.charAt(i + 1) != string.charAt(i)) {
        compressed.append(string.charAt(i)).append(count);
        count = 0;
      }
    }

    return compressed.toString();
  }

  private static int _compressedLength(String string) {
    int count = 0;
    for(int i = 0; i < string.length(); i++) {
      if(i + 1 == string.length() || string.charAt(i + 1) != string.charAt(i)) count++;
    }

    return count * 2;
  }
}
