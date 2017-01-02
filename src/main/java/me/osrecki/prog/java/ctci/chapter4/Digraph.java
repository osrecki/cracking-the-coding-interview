package me.osrecki.prog.java.ctci.chapter4;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Author:  Dinko Osrecki
 * Date:    28/12/2016
 */
public class Digraph {
  private final int       vertexCount;
  private int             edgeCount;
  private List<Integer>[] adjacencyLists;
  private int[]           dependencies;

  public Digraph(int vertexCount) {
    this.vertexCount  = vertexCount;
    this.dependencies = new int[vertexCount];
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

  public Iterable<Integer> vertices() {
    return IntStream.range(0, vertexCount)::iterator;
  }

  public Iterable<Integer> neighbours(int v) {
    return adjacencyLists[v];
  }

  public void addEdge(int v, int w) {
    adjacencyLists[v].add(w);
    edgeCount++;
  }

  public int dependencies(int v) {
    return this.dependencies[v];
  }

  public void addDependency(int v) {
    dependencies[v]++;
  }

  public void removeDependency(int v) {
    dependencies[v]--;
  }

  public static Digraph createWithDependencies(int vertexCount, int[][] edges) {
    Digraph digraph = new Digraph(vertexCount);

    for(int[] edge : edges) {
      digraph.addEdge(edge[0], edge[1]);
      digraph.addDependency(edge[1]);
    }

    return digraph;
  }
}
