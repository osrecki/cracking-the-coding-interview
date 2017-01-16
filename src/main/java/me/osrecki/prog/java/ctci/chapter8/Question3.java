package me.osrecki.prog.java.ctci.chapter8;

/**
 * Question:  A magic index in an array A [0...n -1] is defined to be an index
 *            such that A[ i] = i. Given a sorted array of distinct integers,
 *            write a method to find a magic index, if one exists, in array A.
 *            What if the values are not distinct?
 */
public class Question3 {
  static int magicIndex(int[] array) {
    return magicIndex(array, 0, array.length - 1);
  }

  private static int magicIndex(int[] array, int left, int right) {
    if (left > right) return -1;

    int middle = (left + right) / 2;

    if (array[middle] == middle) return middle;
    else if (array[middle] > middle) return magicIndex(array, left, middle - 1);
    else return magicIndex(array, middle + 1, right);
  }

  static int magicIndexDuplicates(int[] array) {
    return magicIndexDuplicates(array, 0, array.length - 1);
  }

  private static int magicIndexDuplicates(int[] array, int left, int right) {
    if (left > right) return - 1;

    int middleIndex = (left + right) / 2;
    int middleValue = array[middleIndex];

    if (middleIndex == middleValue) return middleIndex;

    int leftMagicIndex = magicIndexDuplicates(array, left, Math.min(middleIndex - 1, middleValue));
    if (leftMagicIndex > -1) return leftMagicIndex;

    int rightMagicIndex = magicIndexDuplicates(array, Math.max(middleIndex + 1, middleValue), right);
    return rightMagicIndex;
  }
}
