package me.osrecki.prog.java.ctci.chapter1;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import static me.osrecki.prog.java.ctci.TestHelper.testMethodsResults;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertFalse;

/**
 * Question:  Implement an algorithm to determine if a string has all unique
 *            characters. What if you cannot use additional data structures?
 * Author:    Dinko Osrecki
 * Date:      21/12/2016
 */
public class Question1Test {
  @Test
  public void stringShouldHaveAllUniqueChars() {
    assertThat("'string' should have all unique characters.", evaluate("string"), everyItem(is(true)));
  }

  @Test
  public void methodShouldHaveAllUniqueChars(){
    assertThat("'method' should have all unique characters.", evaluate("method"), everyItem(is(true)));
  }

  @Test
  public void bufferShouldHaveDuplicateChars() {
    assertThat("'buffer' should have duplicate characters.", evaluate("buffer"), everyItem(is(false)));
  }

  @Test
  public void testShouldHaveDuplicateChars() {
    assertThat("'test' should have duplicate characters.", evaluate("test"), everyItem(is(false)));
  }

  @Test
  public void shouldFailWhenStringLongerThanSmallLettersAlphabet() {
    String string = "abcdefghijklmnopqrstuvwqyza";

    assertFalse("'"+ string +"' should have duplicate characters.", Question1.hasAllUniqueChars6(string));
  }

  @Test
  public void shouldFailWhenStringLongerThan8bitAlphabet() {
    Random random = new Random();
    char[] characters = new char[300];
    for(int i = 0; i < characters.length; i++) {
      characters[i] = (char) random.nextInt(256);
    }
    String string = new String(characters);

    String message = "'"+ string +"' should have duplicate characters.";
    assertFalse(message, Question1.hasAllUniqueChars4(string));
    assertFalse(message, Question1.hasAllUniqueChars5(string));
  }

  private List<Boolean> evaluate(String string) {
    return testMethodsResults(Question1.class, "hasAllUniqueChars", string);
  }
}
