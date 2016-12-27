package me.osrecki.prog.java.ctci.chapter3;

import java.util.Stack;

/**
 * Question:  Implement a MyQueue class which implements a queue using two stacks.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
public class MyQueue<E> {
  private Stack<E> newestFirstStack;
  private Stack<E> oldestFirstStack;

  public MyQueue() {
    newestFirstStack = new Stack<>();
    oldestFirstStack = new Stack<>();
  }

  public void add(E element) {
    newestFirstStack.push(element);
  }

  public E peek() {
    shiftStacks();

    return oldestFirstStack.peek();
  }

  public E remove() {
    shiftStacks();

    return oldestFirstStack.pop();
  }

  public int size() {
    return newestFirstStack.size() + oldestFirstStack.size();
  }

  private void shiftStacks() {
    if(oldestFirstStack.isEmpty()) {
      while(!newestFirstStack.isEmpty())
        oldestFirstStack.push(newestFirstStack.pop());
    }
  }
}
