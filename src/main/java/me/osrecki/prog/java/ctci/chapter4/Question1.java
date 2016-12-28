package me.osrecki.prog.java.ctci.chapter4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Question:  Given a directed graph, design an algorithm to find out whether
 *            there is a route between two nodes.
 * Author:    Dinko Osrecki
 * Date:      28/12/2016
 */
class Question1 {
  /**
   * Idea:  Use breadth first search to find out if there is a path between
   *        two vertices in a directed graph.
   */
  static boolean hasRouteBetweenNodes(Digraph digraph, int v, int w) {
    BreadthFirstSearch bfs = new BreadthFirstSearch(digraph, v);
    return bfs.hasPathTo(w);
  }

  static class BreadthFirstSearch {
    private boolean[] marked;

    BreadthFirstSearch(Digraph digraph, int source) {
      this.marked = new boolean[digraph.V()];

      bfs(digraph, source);
    }

    private void bfs(Digraph digraph, int source) {
      Queue<Integer> queue = new LinkedList<>();
      queue.add(source);
      marked[source] = true;

      while(!queue.isEmpty()) {
        int v = queue.poll();

        for(int w : digraph.neighbours(v)) {
          if(!marked[w]) {
            marked[w] = true;
            queue.add(w);
          }
        }
      }
    }

    boolean hasPathTo(int v) {
      return marked[v];
    }
  }
}
