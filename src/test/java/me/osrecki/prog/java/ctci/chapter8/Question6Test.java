package me.osrecki.prog.java.ctci.chapter8;

import org.junit.Assert;
import org.junit.Test;

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
public class Question6Test {
  @Test
  public void shouldSolveTowersOfHanoi() {
    Question6.Tower[] towers = new Question6.Tower[3];
    for(int i = 0; i < 3; i++)
      towers[i] = new Question6.Tower();

    int n = 10;
    for(int disk = n; disk > 0; disk --)
      towers[0].add(disk);

    boolean result = towers[0].moveDisks(n, towers[2], towers[1]);

    Assert.assertTrue(result);
    Assert.assertEquals(0, towers[0].size());
    Assert.assertEquals(0, towers[1].size());
    Assert.assertEquals(n, towers[2].size());

    result = towers[0].moveDisks(n, towers[2], towers[1]);
    Assert.assertFalse(result);
  }
}
