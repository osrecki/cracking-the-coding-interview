package me.osrecki.prog.java.ctci.chapter1;

import org.junit.Test;

import java.util.List;

import static me.osrecki.prog.java.ctci.TestHelper.testMethodsResults;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Question:  There are three types of edits that can be performed on strings:
 *            insert a character, remove a character, or replace a character.
 *            Given two strings, write a function to check if they are one edit
 *            (or zero edits) away.
 * Author:    Dinko Osrecki
 * Date:      22/12/2016
 */
public class Question5Test {
  @Test
  public void shouldBeOneAway() {
    String first  = "string";
    String second = "string";

    assertThat("Strings '"+ first +"' and '"+ second +"' are one edit away.", evaluate(first, second), everyItem(is(true)));

    first  = "string";
    second = "sting";

    assertThat("Strings '"+ first +"' and '"+ second +"' are one edit away.", evaluate(first, second), everyItem(is(true)));

    first   = "string";
    second  = "strings";

    assertThat("Strings '"+ first +"' and '"+ second +"' are one edit away.", evaluate(first, second), everyItem(is(true)));

    first   = "strings";
    second  = "string";

    assertThat("Strings '"+ first +"' and '"+ second +"' are one edit away.", evaluate(first, second), everyItem(is(true)));

    first   = "sting";
    second  = "swing";

    assertThat("Strings '"+ first +"' and '"+ second +"' are one edit away.", evaluate(first, second), everyItem(is(true)));
  }

  @Test
  public void shouldNotBeOneAway() {
    String first  = "string";
    String second = "bring";

    assertThat("Strings '"+ first +"' and '"+ second +"' are not one edit away.", evaluate(first, second), everyItem(is(false)));

    first   = "string";
    second  = "boring";

    assertThat("Strings '"+ first +"' and '"+ second +"' are not one edit away.", evaluate(first, second), everyItem(is(false)));

    first   = "string";
    second  = "stringstring";

    assertThat("Strings '"+ first +"' and '"+ second +"' are not one edit away.", evaluate(first, second), everyItem(is(false)));

    first   = "string";
    second  = "gnirts";

    assertThat("Strings '"+ first +"' and '"+ second +"' are not one edit away.", evaluate(first, second), everyItem(is(false)));
  }

  private List<Boolean> evaluate(String first, String second) {
    return testMethodsResults(Question5.class, "oneAway", first, second);
  }
}
