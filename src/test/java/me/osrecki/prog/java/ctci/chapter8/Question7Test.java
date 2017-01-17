package me.osrecki.prog.java.ctci.chapter8;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

/**
 * Question:  Write a method to compute all permutations of a string of unique
 *            characters.
 */
public class Question7Test {
  @Test
  public void shouldComputePermutationsOfString() {
    String string = "abc";
    String[] expected = new String[] {"abc", "acb", "bac", "bca", "cab", "cba"};

    Assert.assertThat(evaluate(string), contains(expected));
  }

  private ArrayList<String> evaluate(String string) {
    return Question7.permutations(string);
  }
}
