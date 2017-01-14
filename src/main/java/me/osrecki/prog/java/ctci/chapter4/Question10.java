package me.osrecki.prog.java.ctci.chapter4;

/**
 * Question:  Tl and T2 are two very large binary trees, with Tl much bigger than
 *            T2. Create an algorithm to determine if T2 is a subtree of Tl.
 *            A tree T2 is a subtree of Tl if there exists a node n in Tl such
 *            that the subtree of n is identical to T2. That is, if you cut off
 *            the tree at node n, the two trees would be identical.
 * Author:    Dinko Osrecki
 * Date:      14/01/2017
 */
public class Question10 {
  /**
   * Idea:  Build pre-order string representations accounting for NULL nodes, too.
   *        Otherwise, two tress with different structure could have equal pre-order
   *        traversals. If pre-order representation of Tree 1 contains pre-order string
   *        of Tree 2, return true. Otherwise, return false.
   */
  public static boolean containsSubtree1(BinaryTree.Node root1, BinaryTree.Node root2) {
    StringBuilder tree1PreOrder = new StringBuilder();
    StringBuilder tree2PreOrder = new StringBuilder();

    buildPreOrderString(root1, tree1PreOrder);
    buildPreOrderString(root2, tree2PreOrder);

    return tree1PreOrder.indexOf(tree2PreOrder.toString()) != -1;
  }

  private static void buildPreOrderString(BinaryTree.Node root, StringBuilder sb) {
    if (root == null) {
      sb.append("NULL ");
    } else {
      sb.append(root.value).append(" ");
      buildPreOrderString(root.left, sb);
      buildPreOrderString(root.right, sb);
    }
  }

  /**
   * Idea:  Recurse through Tree 1. When you encounter a node equal to the root of
   *        Tree 2, recurse through both trees and compare their nodes for equality.
   */
  public static boolean containsSubtree2(BinaryTree.Node root1, BinaryTree.Node root2) {
    if(root2 == null) return true;

    return _containsSubtreeRec(root1, root2);
  }

  private static boolean _containsSubtreeRec(BinaryTree.Node root1, BinaryTree.Node root2) {
    if(root1 == null) {
      return false;
    } else if(root1.value == root2.value && equalTree(root1, root2)) {
      return true;
    } else {
      return _containsSubtreeRec(root1.left, root2)|| containsSubtree1(root1.right, root2);
    }
  }

  private static boolean equalTree(BinaryTree.Node root1, BinaryTree.Node root2) {
    if(root1 == null && root2 == null) {
      return true;
    } else if(root1 == null || root2 == null) {
      return false;
    } else if(root1.value != root2.value) {
      return false;
    } else {
      return equalTree(root1.left, root2.left) && equalTree(root1.right, root2.right);
    }
  }
}
