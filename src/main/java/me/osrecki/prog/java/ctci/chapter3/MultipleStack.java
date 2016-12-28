package me.osrecki.prog.java.ctci.chapter3;

import java.util.NoSuchElementException;

/**
 * Question:  Describe how you could use a single array to implement three stacks.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
public class MultipleStack<E> {
  private static final int DEFAULT_STACK_CAPACITY = 16;
  private static final int STACKS_COUNT = 3;

  private Object[]  values;
  private int[]     sizes;
  private int       capacity;

  public MultipleStack() {
    this(DEFAULT_STACK_CAPACITY);
  }

  public MultipleStack(int capacity) {
    this.capacity = capacity;
    this.values = new Object[capacity * STACKS_COUNT];
    this.sizes = new int[STACKS_COUNT];
  }

  public void push(int stackNumber, E element) {
    if(stackNumber < 0 || stackNumber >= STACKS_COUNT)
      throw new IllegalArgumentException("Invalid stack number: "+ stackNumber +", Stacks: "+ STACKS_COUNT +".");

    if(isFull(stackNumber))
      throw new RuntimeException("Stack full.");

    values[topIndex(stackNumber)] = element;
    sizes[stackNumber]++;
  }

  public E pop(int stackNumber) {
    E element = peek(stackNumber);

    values[topIndex(stackNumber) - 1] = null;
    sizes[stackNumber]--;

    return element;
  }

  @SuppressWarnings("unchecked")
  public E peek(int stackNumber) {
    if(stackNumber < 0 || stackNumber >= STACKS_COUNT)
      throw new IllegalArgumentException("Invalid stack number: "+ stackNumber +", Stacks: "+ STACKS_COUNT +".");

    if(isEmpty(stackNumber))
      throw new NoSuchElementException("Stack empty.");

    return (E)values[topIndex(stackNumber) - 1];
  }

  private int topIndex(int stackNumber) {
    return stackNumber * capacity + sizes[stackNumber];
  }

  public int size(int stackNumber) {
    if(stackNumber < 0 || stackNumber >= STACKS_COUNT)
      throw new IllegalArgumentException("Invalid stack number: "+ stackNumber +", Stacks: "+ STACKS_COUNT +".");

    return sizes[stackNumber];
  }

  public boolean isEmpty(int stackNumber) {
    if(stackNumber < 0 || stackNumber >= STACKS_COUNT)
      throw new IllegalArgumentException("Invalid stack number: "+ stackNumber +", Stacks: "+ STACKS_COUNT +".");

    return sizes[stackNumber] == 0;
  }

  private boolean isFull(int stackNumber) {
    return sizes[stackNumber] == capacity;
  }
}
