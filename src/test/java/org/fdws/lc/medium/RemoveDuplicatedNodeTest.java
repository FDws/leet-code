package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author FDws
 * @version Created on 2021/3/25 22:41
 */

public class RemoveDuplicatedNodeTest {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    final var top = new ListNode(0);
    top.next = head;
    var pre = top;
    var first = head;
    var sec = head.next;

    while (sec != null) {
      if (sec.val == first.val) {
        while (sec != null && sec.val == first.val) {
          sec = sec.next;
        }

        pre.next = sec;
        first = pre.next;
        sec = sec == null ? null : sec.next;
      } else {
        pre = first;
        first = sec;
        sec = sec.next;
      }
    }

    return top.next;
  }

  void print(ListNode node) {
    var i = 0;
    while (node != null && i < 10000) {
      i++;
      System.out.print(node.val + " ");
      node = node.next;
    }
    System.out.println();
  }

  @Test
  void test() {
    var top = new ListNode(0);
    var flag = top;
    for (var i : List.of(1, 1, 1, 2, 3)) {
      flag.next = new ListNode(i);
      flag = flag.next;
    }

    print(deleteDuplicates(top.next));
  }
}
