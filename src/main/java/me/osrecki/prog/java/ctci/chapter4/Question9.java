package me.osrecki.prog.java.ctci.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Question:  A binary search tree was created by traversing through an array
 *            from left to right and inserting each element. Given a binary
 *            search tree with distinct elements, print all possible arrays
 *            that could have led to this tree.
 * Author:    Dinko Osrecki
 * Date:      03/01/2017
 */
class Question9 {
  /**
   * Idea:  Root element of the subtree has to appear in front of all of the elements
   *        from the left and right subtrees. Elements from the left and right subtrees
   *        can be intertwined in all possible ways, but they have to keep order from
   *        their respective (left or right) subtree (think fingers from left and right
   *        hand).
   */
  static ArrayList<LinkedList<Integer>> bstSequences(BinaryTree.Node root) {
    ArrayList<LinkedList<Integer>> sequences = new ArrayList<>();

    if(root == null) {
      sequences.add(new LinkedList<>());
      return sequences;
    }

    LinkedList<Integer> prefix = new LinkedList<>();
    prefix.add(root.value);

    ArrayList<LinkedList<Integer>> leftSequences = bstSequences(root.left);
    ArrayList<LinkedList<Integer>> rightSequences = bstSequences(root.right);

    for(LinkedList<Integer> leftSequence : leftSequences) {
      for(LinkedList<Integer> rightSequence : rightSequences) {
        sequences.addAll(twineLists(leftSequence, rightSequence, prefix));
      }
    }

    return sequences;
  }

  private static ArrayList<LinkedList<Integer>> twineLists(LinkedList<Integer> first, LinkedList<Integer> second,
                                                           LinkedList<Integer> prefix) {
    ArrayList<LinkedList<Integer>> twined = new ArrayList<>();
    twineListsRec(first, second, prefix, twined);
    return twined;
  }

  @SuppressWarnings("unchecked")
  private static void twineListsRec(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix,
                                                   ArrayList<LinkedList<Integer>> twined) {
    if(first.isEmpty() || second.isEmpty()) {
      LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
      result.addAll(first);
      result.addAll(second);

      twined.add(result);
      return;
    }

    for(LinkedList<Integer> list : new LinkedList[]{first, second}) {
      int head = list.removeFirst();
      prefix.addLast(head);
      twineListsRec(first, second, prefix, twined);
      prefix.removeLast();
      list.addFirst(head);
    }
  }
}
