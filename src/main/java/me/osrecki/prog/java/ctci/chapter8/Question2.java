package me.osrecki.prog.java.ctci.chapter8;

import java.util.ArrayList;

/**
 * Question:  Imagine a robot sitting on the upper left corner of grid with r
 *            rows and c columns. The robot can only move in two directions,
 *            right and down, but certain cells are "off limits" such that the
 *            robot cannot step on them. Design an algorithm to find a path for
 *            the robot from the top left to the bottom right.
 */
public class Question2 {
  /**
   * Time: O(2^(r+c))
   */
  static ArrayList<Point> getPath(boolean[][] maze) {
    if (maze == null || maze.length == 0) return null;

    ArrayList<Point> path = new ArrayList<>();
    if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
      return path;
    }

    return null;
  }

  private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
    if(row < 0 || col < 0 || !maze[row][col]) {
      return false;
    }

    boolean isOrigin = row == 0 && col == 0;
    if(isOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
      path.add(new Point(row, col));
      return  true;
    }

    return false;
  }

  static class Point {
    int row;
    int col;

    Point(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Point point = (Point) o;
      return row == point.row && col == point.col;
    }

    @Override
    public int hashCode() {
      int result = row;
      result = 31 * result + col;
      return result;
    }
  }
}
