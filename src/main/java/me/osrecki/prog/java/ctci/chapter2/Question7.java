package me.osrecki.prog.java.ctci.chapter2;

/**
 * Question:  Given two (singly) linked lists, determine if the two lists intersect.
 *            Return the intersecting node. Note that the intersection is defined
 *            based on reference, not value. That is, if the kth node of the first
 *            linked list is the exact same node (by reference) as the jth node of
 *            the second linked list, then they are intersecting.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
class Question7 {
  /**
   * Idea:  Lists intersect if their tails are the same. To find intersecting
   *        node, advance longer list to make both lists the same size, and
   *        then find the first node that is the same in both lists (by reference).
   * Time:  O(N + M) where |N| and |M| are sizes of lists
   * Size:  O(1)
   */
  static ConnectedList.Node<Integer> intersect(ConnectedList.Node<Integer> head1, ConnectedList.Node<Integer> head2) {
    if(head1 == null && head2 == null) return null;

    Tuple tuple1 = tailAndSize(head1);
    Tuple tuple2 = tailAndSize(head2);

    if(tuple1.tail != tuple2.tail) return null;

    int difference = tuple1.size - tuple2.size;
    if(difference > 0) {
      head1 = advanceList(head1, difference);
    } else {
      head2 = advanceList(head2, -difference);
    }

    while(head1 != head2) {
      head1 = head1.next;
      head2 = head2.next;
    }

    return head1;
  }

  private static Tuple tailAndSize(ConnectedList.Node<Integer> head) {
    int size = 0;
    ConnectedList.Node<Integer> tail = null;

    for(ConnectedList.Node<Integer> current = head; current != null; current = current.next) {
      size++;
      tail = current;
    }

    return new Tuple(tail, size);
  }

  private static ConnectedList.Node<Integer> advanceList(ConnectedList.Node<Integer> head, int count) {
    for(; count > 0 && head != null; count--)
      head = head.next;

    return head;
  }

  private static class Tuple {
    ConnectedList.Node<Integer> tail;
    int size;

    Tuple(ConnectedList.Node<Integer> tail, int size) {
      this.tail = tail;
      this.size = size;
    }
  }
}

