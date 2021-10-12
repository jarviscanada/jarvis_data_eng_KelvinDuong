package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;

public class RotateStringTest extends TestCase {

  public void testRotateString() {
    RotateString rotateString = new RotateString();
    assertTrue(rotateString.rotateString("abc","bca"));
    assertTrue(rotateString.rotateString("abcde","deabc"));
    assertFalse(rotateString.rotateString("acde","deabc"));
    assertFalse(rotateString.rotateString("bcade","deabc"));
  }
}