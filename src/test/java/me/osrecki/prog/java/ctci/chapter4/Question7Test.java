package me.osrecki.prog.java.ctci.chapter4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:  You are given a list of projects and a list of dependencies (which
 *            is a list of pairs of projects, where the second project is dependent
 *            on the first project). All of a project's dependencies must be built
 *            before the project is. Find a build order that will allow the projects
 *            to be built. If there is no valid build order, return an error.
 * Author:    Dinko Osrecki
 * Date:      02/01/2017
 */
public class Question7Test {
  @Test
  public void shouldCreateBuildOrder() {
    int projectsCount = 7;
    int[][] dependencies = new int[][]{
      {0, 4},
      {1, 0}, {1, 4},
      {2, 0},
      {3, 6},
      {5, 0}, {5, 1}, {5, 2}
    };
    Integer[] order = new Integer[]{3, 5, 6, 1, 2, 0, 4};

    Assert.assertArrayEquals(order, evaluate(projectsCount, dependencies));
  }

  private Integer[] evaluate(int projectsCount, int[][] dependencies) {
    return Question7.buildOrder(projectsCount, dependencies);
  }
}
