package me.osrecki.prog.java.ctci.chapter2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static me.osrecki.prog.java.ctci.TestHelper.testMethodsResults;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Question:  Implement an algorithm to find the kth to last element of a
 *            singly linked list.
 * Author:    Dinko Osrecki
 * Date:      23/12/2016
 */
public class Question2Test {
  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void shouldReturn4thToLast() {
    ConnectedList<Integer> list = new ConnectedList<>(1, 2, 3, 4, 5, 6, 7, 8, 9);
    int k = 4;
    int kthToLast = 5;

    assertThat(k +"th to last element of '"+ list +"' should be '"+ kthToLast +"'.",
      evaluate(list.head(), k), everyItem(is(kthToLast))
    );
  }

  @Test
  public void shouldReturnLast() {
    ConnectedList<Integer> list = new ConnectedList<>(1, 2, 3, 4, 5, 6);
    int k = 0;
    int kthToLast = 6;

    assertThat(k +"th to last element of '"+ list +"' should be '"+ kthToLast +"'.",
      evaluate(list.head(), k), everyItem(is(kthToLast))
    );
  }

  @Test
  public void shouldReturnFirst() {
    ConnectedList<Integer> list = new ConnectedList<>(1, 2, 3);
    int k = 2;
    int kthToLast = 1;

    assertThat(k +"th to last element of '"+ list +"' should be '"+ kthToLast +"'.",
      evaluate(list.head(), k), everyItem(is(kthToLast))
    );
  }

  @Test
  public void shouldThrowNoSuchElementException1() {
    exception.expect(NoSuchElementException.class);

    ConnectedList<Integer> list = new ConnectedList<>(1, 2, 3);
    int k = 3;

    Question2.kthToLast1(list.head(), k);
  }

  @Test
  public void shouldThrowNoSuchElementException2() {
    exception.expect(NoSuchElementException.class);

    ConnectedList<Integer> list = new ConnectedList<>(1, 2, 3);
    int k = 3;

    Question2.kthToLast2(list.head(), k);
  }

  private List<Integer> evaluate(ConnectedList.Node<Integer> head, int k) {
    List<ConnectedList.Node<Integer>> results = testMethodsResults(Question2.class, "kthToLast", head, k);

    return results.stream().map(node -> node.element).collect(Collectors.toList());
  }
}
