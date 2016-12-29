package me.osrecki.prog.java.ctci.chapter4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Question:  Write an algorithm to find the "next" node (i.e., in-order successor)
 *            of a given node in a binary search tree. You may assume that each node
 *            has a link to its parent.
 * Author:    Dinko Osrecki
 * Date:      29/12/2016
 */
public class Question6Test {
  @Test
  public void shouldFindSuccessorOfNode() {
    BinaryTree.Node node1 = new BinaryTree.Node(1, null, null);
    BinaryTree.Node node4 = new BinaryTree.Node(4, null, null);
    BinaryTree.Node node3 = new BinaryTree.Node(3, null, node4);
    BinaryTree.Node node2 = new BinaryTree.Node(2, node1, node3);

    BinaryTree.Node node8 = new BinaryTree.Node(8, null, null);
    BinaryTree.Node node11 = new BinaryTree.Node(11, null, null);
    BinaryTree.Node node10 = new BinaryTree.Node(10, node8, node11);

    BinaryTree.Node node5 = new BinaryTree.Node(5, node2, node10);

    assertThat("Successor of node 1 should be node 2.", evaluate(node1), everyItem(is(node2)));
    assertThat("Successor of node 4 should be node 5.", evaluate(node4), everyItem(is(node5)));
    assertThat("Successor of node 3 should be node 4.", evaluate(node3), everyItem(is(node4)));
    assertThat("Successor of node 2 should be node 3.", evaluate(node2), everyItem(is(node3)));
    assertThat("Successor of node 5 should be node 8.", evaluate(node5), everyItem(is(node8)));
    assertThat("Node 11 should not have successor.", evaluate(node11), everyItem(nullValue(BinaryTree.Node.class)));
  }

  private List<BinaryTree.Node> evaluate(BinaryTree.Node node) {
    return Arrays.asList(Question6.successor(node), Question6.successor2(node));
  }
}
