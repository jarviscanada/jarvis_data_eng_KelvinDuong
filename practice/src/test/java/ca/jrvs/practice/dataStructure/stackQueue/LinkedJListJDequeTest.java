package ca.jrvs.practice.dataStructure.stackQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedJListJDequeTest {

  @Test
  public void add() {
    LinkedJListJDeque deque = new LinkedJListJDeque();
    deque.add("First");
    deque.add("Second");
    assertEquals("First", deque.remove());
    assertEquals("Second", deque.remove());
  }

  @Test
  public void remove() {
    LinkedJListJDeque deque = new LinkedJListJDeque();
    deque.add("First");
    deque.add("Second");
    assertEquals("First", deque.remove());
    assertEquals("Second", deque.remove());
  }

  @Test
  public void pop() {
    LinkedJListJDeque deque = new LinkedJListJDeque();
    deque.add("First");
    deque.add("Second");
    assertEquals("Second", deque.pop());
    assertEquals("First", deque.pop());
  }

  @Test
  public void push() {
    LinkedJListJDeque deque = new LinkedJListJDeque();
    deque.push("First");
    deque.push("Second");
    assertEquals("Second", deque.pop());
    assertEquals("First", deque.pop());
  }

  @Test
  public void peek() {
    LinkedJListJDeque deque = new LinkedJListJDeque();
    deque.push("First");
    deque.push("Second");
    assertEquals("First", deque.peek());
  }
}