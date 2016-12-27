package me.osrecki.prog.java.ctci.chapter2;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Question:  Given two (singly) linked lists, determine if the two lists intersect.
 *            Return the intersecting node. Note that the intersection is defined
 *            based on reference, not value. That is, if the kth node of the first
 *            linked list is the exact same node (by reference) as the jth node of
 *            the second linked list, then they are intersecting.
 * Author:    Dinko Osrecki
 * Date:      27/12/2016
 */
public class Question7Test {
  @Test
  public void listsShouldIntersect() {
    ConnectedList<Integer> commonList = new ConnectedList<>(1, 2, 3, 4);
    ConnectedList.Node<Integer> intersection = commonList.head();


    ConnectedList.Node<Integer> head1 = new ConnectedList.Node<>(-1, intersection);
    head1 = new ConnectedList.Node<>(-2, head1);
    head1 = new ConnectedList.Node<>(-3, head1);

    ConnectedList.Node<Integer> head2 = new ConnectedList.Node<>(0, intersection);
    head2 = new ConnectedList.Node<>(1000, head2);

    assertThat("Lists should intersect at node '"+ intersection.element +"'.",
      evaluate(head1, head2), is(intersection)
    );

    assertThat("Lists should intersect at node '"+ intersection.element +"'.",
      evaluate(head2, head1), is(intersection)
    );

    assertThat("Lists should intersect at node '"+ intersection.element +"'.",
      evaluate(head1, intersection), is(intersection)
    );

    assertThat("Lists should intersect at node '"+ intersection.element +"'.",
      evaluate(intersection, head2), is(intersection)
    );
  }

  @Test
  public void listsShouldNotIntersect() {
    ConnectedList<Integer> list1 = new ConnectedList<>(1, 2, 3, 4);
    ConnectedList<Integer> list2 = new ConnectedList<>(1, 2, 3, 4);

    assertThat("Lists should not intersect.", evaluate(list1.head(), list2.head()), is(nullValue()));
  }

  private ConnectedList.Node<Integer> evaluate(ConnectedList.Node<Integer> head1, ConnectedList.Node<Integer> head2) {
    return Question7.intersect(head1, head2);
  }
}

