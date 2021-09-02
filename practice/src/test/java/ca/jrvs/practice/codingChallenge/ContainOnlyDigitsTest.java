package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;

public class ContainOnlyDigitsTest extends TestCase {

  public void testContainOnlyDigitsASCII() {
    ContainOnlyDigits containOnlyDigits = new ContainOnlyDigits();
    assertTrue(containOnlyDigits.containOnlyDigitsASCII("1523348"));
    assertFalse(containOnlyDigits.containOnlyDigitsASCII("152a3348"));
  }

  public void testContainOnlyDigitsAPI() {
    ContainOnlyDigits containOnlyDigits = new ContainOnlyDigits();
    assertTrue(containOnlyDigits.containOnlyDigitsAPI("1523348"));
    assertFalse(containOnlyDigits.containOnlyDigitsAPI("152a3348"));
  }

  public void testContainOnlyDigitsRegex() {
    ContainOnlyDigits containOnlyDigits = new ContainOnlyDigits();
    assertTrue(containOnlyDigits.containOnlyDigitsRegex("1523348"));
    assertFalse(containOnlyDigits.containOnlyDigitsRegex("152a3348"));
  }
}