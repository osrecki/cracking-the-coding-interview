package me.osrecki.prog.java.ctci.chapter3;

import java.util.Stack;

/**
 * Question:  Write a program to sort a stack such that the smallest items are
 *            on the top. You can use an additional temporary stack, but you may
 *            not copy the elements into any other data structure (such as an
 *            array). The stack supports the following operations: push, pop,
 *            peek, and is Empty.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
class Question5 {

  /**
   * Idea:  Use additional stack for sorted elements. Add elements from original
   *        stack one-by-one in correct order in the sorted stack.
   * Time:  O(N^2)
   * Space: O(N)
   */
  static Stack<Integer> sortStack(Stack<Integer> stack) {
    Stack<Integer> sorted = new Stack<>();

    while(!stack.isEmpty()) {
      int top = stack.pop();

      while(!sorted.isEmpty() && sorted.peek() < top)
        stack.push(sorted.pop());

      sorted.push(top);
    }

    return sorted;
  }
}
