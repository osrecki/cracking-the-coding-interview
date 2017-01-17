package me.osrecki.prog.java.ctci.chapter10;

/**
 * Question:  You are given two sorted arrays, A and B, where A has a large
 *            enough buffer at the end to hold B. Write a method to merge B
 *            into A in sorted order.
 */
class Question1 {
  static void sortedMerge(int[] a, int[] b) {
    int index = a.length - 1;

    int bIndex = b.length - 1;
    int aIndex = a.length - b.length - 1;

    while(bIndex >= 0) {
      if(aIndex >= 0 && a[aIndex] > b[bIndex]) {
        a[index] = a[aIndex];
        aIndex--;
      } else {
        a[index] = b[bIndex];
        bIndex--;
      }

      index--;
    }
  }
}
