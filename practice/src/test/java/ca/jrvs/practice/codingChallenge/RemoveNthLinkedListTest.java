package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.codingChallenge.RemoveNthLinkedList.ListNode;
import junit.framework.TestCase;

public class RemoveNthLinkedListTest extends TestCase {

  public void testRemoveNthFromEnd() {
    RemoveNthLinkedList removeNthLinkedList = new RemoveNthLinkedList();
    ListNode listNode = new ListNode(1);
    assertNull(removeNthLinkedList.removeNthFromEnd(listNode, 1));
    listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(4);
    removeNthLinkedList.removeNthFromEnd(listNode, 2);
    assertEquals(4, listNode.next.next.val);
  }
}