package me.osrecki.prog.java.ctci.chapter3;

import java.util.*;

/**
 * Question:  Imagine a (literal) stack of plates. If the stack gets too high,
 *            it might topple. Therefore, in real life, we would likely start
 *            a new stack when the previous stack exceeds some threshold. Implement
 *            a data structure SetOfStacks that mimics this. SetO-fStacks should be
 *            composed of several stacks and should create a new stack once the
 *            previous one exceeds capacity. SetOfStacks. push() and SetOfStacks.
 *            pop() should behave identically to a single stack (that is, pop ()
 *            should return the same values as it would if there were just a
 *            single stack).
 * Author:    Dinko Osrecki
 * Date:      28/12/2016
 */
public class SetOfStacks<E> {
  private static final int DEFAULT_CAPACITY = 16;

  private List<Stack<E>> stacks;
  private int capacity;

  public SetOfStacks() {
    this(DEFAULT_CAPACITY);
  }

  SetOfStacks(int capacity) {
    stacks = new ArrayList<>();
    this.capacity = capacity;
  }

  void push(E element) {
    Stack<E> stack = currentStack();

    if(stack != null && stack.size() < capacity) {
      stack.push(element);
    } else {
      stack = new Stack<>();
      stack.push(element);

      stacks.add(stack);
    }
  }

  public E pop() {
    Stack<E> stack = currentStack();
    if(stack == null) throw new NoSuchElementException();

    E element = stack.pop();
    if(stack.size() == 0) stacks.remove(stacks.size() - 1);

    return element;
  }

  E popAt(int stackIndex) {
    if(stackIndex >= stacks.size()) throw new IndexOutOfBoundsException();
    if(stackIndex == stacks.size() - 1) return pop();

    E element = stacks.get(stackIndex).pop();
    shiftStack(stackIndex + 1);

    return element;
  }

  private void shiftStack(int stackIndex) {
    Stack<E> stack = stacks.get(stackIndex);

    Stack<E> buffer = new Stack<>();
    while(!stack.isEmpty())
      buffer.push(stack.pop());

    // bottom element from the next stack in the set
    stacks.get(stackIndex - 1).push(buffer.pop());

    if(buffer.isEmpty()) {
      stacks.remove(stackIndex);
      return;
    }

    while(!buffer.isEmpty())
      stack.push(buffer.pop());

    if(stackIndex + 1 < stacks.size())
      shiftStack(stackIndex + 1);
  }

  public int size() {
    return stacks.stream().mapToInt(Vector::size).sum();
  }

  private Stack<E> currentStack() {
    if(stacks.size() == 0) return null;

    return stacks.get(stacks.size() - 1);
  }
}
