package me.osrecki.prog.java.ctci.chapter4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Question:  Given a binary tree, design an algorithm which creates a linked
 *            list of all the nodes at each depth (e.g., if you have a tree
 *            with depth D, you'll have D linked lists).
 * Author:    Dinko Osrecki
 * Date:      29/12/2016
 */
public class Question3Test {
  private BinaryTree.Node root;
  private BinaryTree.Node[] nodes;

  @Before
  public void initializeTest() {
    // Level 3
    BinaryTree.Node node4 = new BinaryTree.Node(4, null, null);
    BinaryTree.Node node7 = new BinaryTree.Node(7, null, null);
    BinaryTree.Node node10 = new BinaryTree.Node(10, null, null);
    // Level 2
    BinaryTree.Node node1 = new BinaryTree.Node(1, null, null);
    BinaryTree.Node node3 = new BinaryTree.Node(3, null, node4);
    BinaryTree.Node node6 = new BinaryTree.Node(6, null, node7);
    BinaryTree.Node node9 = new BinaryTree.Node(9, null, node10);
    // Level 1
    BinaryTree.Node node2 = new BinaryTree.Node(2, node1, node3);
    BinaryTree.Node node8 = new BinaryTree.Node(8, node6, node9);
    // Level 0
    BinaryTree.Node node5 = new BinaryTree.Node(5, node2, node8);

    root = node5;
    nodes = new BinaryTree.Node[]{node1, node2, node3, node4, node5, node6, node7, node8, node9, node10};
  }

  @Test
  public void shouldCreateListOfDepths() {
    List<List<BinaryTree.Node>> listOfDepths = Question3.listOfDepths(root);

    Assert.assertEquals("List of depths should have size of 4.", listOfDepths.size(), 4);

    Assert.assertEquals("1st list should have size of 1.", listOfDepths.get(0).size(), 1);
    Assert.assertTrue("1st list should contain node 5.", listOfDepths.get(0).contains(nodes[4]));

    Assert.assertEquals("2nd list should have size of 2.", listOfDepths.get(1).size(), 2);
    Assert.assertTrue("2nd list should contain node 8.", listOfDepths.get(1).contains(nodes[7]));

    Assert.assertEquals("3rd list should have size of 4.", listOfDepths.get(2).size(), 4);
    Assert.assertTrue("3rd list should contain node 6.", listOfDepths.get(2).contains(nodes[5]));

    Assert.assertEquals("4th list should have size of 3", listOfDepths.get(3).size(), 3);
    Assert.assertTrue("4th list should contain node 7.", listOfDepths.get(3).contains(nodes[6]));
  }
}

