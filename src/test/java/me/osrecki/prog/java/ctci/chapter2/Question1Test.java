package me.osrecki.prog.java.ctci.chapter2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Question:  Write code to remove duplicates from an unsorted linked list. How
 *            would you solve this problem if a temporary buffer is not allowed?
 * Author:    Dinko Osrecki
 * Date:      22/12/2016
 */
public class Question1Test {
  @Test
  public void shouldRemoveDuplicate() {
    ConnectedList<Integer> list1 = new ConnectedList<>(1, 2, 3, 4, 2, 5);
    ConnectedList<Integer> list2 = new ConnectedList<>(1, 2, 3, 4, 5);

    assertThat("'"+ list1 +"' should be transformed into '"+ list2 +"'.",
      evaluate(list1), everyItem(is(list2))
    );
  }

  @Test
  public void shouldRemoveDuplicates() {
    ConnectedList<Integer> list1 = new ConnectedList<>(1, 2, 3, 2, 4, 3, 1, 5);
    ConnectedList<Integer> list2 = new ConnectedList<>(1, 2, 3, 4, 5);

    assertThat("'"+ list1 +"' should be transformed into '"+ list2 +"'.",
      evaluate(list1), everyItem(is(list2))
    );

    list1 = new ConnectedList<>(1, 1, 1, 1, 1, 1, 1);
    list2 = new ConnectedList<>(1);

    assertThat("'"+ list1 +"' should be transformed into '"+ list2 +"'.",
      evaluate(list1), everyItem(is(list2))
    );
  }

  @SuppressWarnings("unchecked")
  private List<ConnectedList<Integer>> evaluate(ConnectedList<Integer> list) {
    ArrayList<ConnectedList.Node<Integer>> results = new ArrayList<>();

    results.add(Question1.removeDuplicates1(((ConnectedList)list.clone()).head()));
    results.add(Question1.removeDuplicates2(((ConnectedList)list.clone()).head()));

    return results.stream().map(ConnectedList::fromNode).collect(Collectors.toList());
  }
}
