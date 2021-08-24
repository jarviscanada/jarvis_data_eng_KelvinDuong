package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;

public class ValidAnagramTest extends TestCase {

  public void testIsAnagramSorted() {
    ValidAnagram validAnagram = new ValidAnagram();
    assertTrue(validAnagram.isAnagramSorted("anagram", "nagaram"));
    assertFalse(validAnagram.isAnagramSorted("anagran", "nagaram"));
  }

  public void testIsAnagram() {
    ValidAnagram validAnagram = new ValidAnagram();
    assertTrue(validAnagram.isAnagram("anagram", "nagaram"));
    assertFalse(validAnagram.isAnagram("anagran", "nagaram"));
  }
}