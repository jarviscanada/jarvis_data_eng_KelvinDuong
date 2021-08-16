package ca.jrvs.practice.codingChallenge;

/**
 * ticket: https://www.notion.so/jarvisdev/Fibonacci-Number-Climbing-Stairs-885edd6869e140e7a7fd5148ae232a7d
 */
public class FibonacciClimbingStairs {

  /**
   * Big-O: O(2^n)
   * Justification: T(n) = T(n-1) + T(n-2) = T(n-2) + T(n-3) + T(n-3) + T(n-4) ... T(n-1) = 2^n-1
   */
  public int fibonacciRec(int n) {
    if (n == 1) {
      return 1;
    } else if (n == 0) {
      return 0;
    } else {
      return fibonacciRec(n-1) + fibonacciRec (n-2);
    }
  }

  /**
   * Big-O: O(n)
   * Justification: loop of n-2 items. stored previously found numbers
   */
  public int fibonacciDP(int n) {
    int[] fibonacci = new int[n+2];
    fibonacci[0] = 0;
    fibonacci[1] = 1;
    for (int i = 2; i <= n; i++) {
      fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
    }
    return fibonacci[n];
  }

  /**
   * Big-O: O(n)
   * Justification: loop of n-2 items. stored previously found numbers
   */
  public int climbingStairs(int n) {
    if (n <= 0)
      return 0;
    int list[] = new int[n+1];
    list[0] = list[1] = 1;
    for (int i=2; i <= n; i++)
      list[i] = list[i-1] + list[i-2];
    return list[n];
  }
}