package me.osrecki.prog.java.ctci.chapter3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Question:  How would you design a stack which, in addition to push and pop,
 *            has a function min which returns the minimum element? Push, pop
 *            and min should all operate in 0(1) time.
 * Author:    Dinko Osrecki
 * Date:      28/12/2016
 */
public class StackWithMinTest {
  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void shouldRetrieveMinimum() {
    StackWithMin stack = new StackWithMin();

    for(Integer element : new Integer[]{1, 3, 2, -1, 4})
      stack.push(element);

    assertEquals("Minimum should be equal to -1.", stack.min(), new Integer(-1));

    stack.push(-10);
    assertEquals("Minimum should be equal to -10.", stack.min(), new Integer(-10));

    stack.pop();
    assertEquals("Minimum should be equal to -1.", stack.min(), new Integer(-1));

    stack.pop(); stack.pop();
    assertEquals("Minimum should be equal to 1.", stack.min(), new Integer(1));
  }

  @Test
  public void shouldThrowExceptionOnEmptyStack() {
    exception.expect(NoSuchElementException.class);

    StackWithMin stack = new StackWithMin();
    stack.min();
  }
}