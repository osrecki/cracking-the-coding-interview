package me.osrecki.prog.java.ctci.chapter2;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static me.osrecki.prog.java.ctci.TestHelper.testMethodsResults;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Question:  You have two numbers represented by a linked list, where each node
 *            contains a single digit. The digits are stored in reverse order,
 *            such that the 1 's digit is at the head of the list. Write a function
 *            that adds the two numbers and returns the sum as a linked list.
 *            Suppose the digits are stored in forward order. Repeat the above problem.
 * Author:    Dinko Osrecki
 * Date:      26/12/2016
 */
public class Question5Test {
  private ConnectedList<Integer> number1;

  @Before
  public void initializeTest() {
    number1 = new ConnectedList<>(1, 2, 3);
  }

  @Test
  public void shouldAddTwoReversedLists() {
    ConnectedList<Integer> number2 = new ConnectedList<>(4, 5, 6);
    ConnectedList<Integer> sum = new ConnectedList<>(5, 7, 9);

    assertThat("'"+ number1 +"' and '"+ number2 +"' should give '"+ sum +"'.",
      evaluateReverse(number1, number2), everyItem(is(sum))
    );

    number2 = new ConnectedList<>(4, 5, 6, 7);
    sum = new ConnectedList<>(5, 7, 9, 7);

    assertThat("'"+ number1 +"' and '"+ number2 +"' should give '"+ sum +"'.",
      evaluateReverse(number1, number2), everyItem(is(sum))
    );

    number2 = new ConnectedList<>(1, 1, 7);
    sum = new ConnectedList<>(2, 3, 0, 1);

    assertThat("'"+ number1 +"' and '"+ number2 +"' should give '"+ sum +"'.",
      evaluateReverse(number1, number2), everyItem(is(sum))
    );

    number1 = new ConnectedList<>(1);
    number2 = new ConnectedList<>(2);
    sum = new ConnectedList<>(3);

    assertThat("'"+ number1 +"' and '"+ number2 +"' should give '"+ sum +"'.",
      evaluateReverse(number1, number2), everyItem(is(sum))
    );
  }

  @Test
  public void shouldAddTwoForwardLists() {
    ConnectedList<Integer> number2 = new ConnectedList<>(4, 5, 6);
    ConnectedList<Integer> sum = new ConnectedList<>(5, 7, 9);

    assertThat("'"+ number1 +"' and '"+ number2 +"' should give '"+ sum +"'.",
      evaluateForward(number1, number2), everyItem(is(sum))
    );

    number2 = new ConnectedList<>(9, 9, 9);
    sum = new ConnectedList<>(1, 1, 2, 2);

    assertThat("'"+ number1 +"' and '"+ number2 +"' should give '"+ sum +"'.",
      evaluateForward(number1, number2), everyItem(is(sum))
    );

    number2 = new ConnectedList<>(1);
    sum = new ConnectedList<>(1, 2, 4);

    assertThat("'"+ number1 +"' and '"+ number2 +"' should give '"+ sum +"'.",
      evaluateForward(number1, number2), everyItem(is(sum))
    );
  }

  @Test
  public void shouldAddWithZero() {
    assertThat("'"+ number1 +"' and '"+ 0 +"' should give '"+ number1 +"'.",
      evaluateReverse(number1, null), everyItem(is(number1))
    );
  }

  private List<ConnectedList<Integer>> evaluateReverse(ConnectedList<Integer> number1, ConnectedList<Integer> number2) {
    return evaluate(number1, number2, "sumListsReverse");
  }

  private List<ConnectedList<Integer>> evaluateForward(ConnectedList<Integer> number1, ConnectedList<Integer> number2) {
    return evaluate(number1, number2, "sumListsForward");
  }

  private List<ConnectedList<Integer>> evaluate(ConnectedList<Integer> number1, ConnectedList<Integer> number2, String methodName) {
    ConnectedList.Node<Integer> head1 = number1 == null ? null : number1.head();
    ConnectedList.Node<Integer> head2 = number2 == null ? null : number2.head();

    List<ConnectedList.Node<Integer>> sumHeads = testMethodsResults(Question5.class, methodName, head1, head2);

    return sumHeads.stream().map(ConnectedList::fromNode).collect(Collectors.toList());
  }
}
