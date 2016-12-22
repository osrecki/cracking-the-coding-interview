package me.osrecki.prog.java.ctci.chapter1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static me.osrecki.prog.java.ctci.TestHelper.duplicateMatrix;
import static me.osrecki.prog.java.ctci.TestHelper.printMatrix;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Question:  Write an algorithm such that if an element in an MxN matrix is 0,
 *            its entire row and column are set to 0.
 * Author:    Dinko Osrecki
 * Date:      22/12/2016
 */
public class Question8Test {
  @Test
  public void shouldSetRowAndColumnToZero() {
    int[][] matrix = {
      {1, 2, 3, 4},
      {5, 0, 7, 8},
      {9, 10, 11, 12}
    };

    int[][] zeroMatrix = {
      {1, 0, 3, 4},
      {0, 0, 0, 0},
      {9, 0, 11, 12}
    };

    assertThat("Matrix '"+ printMatrix(matrix) +"' should be transformed to '"+ printMatrix(zeroMatrix) +"'.",
        evaluate(matrix), everyItem(is(zeroMatrix))
    );

    matrix = new int[][]{
      {1, 2, 3},
      {4, 5, 6},
      {0, 8, 9}
    };

    zeroMatrix = new int[][]{
      {0, 2, 3},
      {0, 5, 6},
      {0, 0, 0}
    };

    assertThat("Matrix '"+ printMatrix(matrix) +"' should be transformed to '"+ printMatrix(zeroMatrix) +"'.",
        evaluate(matrix), everyItem(is(zeroMatrix))
    );
  }

  @Test
  public void shouldSetRowsAndColumnsToZero() {
    int[][] matrix = {
      {0, 2, 3, 4},
      {5, 0, 7, 8},
      {9, 10, 11, 12}
    };

    int[][] zeroMatrix = {
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 11, 12}
    };

    assertThat("Matrix '"+ printMatrix(matrix) +"' should be transformed to '"+ printMatrix(zeroMatrix) +"'.",
        evaluate(matrix), everyItem(is(zeroMatrix))
    );
  }

  @Test
  public void shouldNotSetRowsAndColumnsToZero() {
    int[][] matrix = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12}
    };

    assertThat("Matrix '"+ printMatrix(matrix) +"' should remain the same.", evaluate(matrix), everyItem(is(matrix)));
  }

  private List<int[][]> evaluate(int[][] matrix) {
    List<int[][]> results = new ArrayList<>();
    results.add(Question8.zeroMatrix1(duplicateMatrix(matrix)));
    results.add(Question8.zeroMatrix2(duplicateMatrix(matrix)));
    results.add(Question8.zeroMatrix3(duplicateMatrix(matrix)));

    return results;
  }
}
