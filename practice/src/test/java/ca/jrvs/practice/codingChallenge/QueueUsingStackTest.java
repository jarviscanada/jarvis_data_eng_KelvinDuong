package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import ca.jrvs.practice.codingChallenge.QueueUsingStack.TwoStack;
import ca.jrvs.practice.codingChallenge.QueueUsingStack.TwoStackSecond;
import org.junit.Test;

public class QueueUsingStackTest {

  @Test
  public void TwoStack() {
    TwoStack twoStack = new TwoStack();
    twoStack.push(1);
    twoStack.push(2);
    twoStack.push(3);
    assertEquals(1, twoStack.pop());
    assertEquals(2, twoStack.peek());
    assertEquals(2, twoStack.pop());
    assertEquals(3, twoStack.pop());
    assertTrue(twoStack.empty());
  }

  @Test
  public void TwoStackSecond() {
    TwoStackSecond twoStackSecond = new TwoStackSecond();
    twoStackSecond.push(1);
    twoStackSecond.push(2);
    twoStackSecond.push(3);
    assertEquals(1, twoStackSecond.pop());
    assertEquals(2, twoStackSecond.peek());
    assertEquals(2, twoStackSecond.pop());
    assertEquals(3, twoStackSecond.pop());
    assertTrue(twoStackSecond.empty());
  }

}