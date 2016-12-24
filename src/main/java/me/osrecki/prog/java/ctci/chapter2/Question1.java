package me.osrecki.prog.java.ctci.chapter2;

import java.util.HashSet;

/**
 * Question:  Write code to remove duplicates from an unsorted linked list. How
 *            would you solve this problem if a temporary buffer is not allowed?
 * Author:    Dinko Osrecki
 * Date:      22/12/2016
 */
class Question1 {

  /**
   * Idea:  Remember visited nodes in the hash set, and use it to find and remove
   *        duplicate nodes.
   * Time:  O(N)
   * Space: O(N)
   */
  static ConnectedList.Node<Integer> removeDuplicates1(ConnectedList.Node<Integer> head) {
    HashSet<Integer> visited = new HashSet<>();

    ConnectedList.Node<Integer> previous = head;
    ConnectedList.Node<Integer> current = head;
    while(current != null) {
      if(visited.contains(current.element)) {
        previous.next = current.next;
      } else {
        visited.add(current.element);
        previous = current;
      }

      current = current.next;
    }

    return head;
  }

  /**
   * Idea:  Use two pointers to iterate the list and remove duplicates.
   * Time:  O(N^2)
   * Space: O(1)
   */
  static ConnectedList.Node<Integer> removeDuplicates2(ConnectedList.Node<Integer> head) {
    ConnectedList.Node<Integer> current = head;
    while(current != null) {
      ConnectedList.Node<Integer> runner = current;

      while(runner.next != null) {
        if(runner.next.element.equals(current.element)) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }

      current = current.next;
    }

    return head;
  }
}
