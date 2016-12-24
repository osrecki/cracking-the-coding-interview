package me.osrecki.prog.java.ctci.chapter2;

/**
 * Question:  Write code to partition a linked list around a value x, such
 *            that all nodes less than x come before all nodes greater than
 *            or equal to x. If x is contained within the list the values of
 *            x only need to be after the elements less than x (see below). The
 *            partition element x can appear anywhere in the "right partition";
 *            it does not need to appear between the left and right partitions.
 * Author:    Dinko Osrecki
 * Date:      24/12/2016
 */
class Question4 {
  /**
   * Idea:  Put elements smaller than divider at the head of the list.
   * Time:  O(N)
   * Space: O(1)
   */
  static ConnectedList.Node<Integer> partitionList1(ConnectedList.Node<Integer> head, int divider) {
    if(head == null) return null;

    ConnectedList.Node<Integer> previous = head;
    ConnectedList.Node<Integer> current = head.next;

    while(current != null) {
      if(current.element < divider) {
        previous.next = current.next;
        current.next = head;
        head = current;

        current = previous.next;
      } else {
        previous = current;
        current = current.next;
      }
    }

    return head;
  }

  /**
   * @see   #partitionList1(ConnectedList.Node, int)
   */
  static ConnectedList.Node<Integer> partitionList2(ConnectedList.Node<Integer> node, int divider) {
    ConnectedList.Node<Integer> head = node;
    ConnectedList.Node<Integer> tail = node;

    while(node != null) {
      ConnectedList.Node<Integer> next = node.next;

      if(node.element < divider) {
        node.next = head;
        head = node;
      } else {
        tail.next = node;
        tail = node;
      }
      node = next;
    }
    tail.next = null;

    return head;
  }
}
