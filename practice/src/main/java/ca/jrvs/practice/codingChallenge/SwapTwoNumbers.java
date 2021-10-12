package ca.jrvs.practice.codingChallenge;

/**
 * ticket: https://www.notion.so/jarvisdev/Swap-two-numbers-f3445f8d1a3849b1a9180d0f9a635be9
 */
public class SwapTwoNumbers {

  /**
   * Big-O: O(1)
   * Justification: Just a couple of constant time operations
   */
  public Integer[] swapTwoNumbers(Integer[] n) {
    int x = n[0] + n[1];
    int y = x - n[1];
    x = x - y;
    return new Integer[]{x, y};
  }
}
