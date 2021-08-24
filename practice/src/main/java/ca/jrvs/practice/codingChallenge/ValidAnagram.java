package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;

/**
 * ticket: https://www.notion.so/jarvisdev/Valid-Anagram-f3cedb273df7496198c56bb2d194a4e5
 */
public class ValidAnagram {

  /**
   * Big-O: O(nlogn)
   * Justification: 2n to convert string to array. 2nlogn to sort arrays. n to check
   * if the arrays are equal O(2(n + nlogn + n)) => O(nlogn)
   */
  public boolean isAnagramSorted(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] sChar = s.toCharArray();
    char[] tChar = t.toCharArray();
    Arrays.sort(sChar);
    Arrays.sort(tChar);
    for (int i = 0; i < s.length(); i++) {
      if (sChar[i] != tChar[i]) {
        return false;
      }
    }
    return true;
  }

  /**
   * Big-O: O(n)
   * Justification: loop through s and t once each. O(n + m) -> O(n) if n is larger
   */
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] alphabet = new int[26];
    for (int i = 0; i < s.length(); i++) {
      alphabet[s.charAt(i) - 'a']++;
      alphabet[t.charAt(i) - 'a']--;
    }
    for (int i : alphabet) {
      if (i != 0) {
        return false;
      }
    }
    return true;
  }

}