package me.osrecki.prog.java.ctci.chapter2;

import java.util.NoSuchElementException;

/**
 * Question:  Implement an algorithm to find the kth to last element of a
 *            singly linked list.
 * Author:    Dinko Osrecki
 * Date:      23/12/2016
 */
public class Question2 {
  /**
   * Idea:  Iterative solution with two pointers. First, one moves k elements
   *        into the list and then they move together until the first one
   *        reaches the end of the list. For k=0 the tail is returned.
   * Time:  O(N)
   * Space: O(1)
   */
  public static ConnectedList.Node<Integer> kthToLast1(ConnectedList.Node<Integer> head, int k) {
    ConnectedList.Node<Integer> runner = head;
    for(int i = 0; i <= k; i++) {
      if(runner == null) throw new NoSuchElementException();

      runner = runner.next;
    }

    ConnectedList.Node<Integer> current = head;
    for(; runner != null; runner = runner.next, current = current.next);
    return current;
  }

  /**
   * Idea:  Recursive solution. Go down to the last node, and increase a counter
   *        on the way back. Return node at the level at which counter equals k.
   * Time:  O(N)
   * Space: O(N)
   */
  public static ConnectedList.Node<Integer> kthToLast2(ConnectedList.Node<Integer> head, int k) {
    ConnectedList.Node<Integer> kthToLast = _kthToLastRec(head, k, new Counter());

    if(kthToLast == null) throw new NoSuchElementException();

    return kthToLast;
  }

  private static ConnectedList.Node<Integer> _kthToLastRec(ConnectedList.Node<Integer> node, int k, Counter counter) {
    if(node == null) return null;

    ConnectedList.Node<Integer> current = _kthToLastRec(node.next, k, counter);

    counter.inc();
    if(k == counter.k)
      return node;

    return current;
  }

  private static class Counter {
    int k = -1;

    void inc() {
      k++;
    }
  }
}
