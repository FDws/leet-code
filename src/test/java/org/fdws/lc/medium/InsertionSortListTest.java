package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author FDws
 * @version Created on 2021/3/18 22:47
 */

public class InsertionSortListTest {
  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return null;
    }
    var next = head.next;
    head.next = null;

    var tmp = new ListNode(Integer.MIN_VALUE);
    tmp.next = head;

    while (next != null) {
      var neo = next;
      next = next.next;
      neo.next = null;

      var flag = tmp;
      while (flag.next != null && neo.val > flag.next.val) {
        flag = flag.next;
      }

      var tt = flag.next;
      flag.next = neo;
      neo.next = tt;
    }

    return tmp.next;
  }

  void pri(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
    System.out.println();
  }

  @Test
  void test() {
    var head = new ListNode(0);
    var tmp = head;
    for (var i : List.of(6, 5, 3, 1, 8, 7, 2, 4)) {
      tmp.next = new ListNode(i);
      tmp = tmp.next;
    }
    pri(head.next);

    var node = insertionSortList(head.next);
    pri(node);
  }
}
