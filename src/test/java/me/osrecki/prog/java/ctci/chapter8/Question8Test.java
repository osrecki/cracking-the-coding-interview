package me.osrecki.prog.java.ctci.chapter8;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import java.util.List;

/**
 * Question:  Write a method to compute all permutations of a string whose
 *            characters are not necessarily unique. The list of permutations
 *            should not have duplicates.
 */
public class Question8Test {
  @Test
  public void shouldComputePermutationsOfString() {
    String string = "aaaaaaaaaa";
    List<String> actual = evaluate(string);

    Assert.assertThat(actual, contains(string));
    Assert.assertEquals(1, actual.size());
  }

  private List<String> evaluate(String string) {
    return Question8.permutations(string);
  }
}
