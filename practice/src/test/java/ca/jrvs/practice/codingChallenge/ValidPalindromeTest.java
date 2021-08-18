package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidPalindromeTest {

  @Test
  public void isPalindromePointer() {
    ValidPalindrome validPalindrome = new ValidPalindrome();
    assertTrue(validPalindrome.isPalindromePointer("racecar"));
    assertTrue(validPalindrome.isPalindromePointer("rabckkcbar"));
    assertTrue(validPalindrome.isPalindromePointer("a"));
    assertTrue(validPalindrome.isPalindromePointer(""));
    assertTrue(validPalindrome.isPalindromeRecursion("aba"));
    assertFalse(validPalindrome.isPalindromePointer("abcabc"));
  }

  @Test
  public void isPalindromeRecursion() {
    ValidPalindrome validPalindrome = new ValidPalindrome();
    assertTrue(validPalindrome.isPalindromeRecursion("racecar"));
    assertTrue(validPalindrome.isPalindromeRecursion("rabckkcbar"));
    assertTrue(validPalindrome.isPalindromeRecursion("a"));
    assertTrue(validPalindrome.isPalindromeRecursion(""));
    assertTrue(validPalindrome.isPalindromeRecursion("aba"));
    assertFalse(validPalindrome.isPalindromeRecursion("abcabc"));
  }
}