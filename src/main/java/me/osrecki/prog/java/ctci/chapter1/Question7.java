package me.osrecki.prog.java.ctci.chapter1;

/**
 * Question:  Given an image represented by an NxN matrix, where each pixel in
 *            the image is 4 bytes, write a method to rotate the image by 90
 *            degrees. Can you do this in place?
 * Author:    Dinko Osrecki
 * Date:      22/12/2016
 */
public class Question7 {
  /**
   * Idea:  Create a new array of the same size and copy the elements to the
   *        corresponding places.
   * Time:  O(N^2)
   * Space: O(N^2)
   */
  public static int[][] rotateMatrix1(int[][] matrix) {
    if(matrix.length == 0 || matrix.length != matrix[0].length)
      throw new IllegalArgumentException("Matrix has to be of NxN dimensions.");

    int n = matrix.length;
    int[][] rotated = new int[n][n];

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        rotated[i][j] = matrix[n - 1 - j][i];
      }
    }

    return rotated;
  }

  /**
   * Idea:  Perform rotation in-place by swapping elements layer by layer (from
   *        the outermost layer inwards).
   * Time:  O(N^2)
   * Space: O(1)
   */
  public static int[][] rotateMatrix2(int[][] matrix) {
    if(matrix.length == 0 || matrix.length != matrix[0].length)
      throw new IllegalArgumentException("Matrix has to be of NxN dimensions.");

    int n = matrix.length;

    for(int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - 1 - layer;

      for(int i = first; i < last; i++) {
        int offset = i - first;

        int top = matrix[first][i];

        // Left -> Top
        matrix[first][i] = matrix[last - offset][first];
        // Bottom -> Left
        matrix[last - offset][first] = matrix[last][last - offset];
        // Right -> Bottom
        matrix[last][last - offset] = matrix[i][last];
        // Top -> Right
        matrix[i][last] = top;
      }
    }

    return matrix;
  }
}
