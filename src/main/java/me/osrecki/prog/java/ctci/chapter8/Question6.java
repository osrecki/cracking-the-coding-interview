package me.osrecki.prog.java.ctci.chapter8;

import java.util.Stack;

/**
 * Question:  In the classic problem of the Towers of Hanoi, you have 3 towers
 *            and N disks of different sizes which can slide onto any tower.
 *            The puzzle starts with disks sorted in ascending order of size
 *            from top to bottom (i.e., each disk sits on top of an even larger
 *            one). You have the following constraints:
 *            (1) Only one disk can be moved at a time.
 *            (2) A disk is slid off the top of one tower onto another tower.
 *            (3) A disk cannot be placed on top of a smaller disk.
 *            Write a program to move the disks from the first tower to the
 *            last using stacks.
 */
public class Question6 {
  static class Tower {
    Stack<Integer> disks = new Stack<>();

    boolean add(int disk) {
      if (!disks.isEmpty() && disks.peek() <= disk) {
        return false;
      }

      disks.add(disk);
      return true;
    }

    boolean moveTop(Tower tower) {
      if(disks.isEmpty()) {
        return false;
      }

      int top = disks.peek();
      if(tower.add(top)) {
        disks.pop();
        return true;
      }

      return false;
    }

    boolean moveDisks(int n, Tower target, Tower helper) {
      boolean result = true;

      if (n > 0) {
        result = moveDisks(n - 1, helper, target);
        result &= moveTop(target);
        result &= helper.moveDisks(n - 1, target, this);
      }

      return result;
    }

    int size() {
      return disks.size();
    }
  }
}
