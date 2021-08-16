package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class OddEvenTest {

  @Test
  public void oddEvenMod() {
    OddEven oddEven = new OddEven();
    assertEquals("even", oddEven.oddEvenMod(0));
    assertEquals("even", oddEven.oddEvenMod(2));
    assertEquals("odd", oddEven.oddEvenMod(1));
    assertEquals("odd", oddEven.oddEvenMod(3));
  }

  @Test
  public void oddEvenBit() {
    OddEven oddEven = new OddEven();
    assertEquals("even", oddEven.oddEvenBit(0));
    assertEquals("even", oddEven.oddEvenBit(2));
    assertEquals("odd", oddEven.oddEvenBit(1));
    assertEquals("odd", oddEven.oddEvenBit(3));
  }
}