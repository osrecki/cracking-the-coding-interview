package me.osrecki.prog.java.ctci.chapter3;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

/**
 * Question:  Describe how you could use a single array to implement three stacks.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
public class MultipleStackTest {
  private static final int STACK_CAPACITY = 10;

  @Rule
  public ExpectedException exception = ExpectedException.none();

  private MultipleStack<Integer> stack;

  @Before
  public void initializeTest() {
    stack = new MultipleStack<>(STACK_CAPACITY);
  }

  @Test
  public void shouldPushElementToStack() {
    stack.push(0, 1);
    Assert.assertEquals("Stack 0 top element should be 1.", stack.peek(0), new Integer(1));

    stack.push(1, 100);
    Assert.assertEquals("Stack 1 top element should be 100.", stack.peek(1), new Integer(100));

    stack.push(2, -50);
    Assert.assertEquals("Stack 1 top element should be 100.", stack.peek(2), new Integer(-50));
  }

  @Test
  public void shouldPeekElementOnStack() {
    int stackNumber = 2;

    stack.push(stackNumber, 1);
    stack.push(stackNumber, 2);

    Integer top = stack.peek(stackNumber);
    Assert.assertEquals("Stack should peek element 2.", top, new Integer(2));
    Assert.assertEquals("Stack should have size 2.", stack.size(stackNumber), 2);
  }

  @Test
  public void shouldPopElementFromStack() {
    int stackNumber = 0;

    stack.push(stackNumber, 1);
    stack.push(stackNumber, 2);
    stack.push(stackNumber, 3);

    Integer top = stack.pop(stackNumber);
    Assert.assertEquals("Stack should pop element 3.", top, new Integer(3));
    Assert.assertEquals("Stack should have size 2.", stack.size(stackNumber), 2);
  }

  @Test
  public void shouldThrowExceptionOnEmptyStack() {
    exception.expect(NoSuchElementException.class);
    exception.expectMessage(CoreMatchers.is("Stack empty."));

    stack.pop(0);
  }

  @Test
  public void shouldThrowExceptionOnFullStack() {
    exception.expect(RuntimeException.class);
    exception.expectMessage(CoreMatchers.is("Stack full."));

    for(int i = 0; i <= STACK_CAPACITY; i++) {
      stack.push(0, i);
    }
  }

  @Test
  public void shouldThrowExceptionOnInvalidStackNumber() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage(CoreMatchers.startsWith("Invalid stack number"));

    stack.peek(3);
  }
}
