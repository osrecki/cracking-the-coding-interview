package me.osrecki.prog.java.ctci.chapter4;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:  Dinko Osrecki
 * Date:    28/12/2016
 */
public class Digraph {
  private final int       vertexCount;
  private int             edgeCount;
  private List<Integer>[] adjacencyLists;

  public Digraph(int vertexCount) {
    this.vertexCount  = vertexCount;
    this.edgeCount    = 0;

    adjacencyLists = (List<Integer>[]) new List[vertexCount];
    for(int i = 0; i < vertexCount; i++)
      adjacencyLists[i] = new LinkedList<>();
  }

  public int V() {
    return vertexCount;
  }

  public int E() {
    return edgeCount;
  }

  public Iterable<Integer> neighbours(int v) {
    return adjacencyLists[v];
  }

  public void addEdge(int v, int w) {
    adjacencyLists[v].add(w);
    edgeCount++;
  }
}
