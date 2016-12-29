package me.osrecki.prog.java.ctci.chapter4;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Question:  Implement a function to check if a binary tree is balanced. For
 *            the purposes of this question, a balanced tree is defined to be
 *            a tree such that the heights of the two subtrees of any node never
 *            differ by more than one.
 * Author:    Dinko Osrecki
 * Date:      29/12/2016
 */
public class Question4Test {
  private static BinaryTree.Node root;

  @BeforeClass
  public static void initializeTests() {
    BinaryTree.Node node1 = new BinaryTree.Node(1, null, null);
    BinaryTree.Node node2 = new BinaryTree.Node(2, node1, null);

    BinaryTree.Node node7 = new BinaryTree.Node(7, null, null);
    BinaryTree.Node node6 = new BinaryTree.Node(6, null, node7);
    BinaryTree.Node node9 = new BinaryTree.Node(9, null, null);
    BinaryTree.Node node8 = new BinaryTree.Node(8, node6, node9);

    root = new BinaryTree.Node(5, node2, node8);
  }

  @Test
  public void shouldBeBalanced() {
    assertThat("Tree should be balanced.", evaluate(root), everyItem(is(true)));
  }

  @Test
  public void shouldNotBeBalanced() {
    BinaryTree.Node node10 = new BinaryTree.Node(11, null, null);
    BinaryTree.Node newRoot = new BinaryTree.Node(10, root, node10);

    // Not balanced due to difference in subtrees' heights
    assertThat("Tree should not be balanced.", evaluate(newRoot), everyItem(is(false)));
  }

  @Test
  public void shouldNotBeBalanced2() {
    BinaryTree.Node node1 = new BinaryTree.Node(1, null, null);
    BinaryTree.Node node2 = new BinaryTree.Node(2, node1, null);
    BinaryTree.Node node3 = new BinaryTree.Node(3, node2,  null);
    assertThat("Tree at node 3 should not be balanced.", evaluate(node3), everyItem(is(false)));

    BinaryTree.Node node6 = new BinaryTree.Node(6, null, null);
    BinaryTree.Node node5 = new BinaryTree.Node(5, null, node6);
    assertThat("Tree at node 5 should be balanced.", evaluate(node5), everyItem(is(true)));

    BinaryTree.Node root = new BinaryTree.Node(4, node3, node5);
    // Not balanced due to one subtree not being balanced
    assertThat("Tree at node 4 should not be balanced.", evaluate(root), everyItem(is(false)));
  }

  private List<Boolean> evaluate(BinaryTree.Node root) {
    return Arrays.asList(Question4.isBalanced(root), Question4.isBalanced2(root));
  }
}
