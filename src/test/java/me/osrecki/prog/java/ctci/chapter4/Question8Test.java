package me.osrecki.prog.java.ctci.chapter4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Question:  Design an algorithm and write code to find the first common ancestor
 *            of two nodes in a binary tree. Avoid storing additional nodes in a
 *            data structure. NOTE: This is not necessarily a binary search tree.
 * Author:    Dinko Osrecki
 * Date:      02/01/2017
 */
public class Question8Test {
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
  public void nodesShouldHaveCommonAncestor() {
    Assert.assertEquals("Nodes 4 and 3 should have node 3 as a first common ancestor.", nodes[2],
      evaluate(root, nodes[3], nodes[2])
    );

    Assert.assertEquals("Root and root should have root as a first common ancestor.", root,
      evaluate(root, root, root)
    );

    Assert.assertEquals("Node 7 and 10 should have node 8 as a first common ancestor.", nodes[7],
      evaluate(root, nodes[9], nodes[6])
    );

    Assert.assertEquals("Node 1 and node 10 should have root as a first common ancestor.", root,
      evaluate(root, nodes[0], nodes[9])
    );
  }

  @Test
  public void nodesShouldNotHaveCommonAncestor() {
    BinaryTree.Node missingNode = new BinaryTree.Node(0, null, null);

    for(BinaryTree.Node node : nodes)
      Assert.assertNull(evaluate(root, node, missingNode));
  }

  private BinaryTree.Node evaluate(BinaryTree.Node root, BinaryTree.Node first, BinaryTree.Node second) {
    return Question8.firstCommonAncestor(root, first, second);
  }
}
