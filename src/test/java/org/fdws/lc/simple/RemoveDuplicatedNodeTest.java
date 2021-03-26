package org.fdws.lc.simple;

import org.fdws.lc.medium.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/3/26 22:57
 */

public class RemoveDuplicatedNodeTest {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode curr = head;
    ListNode next = head.next;
    while (next != null) {
      if (next.val == curr.val) {
        curr.next = next.next;
        next = curr.next;
      } else {
        curr = curr.next;
        next = next.next;
      }
    }
    return head;
  }

  @Test
  void test() {

  }
}
