package me.osrecki.prog.java.ctci.chapter3;

import org.junit.Assert;
import org.junit.Test;

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
public class SetOfStacksTest {
  @Test
  public void shouldAddAndRemoveElements() {
    SetOfStacks<Integer> stack = new SetOfStacks<>(5);
    for(int i = 0; i < 10; i++)
      stack.push(i);

    Assert.assertEquals("Stack size should be 10.", stack.size(), 10);

    Assert.assertEquals("Stack top element should be 9.", stack.pop(), new Integer(9));
    Assert.assertEquals("Stack size should be 9.", stack.size(), 9);

    Assert.assertEquals("Top element of the first stack in the set should be 4.",
      stack.popAt(0), new Integer(4)
    );
    Assert.assertEquals("Stack size should be 8.", stack.size(), 8);

    // Stack shifting
    Assert.assertEquals("Top element of the first stack in the set should be 5.",
      stack.popAt(0), new Integer(5)
    );
    Assert.assertEquals("Stack size should be 7.", stack.size(), 7);

    Assert.assertEquals("Stack top element should be 8.", stack.pop(), new Integer(8));
    Assert.assertEquals("Stack size should be 6.", stack.size(), 6);
  }
}
