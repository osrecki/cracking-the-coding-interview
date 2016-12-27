package me.osrecki.prog.java.ctci.chapter2;

/**
 * Question:  Given a circular linked list, implement an algorithm that returns
 *            the node at the beginning of the loop. Circular linked list: A (corrupt)
 *            linked list in which a node's next pointer points to an earlier node, so
 *            as to make a loop in the linked list.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
class Question8 {
  /**
   * Idea:  Use slow and fast runner which will eventually collide inside the
   *        loop, exactly K steps from the loop beginning, where K is the size of
   *        the non-looped (beginning) part of the list. Then, move head of the
   *        list together with slow pointer, they will collide after K steps at
   *        the starting node of the loop.
   * Time:  O(K + LOOP_SIZE)
   * Space: O(1)
   */
  static ConnectedList.Node<Integer> loopStart(ConnectedList.Node<Integer> head) {
    ConnectedList.Node<Integer> slow = head;
    ConnectedList.Node<Integer> fast = head;

    // Collision point detection
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast) break;
    }

    // Non-circular list
    if(fast == null || fast.next == null) return null;

    ConnectedList.Node<Integer> current = head;
    while(current != slow) {
      current = current.next;
      slow = slow.next;
    }

    return current;
  }
}
