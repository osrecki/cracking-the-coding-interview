package me.osrecki.prog.java.ctci.chapter4;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Question:  A binary search tree was created by traversing through an array
 *            from left to right and inserting each element. Given a binary
 *            search tree with distinct elements, print all possible arrays
 *            that could have led to this tree.
 * Author:    Dinko Osrecki
 * Date:      03/01/2017
 */
public class Question9Test {
  @Test
  public void shouldFindBstSequences() {
    BinaryTree.Node node1 = new BinaryTree.Node(1, null, null);

    Assert.assertThat(evaluate(node1).size(), is(1));

    BinaryTree.Node node3 = new BinaryTree.Node(3, null, null);
    BinaryTree.Node root = new BinaryTree.Node(2, node1, node3);

    LinkedList<Integer> sequence1 = new LinkedList<>(Arrays.asList(new Integer[]{2, 3, 1}));
    LinkedList<Integer> sequence2 = new LinkedList<>(Arrays.asList(new Integer[]{2, 1, 3}));

    Assert.assertThat(evaluate(root), Matchers.containsInAnyOrder(is(sequence1), is(sequence2)));

    BinaryTree.Node node10 = new BinaryTree.Node(10, null, null);
    BinaryTree.Node node14 = new BinaryTree.Node(14, null, null);
    BinaryTree.Node node13 = new BinaryTree.Node(13, null, node14);
    BinaryTree.Node node12 = new BinaryTree.Node(12, node10, node13);

    sequence1 = new LinkedList<>(Arrays.asList(new Integer[]{12, 10, 13, 14}));
    sequence2 = new LinkedList<>(Arrays.asList(new Integer[]{12, 13, 10, 14}));
    LinkedList<Integer> sequence3 = new LinkedList<>(Arrays.asList(new Integer[]{12, 13, 14, 10}));

    Assert.assertThat(evaluate(node12), Matchers.containsInAnyOrder(is(sequence1), is(sequence2), is(sequence3)));

    root = new BinaryTree.Node(5, root, node12);
    Assert.assertThat(evaluate(root).size(), is(210));
  }

  private ArrayList<LinkedList<Integer>> evaluate(BinaryTree.Node root) {
    return Question9.bstSequences(root);
  }
}
