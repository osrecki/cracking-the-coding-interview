package me.osrecki.prog.java.ctci.chapter4;

import java.util.LinkedList;
import java.util.List;

/**
 * Question:  Given a binary tree, design an algorithm which creates a linked
 *            list of all the nodes at each depth (e.g., if you have a tree
 *            with depth D, you'll have D linked lists).
 * Author:    Dinko Osrecki
 * Date:      28/12/2016
 */
class Question3 {
  static List<List<BinaryTree.Node>> listOfDepths(BinaryTree.Node root) {
    List<List<BinaryTree.Node>> lists = new LinkedList<>();

    List<BinaryTree.Node> current = new LinkedList<>();
    current.add(root);

    while(current.size() != 0) {
      lists.add(current);

      LinkedList<BinaryTree.Node> newCurrent = new LinkedList<>();
      for(BinaryTree.Node node : current) {
        if(node.left != null)   newCurrent.add(node.left);
        if(node.right != null)  newCurrent.add(node.right);
      }

      current = newCurrent;
    }

    return lists;
  }
}
