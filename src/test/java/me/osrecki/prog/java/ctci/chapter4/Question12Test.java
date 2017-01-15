package me.osrecki.prog.java.ctci.chapter4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:  You are given a binary tree in which each node contains an integer
 *            value (which might be positive or negative). Design an algorithm to
 *            count the number of paths that sum to a given value. The path does
 *            not need to start or end at the root or a leaf, but it must go
 *            downwards (traveling only from parent nodes to child nodes).
 * Author:    Dinko Osrecki
 * Date:      15/01/2017
 */
public class Question12Test {
  @Test
  public void shouldCountPathsWithSum() {
    BinaryTree.Node node3Leaf = new BinaryTree.Node(3, null, null);
    BinaryTree.Node nodeMinus2 = new BinaryTree.Node(-2, null, null );
    BinaryTree.Node node3 = new BinaryTree.Node(3, node3Leaf, nodeMinus2);

    BinaryTree.Node node2 = new BinaryTree.Node(2, null, null);
    BinaryTree.Node nodeMinus1Leaf = new BinaryTree.Node(-1, null, node2);

    BinaryTree.Node node5 = new BinaryTree.Node(5, node3, nodeMinus1Leaf);

    BinaryTree.Node nodeMinus3Leaf = new BinaryTree.Node(-3, null, null);
    BinaryTree.Node nodeMinus1 = new BinaryTree.Node(-1, null, nodeMinus3Leaf);

    BinaryTree.Node root = new BinaryTree.Node(10, node5, nodeMinus1);

    Assert.assertEquals(evaluate(root, 6), 4);
    Assert.assertEquals(evaluate(root, 8), 1);
    Assert.assertEquals(evaluate(root, 1), 2);
  }

  private int evaluate(BinaryTree.Node root, int targetSum) {
    return new BinaryTree(root).countPathsWithSum(targetSum);
  }
}
