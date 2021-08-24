package ca.jrvs.practice.codingChallenge;

/**
 * ticket: https://www.notion.so/jarvisdev/Middle-of-the-Linked-List-6f3f9a450f954845a65eca9f0cbc6d88
 */
public class MiddleOfLinkedList {

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
   * Justification: Loops through linked list at most once.
   */
  public ListNode middleNode(ListNode head) {
    ListNode middle = head;
    ListNode next = head;
    while (next != null && next.next != null) {
      middle = middle.next;
      next = next.next.next;
    }
    return middle;
  }

}
