package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciClimbingStairsTest {

  @Test
  public void fibonacciRec() {
    FibonacciClimbingStairs fibonacciClimbingStairs = new FibonacciClimbingStairs();
    assertEquals(0, fibonacciClimbingStairs.fibonacciRec(0));
    assertEquals(1, fibonacciClimbingStairs.fibonacciRec(1));
    assertEquals(1, fibonacciClimbingStairs.fibonacciRec(2));
    assertEquals(2, fibonacciClimbingStairs.fibonacciRec(3));
  }

  @Test
  public void fibonacciDP() {
    FibonacciClimbingStairs fibonacciClimbingStairs = new FibonacciClimbingStairs();
    assertEquals(0, fibonacciClimbingStairs.fibonacciDP(0));
    assertEquals(1, fibonacciClimbingStairs.fibonacciDP(1));
    assertEquals(1, fibonacciClimbingStairs.fibonacciDP(2));
    assertEquals(2, fibonacciClimbingStairs.fibonacciDP(3));
  }

  @Test
  public void climbingStairs() {
    FibonacciClimbingStairs fibonacciClimbingStairs = new FibonacciClimbingStairs();
    assertEquals(0, fibonacciClimbingStairs.climbingStairs(0));
    assertEquals(1, fibonacciClimbingStairs.climbingStairs(1));
    assertEquals(2, fibonacciClimbingStairs.climbingStairs(2));
    assertEquals(3, fibonacciClimbingStairs.climbingStairs(3));
    assertEquals(5, fibonacciClimbingStairs.climbingStairs(4));
  }
}