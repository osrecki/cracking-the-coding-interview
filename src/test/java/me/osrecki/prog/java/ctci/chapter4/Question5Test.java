package me.osrecki.prog.java.ctci.chapter4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Question:  Implement a function to check if a binary tree is a binary
 *            search tree.
 * Author:    Dinko Osrecki
 * Date:      29/12/2016
 */
public class Question5Test {
  @Test
  public void shouldBeBinarySearchTree() {
    BinaryTree.Node node1 = new BinaryTree.Node(1, null, null);

    BinaryTree.Node node4 = new BinaryTree.Node(4, null, null);
    BinaryTree.Node node7 = new BinaryTree.Node(7, null, null);
    BinaryTree.Node node6 = new BinaryTree.Node(6, node4, node7);

    BinaryTree.Node node3 = new BinaryTree.Node(3, node1, node6);

    BinaryTree.Node node13 = new BinaryTree.Node(13, null, null);
    BinaryTree.Node node14 = new BinaryTree.Node(14, node13, null);
    BinaryTree.Node node10 = new BinaryTree.Node(10, null, node14);

    BinaryTree.Node root = new BinaryTree.Node(8, node3, node10);
    assertTrue("Tree should be binary search tree.", Question5.isBST(root));
  }

  @Test
  public void shouldNotBeBinarySearchTree() {
    BinaryTree.Node node1 = new BinaryTree.Node(1, null, null);
    BinaryTree.Node node9 = new BinaryTree.Node(9, null, null);
    BinaryTree.Node node3 = new BinaryTree.Node(3, node1, node9);
    assertTrue("Subtree at node 3 should be binary search tree.", Question5.isBST(node3));

    BinaryTree.Node node6 = new BinaryTree.Node(6, null, null);
    BinaryTree.Node node5 = new BinaryTree.Node(5, null, node6);
    assertTrue("Subtree at node 5 should be binary search tree.", Question5.isBST(node5));

    BinaryTree.Node root = new BinaryTree.Node(4, node3, node5);
    assertFalse("Tree should not be binary search tree.", Question5.isBST(root));
  }

  @Test
  public void duplicatesShouldGoToLeftBranch() {
    BinaryTree.Node node1 = new BinaryTree.Node(1, null, null);
    BinaryTree.Node root = new BinaryTree.Node(1, node1, null);
    assertTrue("Tree should be binary search tree.", Question5.isBST(root));

    root = new BinaryTree.Node(1, null, node1);
    assertFalse("Tree should not be binary search tree.", Question5.isBST(root));
  }
}
