package ca.jrvs.practice.codingChallenge;

import java.util.Locale;

/**
 * ticket: https://www.notion.so/jarvisdev/Valid-Palindrome-1798952f368a40df985b7625ac4cbfe1
 */
public class ValidPalindrome {

  /**
   * Big-O: O(n)
   * Justification: Loop through string once
   */
  public boolean isPalindromePointer(String s) {
    s.toLowerCase();
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        return false;
      }
    }
    return true;
  }

  /**
   * Big-O: O(n)
   * Justification: Calling the string with length - 2 each time
   */
  public boolean isPalindromeRecursion(String s) {
    if (s.length() == 1 || s.length() == 0) {
      return true;
    } else if (s.charAt(0) == s.charAt(s.length() - 1)) {
      return isPalindromeRecursion(s.substring(1, s.length() - 1));
    } else {
      return false;
    }
  }
}
