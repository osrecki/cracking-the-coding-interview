package me.osrecki.prog.java.ctci.chapter8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Question:  Write a method to compute all permutations of a string whose
 *            characters are not necessarily unique. The list of permutations
 *            should not have duplicates.
 */
class Question8 {
  static List<String> permutations(String string) {
    Map<Character, Integer> map = stringToMap(string);

    List<String> perms = new ArrayList<>();
    permutations(map, "", string.length(), perms);
    return perms;
  }

  private static void permutations(Map<Character, Integer> map, String prefix, int remaining, List<String> perms) {
    if(remaining == 0) {
      perms.add(prefix);
      return;
    }

    for (Character character : map.keySet()) {
      int count = map.get(character);

      if (count > 0) {
        map.put(character, count - 1);
        permutations(map, prefix + character, remaining - 1, perms);
        map.put(character, count);
      }
    }
  }

  private static Map<Character, Integer> stringToMap(String string) {
    Map<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < string.length(); i++) {
      char character = string.charAt(i);

      int count = map.getOrDefault(character, 0);
      map.put(character, count + 1);
    }

    return map;
  }
}
