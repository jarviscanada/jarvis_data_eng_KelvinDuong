package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidParenthesesTest {

  @Test
  public void isValid() {
    ValidParentheses validParentheses = new ValidParentheses();
    assertTrue(validParentheses.isValid("()[{()}]"));
    assertTrue(validParentheses.isValid("()([{}])()"));
    assertFalse(validParentheses.isValid("("));
    assertFalse(validParentheses.isValid("}{"));
  }
}