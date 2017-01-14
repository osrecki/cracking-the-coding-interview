package me.osrecki.prog.java.ctci.chapter4;

import static org.junit.Assert.assertThat;
import org.junit.Test;

import java.util.List;

import static me.osrecki.prog.java.ctci.TestHelper.testMethodsResults;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

/**
 * Question:  Tl and T2 are two very large binary trees, with Tl much bigger than
 *            T2. Create an algorithm to determine if T2 is a subtree of Tl.
 *            A tree T2 is a subtree of Tl if there exists a node n in Tl such
 *            that the subtree of n is identical to T2. That is, if you cut off
 *            the tree at node n, the two trees would be identical.
 * Author:    Dinko Osrecki
 * Date:      14/01/2017
 */
public class Question10Test {
  @Test
  public void shouldContainSubtree() {
    BinaryTree.Node node1 = new BinaryTree.Node(1, null, null);
    BinaryTree.Node node3 = new BinaryTree.Node(3, null, null);
    BinaryTree.Node node2 = new BinaryTree.Node(2, node1, node3);

    BinaryTree.Node node10 = new BinaryTree.Node(10, null, null);
    BinaryTree.Node node14 = new BinaryTree.Node(14, null, null);
    BinaryTree.Node node13 = new BinaryTree.Node(13, null, node14);
    BinaryTree.Node node12 = new BinaryTree.Node(12, node10, node13);

    BinaryTree.Node root = new BinaryTree.Node(5, node2, node12);

    assertThat(evaluate(root, root), everyItem(is(true)));
    assertThat(evaluate(root, node10), everyItem(is(true)));
    assertThat(evaluate(root, node2), everyItem(is(true)));
    assertThat(evaluate(root, null), everyItem(is(true)));

    BinaryTree.Node node1Clone = new BinaryTree.Node(1, null, null);
    BinaryTree.Node node3Clone = new BinaryTree.Node(3, null, null);
    BinaryTree.Node node2Clone = new BinaryTree.Node(2, node1Clone, node3Clone);

    assertThat(evaluate(root, node2Clone), everyItem(is(true)));
  }

  @Test
  public void shouldNotContainSubtree() {
    BinaryTree.Node node4 = new BinaryTree.Node(4, null, null);
    BinaryTree.Node root1 = new BinaryTree.Node(3, null, node4);

    BinaryTree.Node node3 = new BinaryTree.Node(3, null, null);
    BinaryTree.Node root2 = new BinaryTree.Node(4, node3, null);

    assertThat(evaluate(root1, root2), everyItem(is(false)));
  }

  private List<Boolean> evaluate(BinaryTree.Node tree1, BinaryTree.Node tree2) {
    return testMethodsResults(Question10.class, "containsSubtree", tree1, tree2);
  }
}
