package me.osrecki.prog.java.ctci.chapter1;

/**
 * Question:  Assume you have a method isSubstring which checks if one word is a
 *            substring of another. Given two strings, sl and s2, write code to
 *            check if s2 is a rotation of sl using only one call to isSubstring
 *            (e.g., "waterbottle" is a rotation of"erbottlewat").
 * Author:    Dinko Osrecki
 * Date:      22/12/2016
 */
public class Question9 {
  /**
   * Idea:  If we represent s1 as xy (made of two parts x and y), then s2 could be
   *        represented as yx. If we concatenate s2 with itself we get yxyx. So,
   *        we can check if s2s2 (yxyx) contains s1 (xy).
   * Time:  O(N)
   * Space: O(N)
   */
  public static boolean isRotation(String s1, String s2) {
    return !(s1.length() == 0 || s1.length() != s2.length()) && (s2 + s2).contains(s1);
  }
}
