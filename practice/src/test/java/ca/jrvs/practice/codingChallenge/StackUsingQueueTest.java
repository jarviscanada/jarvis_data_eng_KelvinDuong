package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import ca.jrvs.practice.codingChallenge.StackUsingQueue.OneQueue;
import ca.jrvs.practice.codingChallenge.StackUsingQueue.TwoQueue;
import org.junit.Test;

public class StackUsingQueueTest {

  @Test
  public void TwoQueue() {
    TwoQueue twoQueue = new TwoQueue();
    twoQueue.push(1);
    twoQueue.push(2);
    twoQueue.push(3);
    assertEquals(3, twoQueue.pop());
    assertEquals(2, twoQueue.top());
    assertEquals(2, twoQueue.pop());
    assertEquals(1, twoQueue.pop());
    assertTrue(twoQueue.empty());
  }

  @Test
  public void OneQueue() {
    OneQueue oneQueue = new OneQueue();
    oneQueue.push(1);
    oneQueue.push(2);
    oneQueue.push(3);
    assertEquals(3, oneQueue.pop());
    assertEquals(2, oneQueue.top());
    assertEquals(2, oneQueue.pop());
    assertEquals(1, oneQueue.pop());
    assertTrue(oneQueue.empty());
  }
}