package me.osrecki.prog.java.ctci.chapter4;

/**
 * Question:  Given a sorted (increasing order) array with unique integer elements,
 *            write an algorithm to create a binary search tree with minimal height.
 * Author:    Dinko Osrecki
 * Date:      28/12/2016
 */
class Question2 {
  static BinaryTree.Node minimalTree(int[] values) {
    if(values == null || values.length == 0) return null;

    return minimalTreeRec(values, 0, values.length - 1);
  }

  private static BinaryTree.Node minimalTreeRec(int[] values, int leftIndex, int rightIndex) {
    if(leftIndex > rightIndex) return null;

    int middleIndex = (rightIndex + leftIndex) / 2;

    BinaryTree.Node left = minimalTreeRec(values, leftIndex, middleIndex - 1);
    BinaryTree.Node right = minimalTreeRec(values, middleIndex + 1, rightIndex);

    return new BinaryTree.Node(values[middleIndex], left, right);
  }
}
