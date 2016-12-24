package me.osrecki.prog.java.ctci.chapter2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Question:  Implement an algorithm to delete a node in the middle (i.e., any
 *            node but the first and last node, not necessarily the exact middle)
 *            of a singly linked list, given only access to that node.
 * Author:    Dinko Osrecki
 * Date:      24/12/2016
 */
public class Question3Test {
  private ConnectedList<Integer> list1;

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Before
  public void initializeTest() {
    list1 = new ConnectedList<>(1, 2, 3, 4, 5);
  }

  @Test
  public void shouldRemoveMiddleNode() {
    int index = 3;
    ConnectedList<Integer> list2 = new ConnectedList<>(1, 2, 3, 5);

    assertThat("'"+ list1 +"' should be transformed into '"+ list2 +"'.",
        evaluate(list1.head(), list1.node(index)), is(list2)
    );
  }

  @Test
  public void shouldThrowIllegalArgumentException() {
    exception.expect(IllegalArgumentException.class);

    int index = 4;
    evaluate(list1.head(), list1.node(index));
  }

  private ConnectedList<Integer> evaluate(ConnectedList.Node<Integer> head, ConnectedList.Node<Integer> node) {
    Question3.deleteMiddleNode(node);

    return ConnectedList.fromNode(head);
  }
}
