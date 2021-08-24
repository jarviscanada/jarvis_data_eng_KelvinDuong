package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.codingChallenge.MiddleOfLinkedList.ListNode;
import junit.framework.TestCase;

public class MiddleOfLinkedListTest extends TestCase {

  public void testMiddleNode() {
    MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
    ListNode listNode = new ListNode(1);
    assertEquals(listNode, middleOfLinkedList.middleNode(listNode));
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    listNode.next = listNode2;
    listNode.next.next = listNode3;
    assertEquals(listNode2.val, middleOfLinkedList.middleNode(listNode).val);
  }
}