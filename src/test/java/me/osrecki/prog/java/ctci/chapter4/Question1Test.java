package me.osrecki.prog.java.ctci.chapter4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Question:  Given a directed graph, design an algorithm to find out whether
 *            there is a route between two nodes.
 * Author:    Dinko Osrecki
 * Date:      28/12/2016
 */
public class Question1Test {
  private Digraph digraph;

  @Before
  public void initializeTest() {
    digraph = new Digraph(13);

    int[][] edges = new int[][]{
      {4, 2}, {2, 3}, {3, 2}, {6, 0}, {0, 1}, {2, 0}, {11, 12}, {12, 9},
      {9, 10}, {9, 11}, {8, 9}, {10, 12}, {11, 4}, {4, 3}, {3, 5}, {7, 8},
      {8, 7}, {5, 4}, {0, 5}, {6, 4}, {6, 9}, {7, 6}
    };

    Arrays.stream(edges).forEach(edge -> digraph.addEdge(edge[0], edge[1]));
  }

  @Test
  public void shouldHaveARouteBetweenTwoNodes() {
    Assert.assertTrue("Graph should have a route between vertices 0 and 3.",
      Question1.hasRouteBetweenNodes(digraph, 0, 3)
    );

    Assert.assertTrue("Graph should have a route between vertices 8 and 4.",
      Question1.hasRouteBetweenNodes(digraph, 8, 4)
    );

    Assert.assertTrue("Graph should have a route between vertices 12 and 0.",
      Question1.hasRouteBetweenNodes(digraph, 12, 0)
    );
  }

  @Test
  public void shouldNotHaveARouteBetweenTwoNodes() {
    Assert.assertFalse("Graph should not have a route between vertices 1 and 3.",
      Question1.hasRouteBetweenNodes(digraph, 1, 3)
    );

    Assert.assertFalse("Graph should not have a route between vertices 2 and 6.",
      Question1.hasRouteBetweenNodes(digraph, 2, 6)
    );

    Assert.assertFalse("Graph should not have a route between vertices 9 and 6.",
      Question1.hasRouteBetweenNodes(digraph, 9, 6)
    );
  }
}
