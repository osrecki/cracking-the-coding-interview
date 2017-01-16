package me.osrecki.prog.java.ctci.chapter8;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Question:  Write a method to return all subsets of a set.
 */
public class Question4Test {
  @Test
  public void shouldReturnSubsetsOfSet() {
    ArrayList<Integer> set = new ArrayList<>();
    Assert.assertEquals(1, evaluate(set).size());

    set.add(1);
    Assert.assertEquals(2, evaluate(set).size());

    set.add(2);
    Assert.assertEquals(4, evaluate(set).size());

    set.add(3);
    Assert.assertEquals(8, evaluate(set).size());
  }

  private ArrayList<ArrayList<Integer>> evaluate(ArrayList<Integer> set) {
    return Question4.subsets(set);
  }
}
