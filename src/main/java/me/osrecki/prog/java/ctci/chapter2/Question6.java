package me.osrecki.prog.java.ctci.chapter2;

import java.util.Stack;

/**
 * Question:  Implement a function to check if a linked list is a palindrome.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
public class Question6 {
  /**
   * Idea:  Reverse the list and then recursively check if the list is a palindrome.
   * Time:  O(N)
   * Space: O(N)
   */
  public static boolean isPalindrome1(ConnectedList.Node<Integer> head) {
    ConnectedList.Node<Integer> reversedHead = reverseList(head);

    return isPalindrome1Rec(head, reversedHead);
  }

  private static boolean isPalindrome1Rec(ConnectedList.Node<Integer> head, ConnectedList.Node<Integer> reversedHead) {
    if(head == null && reversedHead == null) return true;
    if(!head.element.equals(reversedHead.element)) return false;

    return isPalindrome1Rec(head.next, reversedHead.next);
  }

  private static ConnectedList.Node<Integer> reverseList(ConnectedList.Node<Integer> head) {
    ConnectedList.Node<Integer> reversedHead = null;

    for(ConnectedList.Node<Integer> current = head; current != null; current = current.next) {
      reversedHead = new ConnectedList.Node<>(current.element, reversedHead);
    }

    return reversedHead;
  }

  /**
   * Idea:  Put first half of the list on the stack, and then check if the second
   *        half of the list matches the first.
   * Time:  O(N)
   * Space: O(N)
   */
  public static boolean isPalindrome2(ConnectedList.Node<Integer> head) {
    ConnectedList.Node<Integer> runner = head;
    ConnectedList.Node<Integer> slow = head;

    Stack<Integer> stack = new Stack<>();
    while(runner != null && runner.next != null) {
      stack.add(slow.element);

      slow = slow.next;
      runner = runner.next.next;
    }

    // For odd number of elements, skip the middle one
    if(runner != null)
      slow = slow.next;

    while(slow != null) {
      int element = stack.pop();

      if(element != slow.element) return false;

      slow = slow.next;
    }

    return true;
  }

  /**
   * Idea:  With the known length of the list recursively compare head and tail
   *        elements of the list. Propagate results from the middle of the list
   *        outwards.
   * Time:  O(N)
   * Space: O(N)
   */
  public static boolean isPalindrome3(ConnectedList.Node<Integer> head) {
    int length = listLength(head);

    Result result = isPalindrome3Rec(head, length);
    return result.isPalindrome;
  }
  
  private static Result isPalindrome3Rec(ConnectedList.Node<Integer> head, int length) {
    if(head == null || length == 0) return new Result(head, true);
    else if(length == 1) return new Result(head.next, true);

    Result result = isPalindrome3Rec(head.next, length - 2);
    if(!result.isPalindrome || result.node == null) return result;

    result.isPalindrome = head.element.equals(result.node.element);
    result.node = result.node.next;

    return result;
  }

  private static int listLength(ConnectedList.Node<Integer> head) {
    int size = 0;
    for(; head != null; head = head.next)
      size++;

    return size;
  }

  static class Result {
    ConnectedList.Node<Integer> node;
    boolean isPalindrome;

    Result(ConnectedList.Node<Integer> node, boolean isPalindrome) {
      this.node = node;
      this.isPalindrome = isPalindrome;
    }
  }
}
