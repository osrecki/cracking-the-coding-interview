package me.osrecki.prog.java.ctci.chapter1;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import static me.osrecki.prog.java.ctci.TestHelper.testMethodsResults;

/**
 * Question:  Write a method to replace all spaces in a string with '%20'. You
 *            may assume that the string has sufficient space at the end to hold
 *            the additional characters, and that you are given the "true" length
 *            of the string.
 * Author:    Dinko Osrecki
 * Date:      21/12/2016
 */
public class Question3Test {
  @Test
  public void shouldEncodeStringForUrl() {
    String string   = "this is a string      ";
    String encoded  = "this%20is%20a%20string";

    assertThat("'"+ string +"' should be encoded as '"+ encoded +"'.", evaluate(string), everyItem(is(encoded)));

    string  = "Mr John Wayne    ";
    encoded = "Mr%20John%20Wayne";

    assertThat("'"+ string +"' should be encoded as '"+ encoded +"'.", evaluate(string), everyItem(is(encoded)));

    string  = "nothingToEncode";
    encoded = "nothingToEncode";

    assertThat("'"+ string +"' should be encoded as '"+ encoded +"'.", evaluate(string), everyItem(is(encoded)));

    string  = "nothing_to_encode    ";
    encoded = "nothing_to_encode    ";

    assertThat("'"+ string +"' should be encoded as '"+ encoded +"'.", evaluate(string), everyItem(is(encoded)));

    string  = " encode this    ";
    encoded = "%20encode%20this";

    assertThat("'"+ string +"' should be encoded as '"+ encoded +"'.", evaluate(string), everyItem(is(encoded)));
  }

  private List<String> evaluate(String string) {
    return testMethodsResults(Question3.class, "encodeForUrl", string);
  }
}
