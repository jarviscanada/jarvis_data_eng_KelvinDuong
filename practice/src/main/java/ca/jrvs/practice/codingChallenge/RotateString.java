package ca.jrvs.practice.codingChallenge;

/**
 * ticket: https://www.notion.so/jarvisdev/Rotate-String-4caa2981fc3b4baa80116c99d3b0786f
 */
public class RotateString {

  /**
   * Big-O: O(n)
   * Justification: adding s together takes O(n+n) = O(n) cause it has to create a new string of
   * size 2n.
   */
  public boolean rotateString(String s, String goal) {
    return (s + s).contains(goal) && s.length() == goal.length();
  }

}