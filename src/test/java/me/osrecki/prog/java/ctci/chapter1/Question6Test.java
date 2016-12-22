package me.osrecki.prog.java.ctci.chapter1;

import org.junit.Test;

import java.util.List;

import static me.osrecki.prog.java.ctci.TestHelper.testMethodsResults;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Question:  Implement a method to perform basic string compression using the
 *            counts of repeated characters. For example, the string aabcccccaaa
 *            would become a2blc5a3. If the "compressed" string would not become
 *            smaller than the original string, your method should return the
 *            original string. You can assume the string has only uppercase and
 *            lowercase letters (a - z).
 * Author:    Dinko Osrecki
 * Date:      22/12/2016
 */
public class Question6Test {
  @Test
  public void shouldCompressString() {
    String string     = "aabcccccaaa";
    String compressed = "a2b1c5a3";

    assertThat("String '"+ string +"' should be compressed to '"+ compressed +"'.", evaluate(string), everyItem(is(compressed)));
  }

  @Test
  public void shouldNotCompressString() {
    String string = "aa";

    assertThat("String '"+ string +"' should not be compressed.", evaluate(string), everyItem(is(string)));

    string = "ab";

    assertThat("String '"+ string +"' should not be compressed.", evaluate(string), everyItem(is(string)));
  }

  private List<String> evaluate(String string) {
    return testMethodsResults(Question6.class, "compress", string);
  }
}
