package me.osrecki.prog.java.ctci.chapter2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Question:  Write code to partition a linked list around a value x, such
 *            that all nodes less than x come before all nodes greater than
 *            or equal to x. If x is contained within the list the values of
 *            x only need to be after the elements less than x (see below). The
 *            partition element x can appear anywhere in the "right partition";
 *            it does not need to appear between the left and right partitions.
 * Author:    Dinko Osrecki
 * Date:      24/12/2016
 */
public class Question4Test {
  @Test
  public void shouldPartitionList() {
    ConnectedList<Integer> list1 = new ConnectedList<>(2, 7, 5, 4, 8, 10, 5);
    int divider = 5;
    ConnectedList<Integer> list2 = new ConnectedList<>(4, 2, 7, 5, 8, 10, 5);

    assertThat("'"+ list1 +"' should be transformed into '"+ list2 +"'.",
      evaluate(list1, divider), everyItem(is(list2))
    );

    list1 = new ConnectedList<>(3, 5, 8, 5, 10, 2, 1);
    divider = 4;
    list2 = new ConnectedList<>(1, 2, 3, 5, 8, 5, 10);

    assertThat("'"+ list1 +"' should be transformed into '"+ list2 +"'.",
      evaluate(list1, divider), everyItem(is(list2))
    );

    list1 = new ConnectedList<>(1, 2, 3, 4, 5);
    divider = 10;
    list2 = new ConnectedList<>(5, 4, 3, 2, 1);

    assertThat("'"+ list1 +"' should be transformed into '"+ list2 +"'.",
      evaluate(list1, divider), everyItem(is(list2))
    );
  }

  @SuppressWarnings("unchecked")
  private List<ConnectedList<Integer>> evaluate(ConnectedList<Integer> list, int divider) {
    List<ConnectedList.Node<Integer>> results = new ArrayList<>();

    results.add(Question4.partitionList1(((ConnectedList)list.clone()).head(), divider));
    results.add(Question4.partitionList2(((ConnectedList)list.clone()).head(), divider));

    return results.stream().map(ConnectedList::fromNode).collect(Collectors.toList());
  }
}
