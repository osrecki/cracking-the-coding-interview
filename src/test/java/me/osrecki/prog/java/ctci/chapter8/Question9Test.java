package me.osrecki.prog.java.ctci.chapter8;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Question:  Implement an algorithm to print all valid (e.g., properly opened
 *            and closed) combinations of n pairs of parentheses.
 */
public class Question9Test {
  @Test
  public void shouldReturnCombinationsOfParentheses() {
    Assert.assertThat(evaluate(1), contains("()"));
    Assert.assertThat(evaluate(2), containsInAnyOrder("()()", "(())"));
    Assert.assertThat(evaluate(3).size(), is(5));

    List<String> parens = evaluate(1);
    Set<String> parensSet = new HashSet<>(parens);

    Assert.assertThat(parens.size(), is(parensSet.size()));
  }

  private List<String> evaluate(int n) {
    return Question9.parens(n);
  }
}
