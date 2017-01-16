package me.osrecki.prog.java.ctci.chapter8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Question:  Write a method to return all subsets of a set.
 */
class Question4 {
  static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set) {
    return subsets(set, 0);
  }

  private static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set, int index) {
    ArrayList<ArrayList<Integer>> allSubsets;

    if (set.size() == index) {
      allSubsets = new ArrayList<>();
      allSubsets.add(new ArrayList<>());
    } else {
      int element = set.get(index);
      allSubsets = subsets(set, index + 1);

      ArrayList<ArrayList<Integer>> newSubsets = allSubsets.stream().map(subset -> {
        ArrayList<Integer> newSubset = new ArrayList<>();
        newSubset.addAll(subset);
        newSubset.add(element);

        return newSubset;
      }).collect(Collectors.toCollection(ArrayList::new));

      allSubsets.addAll(newSubsets);
    }

    return allSubsets;
  }
}
