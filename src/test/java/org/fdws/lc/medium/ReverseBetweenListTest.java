package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author FDws
 * @version Created on 2021/3/19 23:23
 */

public class ReverseBetweenListTest {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (left == right) {
      return head;
    }

    var topNode = new ListNode(0);
    var pre = topNode;
    topNode.next = head;
    for (int i = 1; i < left; i++) {
      pre = pre.next;
    }

    var curr = pre.next;
    var leftNode = curr;

    for (int i = left; i <= right; i++) {
      var t = pre.next;
      pre.next = curr;
      curr = curr.next;

      pre.next.next = t;
    }

    leftNode.next = curr;
    return topNode.next;

  }

  void print(ListNode node) {
    var idx = 0;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
      idx++;

      if (idx > 10000) {
        System.out.println("Dead");
        break;
      }
    }
    System.out.println();
  }

  @Test
  void test() {
    var pre = new ListNode(0);
    ListNode first = pre;
    for (var i : List.of(1, 2, 3, 4, 5)) {
      first.next = new ListNode(i);
      first = first.next;
    }
    print(pre.next);
    print(reverseBetween(pre.next, 2, 4));
  }
}
