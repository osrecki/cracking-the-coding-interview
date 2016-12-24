package me.osrecki.prog.java.ctci.chapter2;

/**
 * Question:  Implement an algorithm to delete a node in the middle (i.e., any
 *            node but the first and last node, not necessarily the exact middle)
 *            of a singly linked list, given only access to that node.
 * Author:    Dinko Osrecki
 * Date:      23/12/2016
 */
class Question3 {
  static void deleteMiddleNode(ConnectedList.Node<Integer> node) {
    if(node == null || node.next == null)
      throw new IllegalArgumentException("Expected node in the middle of the list!");

    node.element = node.next.element;
    node.next = node.next.next;
  }
}
