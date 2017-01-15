package me.osrecki.prog.java.ctci.chapter4;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import static org.hamcrest.Matchers.*;

/**
 * Question:  You are implementing a binary tree class from scratch which, in
 *            addition to insert, find, and delete, has a method getRandomNode()
 *            which returns a random node from the tree. All nodes should be equally
 *            likely to be chosen. Design and implement an algorithm for getRandomNode,
 *            and explain how you would implement the rest of the methods.
 * Author:    Dinko Osrecki
 * Date:      15/01/2017
 */
public class Question11Test {
  @Test
  public void shouldReturnRandomNode() {
    BST tree = new BST();
    tree.insert(10);
    tree.insert(-3);
    tree.insert(6);
    tree.insert(2);
    tree.insert(-10);
    tree.insert(24);

    int trials = 100000;
    int nodes = 6;

    HashMap<Integer, Integer> occurrences = new HashMap<>();
    for(int i = 0; i < trials; i++) {
      int rand = tree.random().value;

      int count = occurrences.getOrDefault(rand, 0);
      occurrences.put(rand, count + 1);
    }

    int avgCount = trials / nodes;
    int margin = (int) (avgCount * 0.05);
    int threshold = avgCount - margin;

    Assert.assertThat(occurrences.values(), everyItem(greaterThan(threshold)));
  }
}
