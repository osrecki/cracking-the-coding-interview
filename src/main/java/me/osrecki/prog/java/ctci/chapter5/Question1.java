package me.osrecki.prog.java.ctci.chapter5;

/**
 * Question:  You are given two 32-bit numbers, N and M, and two bit positions,
 *            i and j. Write a method to insert M into N such that M starts at
 *            bit j and ends at bit i. You can assume that the bits j through i
 *            have enough space to fit all of M. That is, if M = 10011, you can
 *            assume that there are at least 5 bits between j and i. You would not,
 *            for example, have j = 3 and i = 2, because M could not fully fit
 *            between bit 3 and bit 2.
 * Author:    Dinko Osrecki
 * Date:      15/01/2017
 */
class Question1 {
  static int insert(int n, int m, int i, int j) {
    // Create (j - i + 1) 1s, e.g. 11111, for i = 2, j = 6
    int ones = (1 << (j - i + 1)) - 1;

    // Shift them i places left and invert to create a mask,
    // e.g. 1111100, and then 11111111111111111111111110000011
    int mask = ~(ones << i);

    // Clear bits from i to j
    n = n & mask;
    // Set bits from i to j in n to those from m
    n = n | (m << i);

    return n;
  }
}
