package ca.jrvs.practice.codingChallenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ticket: https://www.notion.so/jarvisdev/Implement-Stack-using-Queue-792d35e848524a808e9ac3aa1298daba
 */
public class StackUsingQueue {

  public static class TwoQueue {

    private Queue<Integer> queue;
    private Queue<Integer> tempQueue;

    public TwoQueue() {
      queue = new LinkedList<>();
      tempQueue = new LinkedList<>();
    }

    /**
     * Big-O: O(n)
     * Justification: Two loops of n O(n+n) = O(n)
     */
    public void push(int x) {
      tempQueue.add(x);
      while (!queue.isEmpty()) {
        tempQueue.add(queue.remove());
      }
      queue.clear();
      while (!tempQueue.isEmpty()) {
        queue.add(tempQueue.remove());
      }
      tempQueue.clear();
    }

    /**
     * Big-O: O(1)
     * Justification: constant time operation
     */
    public int pop() {
      return queue.remove();
    }

    /**
     * Big-O: O(1)
     * Justification: constant time operation
     */
    public int top() {
      return queue.peek();
    }

    /**
     * Big-O: O(1)
     * Justification: constant time operation
     */
    public boolean empty() {
      return queue.isEmpty();
    }
  }

  public static class OneQueue {

    private Queue<Integer> queue;

    public OneQueue() {
      queue = new LinkedList<>();
    }

    /**
     * Big-O: O(n)
     * Justification: loop over stack
     */
    public void push(int x) {
      queue.add(x);
      for (int i = 0; i < queue.size() - 1; i++) {
        queue.add(queue.remove());
      }
    }

    /**
     * Big-O: O(1)
     * Justification: constant time operation
     */
    public int pop() {
      return queue.remove();
    }

    /**
     * Big-O: O(1)
     * Justification: constant time operation
     */
    public int top() {
      return queue.peek();
    }

    /**
     * Big-O: O(1)
     * Justification: constant time operation
     */
    public boolean empty() {
      return queue.isEmpty();
    }
  }
}