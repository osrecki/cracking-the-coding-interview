package me.osrecki.prog.java.ctci.chapter2;

import org.junit.Test;

import java.util.List;

import static me.osrecki.prog.java.ctci.TestHelper.testMethodsResults;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Question:  Implement a function to check if a linked list is a palindrome.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
public class Question6Test {
  @Test
  public void shouldBePalindrome() {
    ConnectedList<Integer> list = null;
    assertThat("'"+ list +"' should be palindrome.", evaluate(list), everyItem(is(true)));

    list = new ConnectedList<>(1);
    assertThat("'"+ list +"' should be palindrome.", evaluate(list), everyItem(is(true)));

    list = new ConnectedList<>(1, 2, 1);
    assertThat("'"+ list +"' should be palindrome.", evaluate(list), everyItem(is(true)));

    list = new ConnectedList<>(1, 2, 2, 1);
    assertThat("'"+ list +"' should be palindrome.", evaluate(list), everyItem(is(true)));
  }

  @Test
  public void shouldNotBePalindrome() {
    ConnectedList<Integer> list = new ConnectedList<>(1, 2);
    assertThat("'"+ list +"' should not be palindrome.", evaluate(list), everyItem(is(false)));

    list = new ConnectedList<>(-11, 22);
    assertThat("'"+ list +"' should not be palindrome.", evaluate(list), everyItem(is(false)));
  }

  private List<Boolean> evaluate(ConnectedList<Integer> list) {
    ConnectedList.Node<Integer> head = list == null ? null : list.head();

    return testMethodsResults(Question6.class, "isPalindrome", head);
  }
}
