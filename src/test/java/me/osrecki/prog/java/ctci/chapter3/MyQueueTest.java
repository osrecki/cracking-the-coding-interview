package me.osrecki.prog.java.ctci.chapter3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Question:  Implement a MyQueue class which implements a queue using two stacks.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
public class MyQueueTest {
  MyQueue<Integer> queue;

  @Before
  public void initializeTest() {
    queue = new MyQueue<>();
  }

  @Test
  public void shouldAddElements() {
    queue.add(1);
    queue.add(2);

    Assert.assertEquals("Oldest element in the queue is 1.", queue.peek(), new Integer(1));
    Assert.assertEquals("Queue size is 2.", queue.size(), 2);
  }

  @Test
  public void shouldRemoveElements() {
    queue.add(1);
    queue.add(2);
    queue.add(3);

    Assert.assertEquals("Removed element from the queue is 1.", queue.remove(), new Integer(1));
    Assert.assertEquals("Queue size is 2.", queue.size(), 2);

    queue.remove();
    Assert.assertEquals("Queue size is 1.", queue.size(), 1);
  }

  @Test
  public void shouldAddAndRemoveElements() {
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    Assert.assertEquals("Queue size is 4.", queue.size(), 4);

    Assert.assertEquals("Removed element from the queue is 1.", queue.remove(), new Integer(1));
    Assert.assertEquals("Queue size is 3.", queue.size(), 3);

    queue.add(5);
    Assert.assertEquals("Queue size is 4.", queue.size(), 4);

    for(int i = 0; i < 4; i++)
      queue.remove();

    Assert.assertEquals("Queue size is 0.", queue.size(), 0);
  }
}
