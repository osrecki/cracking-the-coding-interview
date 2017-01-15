package me.osrecki.prog.java.ctci.chapter5;

/**
 * Question:  Write a program to swap odd and even bits in an integer with as
 *            few instructions as possible (e.g., bit 0 and bit 1 are swapped,
 *            bit 2 and bit 3 are swapped, and so on).
 * Author:    Dinko Osrecki
 * Date:      15/01/2017
 */
class Question7 {
  private static final int EVEN_BITS_MASK = 0x55555555;  // ...0101
  private static final int ODD_BITS_MASK = 0xAAAAAAAA;   // ...1010

  static int swapBits(int number) {
    int oddBits = number & ODD_BITS_MASK;
    int evenBits = number & EVEN_BITS_MASK;

    return (oddBits >>> 1) | (evenBits << 1);
  }
}
