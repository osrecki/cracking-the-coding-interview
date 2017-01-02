package me.osrecki.prog.java.ctci.chapter4;

import java.util.ArrayList;

/**
 * Question:  You are given a list of projects and a list of dependencies (which
 *            is a list of pairs of projects, where the second project is dependent
 *            on the first project). All of a project's dependencies must be built
 *            before the project is. Find a build order that will allow the projects
 *            to be built. If there is no valid build order, return an error.
 * Author:    Dinko Osrecki
 * Date:      02/01/2017
 */
class Question7 {
  /**
   * Idea:  Create a directed graph which represents dependencies between
   *        projects. For each node in a graph track the number of predecessors
   *        (dependencies). Add to build order those nodes (projects) that have
   *        no dependencies. Decrease the number of dependencies from their
   *        successors and repeat the process. If build order is not complete
   *        and there is no "independent" node, we have detected a cycle, which
   *        means there is no solution.
   * Time:  O(V + E), |V| is a number of vertices (projects) and |E| is a number
   *                  of edges (dependencies)
   */
  static Integer[] buildOrder(int projectsCount, int[][] dependencies) {
    Digraph graph = Digraph.createWithDependencies(projectsCount, dependencies);

    ArrayList<Integer> order = new ArrayList<>(graph.V());
    addIndependentProjects(graph, graph.vertices(), order);

    for(int current = 0; current < graph.V(); current++) {
      // Dependency cycle detected
      if(current >= order.size()) return null;

      int v = order.get(current);
      for(int w : graph.neighbours(v))
        graph.removeDependency(w);

      addIndependentProjects(graph, graph.neighbours(v), order);
    }

    return order.stream().toArray(Integer[]::new);
  }

  private static void addIndependentProjects(Digraph graph, Iterable<Integer> vertices, ArrayList<Integer> order) {
    for(int v : vertices) {
      if(graph.dependencies(v) == 0) {
        order.add(v);
      }
    }
  }
}
