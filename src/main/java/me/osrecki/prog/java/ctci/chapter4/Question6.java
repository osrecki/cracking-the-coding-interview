package me.osrecki.prog.java.ctci.chapter4;

/**
 * Question:  Write an algorithm to find the "next" node (i.e., in-order successor)
 *            of a given node in a binary search tree. You may assume that each node
 *            has a link to its parent.
 * Author:    Dinko Osrecki
 * Date:      29/12/2016
 */
class Question6 {
  /**
   * Idea:  If node has right child, its successor is the leftmost node in the
   *        right branch. Otherwise if the node is its parent's left child,
   *        successor is the parent. Lastly, if the node is its parent's right
   *        child, we have to traverse upwards until we encounter the situation
   *        in which we move from the left node to the parent.
   * Time:  O(D) where |D| is the depth of the tree
   * Space: O(1)
   */
  static BinaryTree.Node successor(BinaryTree.Node node) {
    if(node == null) return null;
    if(node.right != null) return leftmostNode(node.right);

    BinaryTree.Node parent = node.parent;
    while(parent != null && parent.left != node) {
      node = parent;
      parent = parent.parent;
    }

    return parent;
  }

  private static BinaryTree.Node leftmostNode(BinaryTree.Node node) {
    while(node != null && node.left != null)
      node = node.left;

    return node;
  }

  /**
   * Recursive solution. Unfortunately JVM does not perform tail call
   * optimisation so these solution have greater space complexity.
   */
  static BinaryTree.Node successor2(BinaryTree.Node node) {
    if(node!= null && node.right != null) return leftmostNode2(node.right);

    return successor2Rec(node);
  }

  private static BinaryTree.Node successor2Rec(BinaryTree.Node current) {
    if(current == null || current.parent == null) return null;

    BinaryTree.Node parent = current.parent;
    if(parent.left == current) return parent;
    else return successor2Rec(parent);
  }

  private static BinaryTree.Node leftmostNode2(BinaryTree.Node node) {
    if(node != null && node.left != null) return leftmostNode2(node.left);
    return node;
  }
}
