package ca.jrvs.practice.codingChallenge;

import java.util.LinkedList;

/**
 * ticket: https://www.notion.so/jarvisdev/Nth-Node-From-End-of-LinkedList-de7683e881d8402c8473104b97cbf804
 */
public class RemoveNthLinkedList {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  /**
   * Big-O: O(n)
   * Justification: Loops through linked list at most once. Deleting takes O(1)
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head.next == null && n == 1) {
      return null;
    }
    ListNode start = head;
    ListNode nthAfter = head;
    ListNode prev = start;
    for (int i = 0; i < n - 1; i++) {
      if (nthAfter == null) {
        return null;
      }
      nthAfter = nthAfter.next;
    }
    while (nthAfter.next != null) {
      prev = start;
      start = start.next;
      nthAfter = nthAfter.next;
    }
    prev.next = prev.next.next;
    return head;
  }

}