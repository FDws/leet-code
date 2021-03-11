package org.fdws.lc.simple;

/**
 * @author FDws
 * @version Created on 2021/3/11 22:42
 */

public class AddTwoNumTest {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    var i = 0;
    final var head = new ListNode(0);
    var tail = head;
    while (l1 != null || l2 != null) {
      final var v1 = l1 == null ? 0 : l1.val;
      final var v2 = l2 == null ? 0 : l2.val;

      final var num = v1 + v2 + i;
      final var node = new ListNode(num % 10);

      if (num >= 10) {
        i = 1;
      } else {
        i = 0;
      }

      tail.next = node;
      tail = node;

      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
    }

    if (i > 0) {
      tail.next = new ListNode(1);
    }

    return head.next;
  }

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
}

