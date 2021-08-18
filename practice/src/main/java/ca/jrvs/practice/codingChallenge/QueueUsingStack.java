package ca.jrvs.practice.codingChallenge;

import java.util.Stack;

/**
 * ticket: https://www.notion.so/jarvisdev/Implement-Queue-using-Stacks-2391fec1887244c5ba3a00902c619a5b
 */
public class QueueUsingStack {

  public static class TwoStack {

    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    public TwoStack() {
      stack = new Stack<Integer>();
      tempStack = new Stack<Integer>();
    }

    /**
     * Big-O: O(1)
     * Justification: constant time operation
     */
    public void push(int x) {
      stack.push(x);
    }

    /**
     * Big-O: O(n)
     * Justification: loop over stack
     */
    public int pop() {
      if (tempStack.empty()) {
        while (!stack.isEmpty()) {
          tempStack.push(stack.pop());
        }
      }
      return tempStack.pop();
    }

    /**
     * Big-O: O(n)
     * Justification: loop over stack
     */
    public int peek() {
      if (tempStack.empty()) {
        while (!stack.isEmpty()) {
          tempStack.push(stack.pop());
        }
      }
      return tempStack.peek();
    }

    /**
     * Big-O: O(1)
     * Justification: constant time operation
     */
    public boolean empty() {
      return stack.isEmpty() && tempStack.isEmpty();
    }
  }

  public static class TwoStackSecond {

    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    public TwoStackSecond() {
      stack = new Stack<Integer>();
      tempStack = new Stack<Integer>();
    }

    /**
     * Big-O: O(n)
     * Justification: loop over two stacks
     */
    public void push(int x) {
      while (!stack.isEmpty()) {
        tempStack.push(stack.pop());
      }
      stack.push(x);
      while (!tempStack.isEmpty()) {
        stack.push(tempStack.pop());
      }
    }

    /**
     * Big-O: O(1)
     * Justification: constant time operation
     */
    public int pop() {
      return stack.pop();
    }

    /**
     * Big-O: O(1)
     * Justification: constant time operation
     */
    public int peek() {
      return stack.peek();
    }

    /**
     * Big-O: O(1)
     * Justification: constant time operation
     */
    public boolean empty() {
      return stack.isEmpty();
    }
  }
}