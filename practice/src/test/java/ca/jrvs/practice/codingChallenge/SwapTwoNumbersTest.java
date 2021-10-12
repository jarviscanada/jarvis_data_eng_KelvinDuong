package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;

public class SwapTwoNumbersTest extends TestCase {

  public void testSwapTwoNumbers() {
    SwapTwoNumbers swapTwoNumbers = new SwapTwoNumbers();
    Integer[] numbers = new Integer[]{1,2};
    Integer[] swapped = swapTwoNumbers.swapTwoNumbers(numbers);
    assertEquals(1, (int) swapped[1]);
    assertEquals(2, (int) swapped[0]);
  }
}