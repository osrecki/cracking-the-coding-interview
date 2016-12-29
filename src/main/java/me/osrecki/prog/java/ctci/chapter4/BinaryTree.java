package me.osrecki.prog.java.ctci.chapter4;

/**
 * Author:  Dinko Osrecki
 * Date:    28/12/2016
 */
class BinaryTree {
  private Node root;

  BinaryTree(Node root) {
    this.root = root;
  }

  static class Node {
    int value;
    Node left, right;
    Node parent;

    Node(int value, Node left, Node right) {
      this.value  = value;
      this.left   = left;
      this.right  = right;

      if(left != null) left.parent = this;
      if(right != null) right.parent = this;
    }
  }
}
