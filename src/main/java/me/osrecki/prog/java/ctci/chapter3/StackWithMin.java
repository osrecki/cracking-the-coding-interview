package me.osrecki.prog.java.ctci.chapter3;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Question:  How would you design a stack which, in addition to push and pop,
 *            has a function min which returns the minimum element? Push, pop
 *            and min should all operate in 0(1) time.
 * Author:    Dinko Osrecki
 * Date:      28/12/2016
 */
public class StackWithMin extends Stack<Integer> {
  private Stack<Integer> mins = new Stack<>();

  @Override
  public Integer push(Integer item) {
    if(mins.isEmpty() || item < min()) mins.push(item);

    return super.push(item);
  }

  @Override
  public Integer pop() {
    Integer item = super.pop();

    if(item.equals(min())) mins.pop();

    return item;
  }

  Integer min() {
    if(mins.isEmpty()) throw new NoSuchElementException();

    return mins.peek();
  }
}
