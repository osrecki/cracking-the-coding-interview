package me.osrecki.prog.java.ctci.chapter1;

import java.util.HashSet;

/**
 * Question:  Write an algorithm such that if an element in an MxN matrix is 0,
 *            its entire row and column are set to 0.
 * Author:    Dinko Osrecki
 * Date:      22/12/2016
 */
public class Question8 {
  /**
   * Idea:  Find the elements that are equal to zero and remember their row and
   *        column in the hash set. Then set all elements in those rows or columns
   *        to zero.
   * Time:  O(M * N)
   * Space: O(M + N)
   */
  public static int[][] zeroMatrix1(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0)
      throw new IllegalArgumentException("Invalid matrix dimensions.");

    int m = matrix.length;
    int n = matrix[0].length;

    HashSet<Integer> rows = new HashSet<>();
    HashSet<Integer> cols = new HashSet<>();

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    for(int i = 0; i < m; i++)
      if(rows.contains(i)) nullifyRow(matrix, i);

    for(int j = 0; j < n; j++)
      if(cols.contains(j)) nullifyColumn(matrix, j);

    return matrix;
  }

  /**
   * Idea:  Instead of a HashSet use a simple fixed-size boolean array.
   * Time:  O(M * N)
   * Space: O(M + N)
   * @see   #zeroMatrix1(int[][])
   */
  public static int[][] zeroMatrix2(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0)
      throw new IllegalArgumentException("Invalid matrix dimensions.");

    int m = matrix.length;
    int n = matrix[0].length;

    boolean[] rows = new boolean[m];
    boolean[] cols = new boolean[n];

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(matrix[i][j] == 0) {
          rows[i] = true;
          cols[j] = true;
        }
      }
    }

    for(int i = 0; i < m; i++)
      if(rows[i]) nullifyRow(matrix, i);

    for(int j = 0; j < n; j++)
      if(cols[j]) nullifyColumn(matrix, j);

    return matrix;
  }

  /**
   * Idea:  Reduce space consumption to O(1) by using the matrix to store data
   *        about rows and columns that should be set to zero.
   * Time:  O(M * N)
   * Space: O(1)
   * @see   #zeroMatrix1(int[][])
   * @see   #zeroMatrix2(int[][])
   */
  public static int[][] zeroMatrix3(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0)
      throw new IllegalArgumentException("Invalid matrix dimensions.");

    int m = matrix.length;
    int n = matrix[0].length;

    boolean rowHasZero = false;
    for(int j = 0; j < n; j++) {
      if(matrix[0][j] == 0) {
        rowHasZero = true;
        break;
      }
    }

    boolean colHasZero = false;
    for(int i = 0; i < m; i++) {
      if(matrix[i][0] == 0) {
        colHasZero = true;
        break;
      }
    }

    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        if(matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    // Set rows and columns to zero
    for(int i = 1; i < m; i++) {
      if(matrix[i][0] == 0) nullifyRow(matrix, i);
    }

    for(int j = 1; j < n; j++) {
      if(matrix[0][j] == 0) nullifyColumn(matrix, j);
    }

    if(rowHasZero) nullifyRow(matrix, 0);
    if(colHasZero) nullifyColumn(matrix, 0);

    return matrix;
  }

  private static void nullifyRow(int[][] matrix, int row) {
    for(int j = 0; j < matrix[row].length; j++) {
      matrix[row][j] = 0;
    }
  }

  private static void nullifyColumn(int[][] matrix, int col) {
    for(int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
  }
}
