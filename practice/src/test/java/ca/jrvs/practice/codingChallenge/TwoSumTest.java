package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoSumTest {

  @Test
  public void twoSumBrute() {
    TwoSum twoSum = new TwoSum();
    int[] array = new int[]{1,2,3,4,5};
    assertTrue(twoSum.twoSumBrute(array, 7));
    assertFalse(twoSum.twoSumBrute(array, 10));
  }

  @Test
  public void twoSumSorted() {
    TwoSum twoSum = new TwoSum();
    int[] array = new int[]{5,4,3,2,1};
    assertTrue(twoSum.twoSumSorted(array, 7));
    assertFalse(twoSum.twoSumSorted(array, 10));
  }

  @Test
  public void twoSumMao() {
    TwoSum twoSum = new TwoSum();
    int[] array = new int[]{5,4,3,2,1};
    assertTrue(twoSum.twoSumMap(array, 7));
    assertFalse(twoSum.twoSumMap(array, 10));
  }
}