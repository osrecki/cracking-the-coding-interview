package me.osrecki.prog.java.ctci.chapter8;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Question:  Imagine a robot sitting on the upper left corner of grid with r
 *            rows and c columns. The robot can only move in two directions,
 *            right and down, but certain cells are "off limits" such that the
 *            robot cannot step on them. Design an algorithm to find a path for
 *            the robot from the top left to the bottom right.
 */
public class Question2Test {
  @Test
  public void shouldGetPath() {
    // . X . .
    // . . . X
    // X . . .
    // X . . .
    // . . X .
    boolean[][] maze = new boolean[][] {
      {true, false, true, true},
      {true, true, true, false},
      {false, true, true, true},
      {false, true, true, true},
      {true, true, false, true}
    };

    int[][] coordinates = {
      {0, 0}, {1, 0}, {1, 1}, {2, 1}, {3, 1}, {3, 2}, {3, 3}, {4, 3}
    };

    Question2.Point[] path = Stream.of(coordinates).map(arr -> new Question2.Point(arr[0], arr[1])).toArray(Question2.Point[]::new);
    Assert.assertThat(evaluate(maze), contains(path));
  }

  private List<Question2.Point> evaluate(boolean[][] maze) {
    return Question2.getPath(maze);
  }
}
