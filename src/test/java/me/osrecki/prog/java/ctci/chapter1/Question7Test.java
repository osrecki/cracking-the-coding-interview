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
 * Question:  Given an image represented by an NxN matrix, where each pixel in
 *            the image is 4 bytes, write a method to rotate the image by 90
 *            degrees. Can you do this in place?
 * Author:    Dinko Osrecki
 * Date:      22/12/2016
 */
public class Question7Test {

  @Test
  public void shouldRotateMatrix() {
    int[][] matrix = {
      {1, 2},
      {3, 4}
    };

    int[][] rotated = {
      {3, 1},
      {4, 2}
    };

    assertThat("Matrix '"+ printMatrix(matrix) +"' should be rotated to '"+ printMatrix(rotated) +"'.",
      evaluate(matrix), everyItem(is(rotated))
    );

    matrix = new int[][]{
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };

    rotated = new int[][]{
      {7, 4, 1},
      {8, 5, 2},
      {9, 6, 3}
    };

    assertThat("Matrix '"+ printMatrix(matrix) +"' should be rotated to '"+ printMatrix(rotated) +"'.",
        evaluate(matrix), everyItem(is(rotated))
    );

    matrix = new int[][]{
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    rotated = new int[][]{
      {13, 9, 5, 1},
      {14, 10, 6, 2},
      {15, 11, 7, 3},
      {16, 12, 8, 4}
    };

    assertThat("Matrix '"+ printMatrix(matrix) +"' should be rotated to '"+ printMatrix(rotated) +"'.",
        evaluate(matrix), everyItem(is(rotated))
    );
  }

  private List<int[][]> evaluate(int[][] matrix) {
    List<int[][]> results = new ArrayList<>();
    results.add(Question7.rotateMatrix1(duplicateMatrix(matrix)));
    results.add(Question7.rotateMatrix2(duplicateMatrix(matrix)));

    return results;
  }
}
