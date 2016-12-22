package me.osrecki.prog.java.ctci.chapter1;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import static me.osrecki.prog.java.ctci.TestHelper.testMethodsResults;

/**
 * Question:  Given two strings, write a method to decide if one is a permutation
 *            of the other.
 * Author:    Dinko Osrecki
 * Date:      21/12/2016
 */
public class Question2Test {
  @Test
  public void shouldFailWhenStringsAreOfDifferentLength() {
    String first = "permutation";
    String second = "permute";

    assertThat("'"+ first +"' and '"+ second +"' are not permutations.", evaluate(first, second), everyItem(is(false)));
  }

  @Test
  public void poolAndLoopShouldBePermutations() {
    String first = "pool";
    String second = "loop";

    assertThat("'"+ first +"' and '"+ second +"' are permutations.", evaluate(first, second), everyItem(is(true)));
  }

  @Test
  public void catAndDogShouldNotBePermutations() {
    String first = "cat";
    String second = "dog";

    assertThat("'"+ first +"' and '"+ second +"' are not permutations.", evaluate(first, second), everyItem(is(false)));
  }

  private List<Boolean> evaluate(String first, String second) {
    return testMethodsResults(Question2.class, "checkPermutation", first, second);
  }
}
