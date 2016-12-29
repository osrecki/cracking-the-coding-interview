package me.osrecki.prog.java.ctci.chapter4;

/**
 * Question:  Implement a function to check if a binary tree is balanced. For
 *            the purposes of this question, a balanced tree is defined to be
 *            a tree such that the heights of the two subtrees of any node never
 *            differ by more than one.
 * Author:    Dinko Osrecki
 * Date:      29/12/2016
 */
class Question4 {
  private static final int EMPTY_TREE_HEIGHT = -1;
  private static final int NOT_BALANCED_CODE = -2;

  /**
   * Idea:  Calculate the height of each subtree bottom-up, and along the way
   *        check if the tree is balanced. Height of the empty tree is defined
   *        as -1, and height of the single node tree is defined as 0.
   * Time:  O(N)
   * Space: O(D) where |D| is the depth of the tree
   */
  static boolean isBalanced(BinaryTree.Node root) {
    return isBalancedRec(root) != NOT_BALANCED_CODE;
  }

  private static int isBalancedRec(BinaryTree.Node node) {
    if(node == null) return EMPTY_TREE_HEIGHT;

    int leftHeight = isBalancedRec(node.left);
    if(leftHeight == NOT_BALANCED_CODE) return NOT_BALANCED_CODE;

    int rightHeight = isBalancedRec(node.right);
    if(rightHeight == NOT_BALANCED_CODE) return NOT_BALANCED_CODE;

    int difference = Math.abs(leftHeight - rightHeight);
    if(difference > 1) return NOT_BALANCED_CODE;
    else return Math.max(leftHeight, rightHeight) + 1;
  }

  /**
   * Idea:  Similar to above, but returns tuple with height of the subtree and
   *        flag that tells if the subtree is balanced.
   * @see #isBalanced(BinaryTree.Node)
   */
  static boolean isBalanced2(BinaryTree.Node root) {
    PartialResult result = isBalanced2Rec(root);
    return result.balanced;
  }

  private static PartialResult isBalanced2Rec(BinaryTree.Node node) {
    if(node == null) return new PartialResult(true, EMPTY_TREE_HEIGHT);

    PartialResult left = isBalanced2Rec(node.left);
    PartialResult right = isBalanced2Rec(node.right);

    boolean balanced = left.balanced && right.balanced && Math.abs(left.height - right.height) <= 1;
    int height = Math.max(left.height, right.height) + 1;

    return new PartialResult(balanced, height);
  }

  private static class PartialResult {
    private boolean balanced;
    private int     height;

    PartialResult(boolean balanced, int height) {
      this.balanced = balanced;
      this.height   = height;
    }
  }
}
