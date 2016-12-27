package me.osrecki.prog.java.ctci.chapter3;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
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
public class Question5Test {
  @Test
  public void shouldSortStack() {
    Stack<Integer> stack = populateStack(new Integer[]{1, 5, -1, 3, 7, 8, 4, 4, 6, 2, 10});
    Stack<Integer> sorted = populateStack(new Integer[]{10, 8, 7, 6, 5, 4, 4, 3, 2, 1, -1});

    Assert.assertThat("Stack '"+ stack +"' should be transformed to '"+ sorted +"'.",
      evaluate(stack), CoreMatchers.is(sorted)
    );

    Assert.assertThat("Stack '"+ sorted +"' should be transformed to '"+ sorted +"'.",
      evaluate(sorted), CoreMatchers.is(sorted)
    );

    stack = populateStack(new Integer[]{-1, 1, 2, 3, 4, 4, 5, 6, 7, 8, 10});

    Assert.assertThat("Stack '"+ stack +"' should be transformed to '"+ sorted +"'.",
      evaluate(stack), CoreMatchers.is(sorted)
    );
  }

  @SuppressWarnings("unchecked")
  private Stack<Integer> evaluate(Stack<Integer> stack) {
    return Question5.sortStack((Stack<Integer>)stack.clone());
  }

  private Stack<Integer> populateStack(Integer[] elements) {
    Stack<Integer> stack = new Stack<>();
    stack.addAll(Arrays.asList(elements));
    return stack;
  }
}
