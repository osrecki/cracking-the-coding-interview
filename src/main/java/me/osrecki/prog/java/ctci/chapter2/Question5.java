package me.osrecki.prog.java.ctci.chapter2;

/**
 * Question:  You have two numbers represented by a linked list, where each node
 *            contains a single digit. The digits are stored in reverse order,
 *            such that the 1 's digit is at the head of the list. Write a function
 *            that adds the two numbers and returns the sum as a linked list.
 *            Suppose the digits are stored in forward order. Repeat the above problem.
 * Author:    Dinko Osrecki
 * Date:      26/12/2016
 */
public class Question5 {
  /**
   * Idea:  Lists are given in reverse order. Sum digits in pairs recursively,
   *        passing carry to next function call.
   * Time:  O(N)
   * Space: O(N)
   */
  public static ConnectedList.Node<Integer> sumListsReverse1(ConnectedList.Node<Integer> head1, ConnectedList.Node<Integer> head2) {
    return _sumListsReverseRec(head1, head2, 0);
  }

  private static ConnectedList.Node<Integer> _sumListsReverseRec(ConnectedList.Node<Integer> head1, ConnectedList.Node<Integer> head2, int carry) {
    if(head1 == null && head2 == null && carry == 0) return null;

    int sum = carry;
    if(head1 != null) sum += head1.element;
    if(head2 != null) sum += head2.element;

    ConnectedList.Node<Integer> nextNode = _sumListsReverseRec(head1 == null ? null : head1.next, head2 == null ? null : head2.next, sum / 10);

    return new ConnectedList.Node<>(sum % 10, nextNode);
  }

  /**
   * Idea:  Lists are given in reverse order. Iteratively sum digits in pairs.
   * Time:  O(N)
   * Space: O(N)
   */
  public static ConnectedList.Node<Integer> sumListsReverse2(ConnectedList.Node<Integer> head1, ConnectedList.Node<Integer> head2) {
    ConnectedList.Node<Integer> master = new ConnectedList.Node<>(null, null);

    ConnectedList.Node<Integer> current = master;
    int carry = 0;
    while(head1 != null || head2 != null || carry != 0) {
      int sum = carry;

      if(head1 != null) {
        sum += head1.element;
        head1 = head1.next;
      }

      if(head2 != null) {
        sum += head2.element;
        head2 = head2.next;
      }

      carry = sum / 10;

      ConnectedList.Node<Integer> nextNode = new ConnectedList.Node<>(sum % 10, null);
      current.next = nextNode;
      current = nextNode;
    }

    return master.next;
  }

  /**
   * Idea:  Lists are given in forward order. First pad shorter list with zeros
   *        and then sum digits in pairs recursively.
   * Time:  O(N)
   * Space: O(N)
   */
  public static ConnectedList.Node<Integer> sumListsForward1(ConnectedList.Node<Integer> head1, ConnectedList.Node<Integer> head2) {
    int list1Size = listSize(head1);
    int list2Size = listSize(head2);

    if(list1Size < list2Size) {
      head1 = padList(head1, list2Size - list1Size);
    } else {
      head2 = padList(head2, list1Size - list2Size);
    }

    PartialSum partialSum = _sumListsForwardRec(head1, head2);

    ConnectedList.Node<Integer> sumHead = partialSum.sum;
    if(partialSum.carry != 0) {
      sumHead = new ConnectedList.Node<>(partialSum.carry, sumHead);
    }

    return sumHead;
  }

  private static PartialSum _sumListsForwardRec(ConnectedList.Node<Integer> head1, ConnectedList.Node<Integer> head2) {
    if(head1 == null && head2 == null) return new PartialSum();

    PartialSum partialSum = _sumListsForwardRec(head1.next, head2.next);

    int sum = partialSum.carry + head1.element + head2.element;

    ConnectedList.Node<Integer> node = new ConnectedList.Node<>(sum % 10, partialSum.sum);

    return new PartialSum(node, sum / 10);
  }

  private static ConnectedList.Node<Integer> padList(ConnectedList.Node<Integer> head, int padding) {
    for(; padding > 0; padding--) {
      head = new ConnectedList.Node<>(0, head);
    }

    return head;
  }

  private static int listSize(ConnectedList.Node<Integer> head) {
    int size = 0;

    for(ConnectedList.Node<Integer> current = head; current != null; current = current.next)
      size++;

    return size;
  }
  
  private static class PartialSum {
    ConnectedList.Node<Integer> sum;
    int carry;

    PartialSum() {
      this(null, 0);
    }

    PartialSum(ConnectedList.Node<Integer> sum, int carry) {
      this.sum = sum;
      this.carry = carry;
    }
  }
}
