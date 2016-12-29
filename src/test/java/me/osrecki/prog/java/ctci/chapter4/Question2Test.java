package me.osrecki.prog.java.ctci.chapter4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:  Given a sorted (increasing order) array with unique integer elements,
 *            write an algorithm to create a binary search tree with minimal height.
 * Author:    Dinko Osrecki
 * Date:      28/12/2016
 */
public class Question2Test {
  @Test
  public void shouldCreateMinimalTree() {
    int[] values = new int[]{1, 2, 3, 4, 5};

    BinaryTree.Node root = Question2.minimalTree(values);
    Assert.assertEquals("Root should be node 3.", root.value, 3);

    BinaryTree.Node node1 = root.left;
    Assert.assertEquals("Left child of root should be node 1.", node1.value, 1);
    BinaryTree.Node node4 = root.right;
    Assert.assertEquals("Right child of root should be node 4.", node4.value, 4);

    Assert.assertNull("Left child of node 1 should be null.", node1.left);
    Assert.assertEquals("Right child of node 1 should be node 2.", node1.right.value, 2);

    Assert.assertNull("Left child of node 4 should be null.", node4.left);
    Assert.assertEquals("Right child of node 4 should be node 5.", node4.right.value, 5);
  }
}
