package me.osrecki.prog.java.ctci.chapter1;

import org.junit.Test;

import java.util.List;

import static me.osrecki.prog.java.ctci.TestHelper.testMethodsResults;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Question:  Assume you have a method isSubstring which checks if one word is a
 *            substring of another. Given two strings, sl and s2, write code to
 *            check if s2 is a rotation of sl using only one call to isSubstring
 *            (e.g., "waterbottle" is a rotation of"erbottlewat").
 * Author:    Dinko Osrecki
 * Date:      22/12/2016
 */
public class Question9Test {

  @Test
  public void shouldBeRotation() {
    String s1 = "waterbottle";
    String s2 = "erbottlewat";

    assertThat("String '"+ s2 +"' is a rotation of string '"+ s1 +"'.", evaluate(s1, s2), everyItem(is(true)));

    s1 = "mplesexa";
    s2 = "examples";

    assertThat("String '"+ s2 +"' is a rotation of string '"+ s1 +"'.", evaluate(s1, s2), everyItem(is(true)));
  }

  @Test
  public void shouldNotBeRotation() {
    String s1 = "word";
    String s2 = "dorw";

    assertThat("String '"+ s2 +"' is not a rotation of string '"+ s1 +"'.", evaluate(s1, s2), everyItem(is(false)));
  }

  private List<Boolean> evaluate(String s1, String s2) {
    return testMethodsResults(Question9.class, "isRotation", s1, s2);
  }
}
