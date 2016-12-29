package me.osrecki.prog.java.ctci.chapter4;

/**
 * Question:  Implement a function to check if a binary tree is a binary
 *            search tree.
 * Author:    Dinko Osrecki
 * Date:      29/12/2016
 */
public class Question5 {
  /**
   * Idea:  All values in the left subtree have to be less than or equal to the
   *        root value AND all values in the right subtree. Root value has to be
   *        (strictly) less than all the values in the right subtree. We can achieve
   *        this by specifying the allowable range for values in the subtree and
   *        recursively narrowing it as we progress deeper inside the tree.
   * Time:  O(N)
   * Space: O(D) because of recursion, where |D| is the depth of the tree
   */
  static boolean isBST(BinaryTree.Node root) {
    return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean isBSTRec(BinaryTree.Node node, int min, int max) {
    if(node == null) return true;
    if(!(min <= node.value && node.value <= max)) return false;

    return isBSTRec(node.left, min, node.value) && isBSTRec(node.right, node.value + 1, max);
  }
}
