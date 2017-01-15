package me.osrecki.prog.java.ctci.chapter4;

import java.util.HashMap;

/**
 * Author:  Dinko Osrecki
 * Date:    28/12/2016
 */
class BinaryTree {
  private Node root;

  BinaryTree(Node root) {
    this.root = root;
  }

  int countPathsWithSum(int targetSum) {
    return countPathsWithSum(root, targetSum, 0, new HashMap<>());
  }

  private static int countPathsWithSum(Node node, int targetSum, int currentSum, HashMap<Integer, Integer> pathCount) {
    if (node == null) return 0;

    currentSum += node.value;

    int paths = pathCount.getOrDefault(currentSum - targetSum, 0);
    if (currentSum == targetSum) paths++;

    updatePathCount(pathCount, currentSum, 1);
    paths += countPathsWithSum(node.left, targetSum, currentSum, pathCount);
    paths += countPathsWithSum(node.right, targetSum, currentSum, pathCount);
    updatePathCount(pathCount, currentSum, -1);

    return paths;
  }

  private static void updatePathCount(HashMap<Integer, Integer> pathCount, int key, int delta) {
    int count = pathCount.getOrDefault(key, 0) + delta;
    if (count == 0) {
      pathCount.remove(key);
    } else {
      pathCount.put(key, count);
    }
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
