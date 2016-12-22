package me.osrecki.prog.java.ctci.chapter1;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import static me.osrecki.prog.java.ctci.TestHelper.testMethodsResults;

/**
 * Question:  Given a string, write a function to check if it is a permutation
 *            of a palindrome. A palindrome is a word or phrase that is the same
 *            forwards and backwards. A permutation is a rearrangement of letters.
 *            The palindrome does not need to be limited to just dictionary words.
 * Author:    Dinko Osrecki
 * Date:      21/12/2016
 */
public class Question4Test {
  @Test
  public void shouldBeAPalindromePermutation() {
    String string     = "A dog, a plan, a canal: pagoda.";
    String palindrome = "A dog, a plan, a canal: pagoda.";

    assertThat("'"+ string +"' is a permutation of palindrome '"+ palindrome +"'.", evaluate(string), everyItem(is(true)));

    string      = "Nasta Santa A-A!";
    palindrome  = "A Santa at Nasa.";

    assertThat("'"+ string +"' is a permutation of palindrome '"+ palindrome +"'.", evaluate(string), everyItem(is(true)));
  }

  @Test
  public void shouldNotBeAPalindromePermutation() {
    String string = "This is not a palindrome permutation.";

    assertThat("'"+ string +"' is not a palindrome permutation.", evaluate(string), everyItem(is(false)));

    string = "abrakadabra";
    assertThat("'"+ string +"' is not a palindrome permutation.", evaluate(string), everyItem(is(false)));
  }

  private List<Boolean> evaluate(String string) {
    return testMethodsResults(Question4.class, "isPalindromePermutation", string);
  }
}
