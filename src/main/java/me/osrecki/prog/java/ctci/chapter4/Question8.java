package me.osrecki.prog.java.ctci.chapter4;

/**
 * Question:  Design an algorithm and write code to find the first common ancestor
 *            of two nodes in a binary tree. Avoid storing additional nodes in a
 *            data structure. NOTE: This is not necessarily a binary search tree.
 * Author:    Dinko Osrecki
 * Date:      02/01/2017
 */
class Question8 {

  /**
   * Idea:  Recursively search down the tree from root and then recurse results
   *        up the tree.
   * Time:  O(D) where |D| is the depth of the tree
   */
  static BinaryTree.Node firstCommonAncestor(BinaryTree.Node root, BinaryTree.Node first, BinaryTree.Node second) {
    Result result = firstCommonAncestorRec(root, first, second);

    if(result.isCommonAncestor) return result.node;
    return null;
  }

  private static Result firstCommonAncestorRec(BinaryTree.Node root, BinaryTree.Node first, BinaryTree.Node second) {
    if(root == null) return new Result(null, false);
    if(root == first && root == second) return new Result(root, true);

    Result left = firstCommonAncestorRec(root.left, first, second);
    if(left.isCommonAncestor) return left;

    Result right = firstCommonAncestorRec(root.right, first, second);
    if(right.isCommonAncestor) return right;

    if(left.node != null && right.node != null) {
      return new Result(root, true);
    } else if(root == first || root == second) {
      boolean isCommonAncestor = left.node != null || right.node != null;
      return new Result(root, isCommonAncestor);
    } else {
      return new Result(left.node != null ? left.node : right.node, false);
    }
  }

  private static class Result {
    private BinaryTree.Node node;
    private boolean isCommonAncestor;

    Result(BinaryTree.Node node, boolean isCommonAncestor) {
      this.node = node;
      this.isCommonAncestor = isCommonAncestor;
    }
  }
}
