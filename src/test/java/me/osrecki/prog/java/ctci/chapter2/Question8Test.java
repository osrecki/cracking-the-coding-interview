package me.osrecki.prog.java.ctci.chapter2;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Question:  Given a circular linked list, implement an algorithm that returns
 *            the node at the beginning of the loop. Circular linked list: A (corrupt)
 *            linked list in which a node's next pointer points to an earlier node, so
 *            as to make a loop in the linked list.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
public class Question8Test {
  @Test
  public void shouldFindLoopStart() {
    ConnectedList<Integer> list = new ConnectedList<>(1, 2, 3, 4, 5, 6, 7, 8, 9);
    ConnectedList.Node<Integer> loopStart = list.node(3);

    assertNull("List should not have circular loop.", evaluate(list));

    ConnectedList.Node<Integer> tail = list.node(8);
    tail.next = loopStart;

    assertThat("List should have circular loop.", evaluate(list), is(loopStart));
  }

  @Test
  public void shouldNotFindLoop() {
    ConnectedList<Integer> list = null;
    assertNull("List should not have a circular loop.", evaluate(list));

    list = new ConnectedList<>(1, 2, 3);
    assertNull("List should not have a circular loop.", evaluate(list));
  }

  private ConnectedList.Node<Integer> evaluate(ConnectedList<Integer> list) {
    ConnectedList.Node<Integer> head = list == null ? null : list.head();

    return Question8.loopStart(head);
  }
}
