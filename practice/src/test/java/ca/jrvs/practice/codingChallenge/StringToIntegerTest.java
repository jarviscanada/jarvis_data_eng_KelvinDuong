package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringToIntegerTest {

  @Test
  public void stringToInteger() {
    StringToInteger stringToInteger = new StringToInteger();
    assertEquals(4235, stringToInteger.stringToInteger("4235 with words"));
    assertEquals(-4235, stringToInteger.stringToInteger("-4235 with words"));
  }

  @Test
  public void stringToIntegerAscii() {
    StringToInteger stringToInteger = new StringToInteger();
    assertEquals(4235, stringToInteger.stringToIntegerAscii("4235 with words"));
    assertEquals(-4235, stringToInteger.stringToIntegerAscii("-4235 with words"));
  }
}