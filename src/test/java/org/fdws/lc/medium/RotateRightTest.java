package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author FDws
 * @version Created on 2021/3/27 23:19
 */

public class RotateRightTest {
  public ListNode rotateRight(ListNode head, int k) {
    if (k <= 0 || head == null) {
      return head;
    }

    var tail = head;
    var length = 1;
    while (tail.next != null) {
      length++;
      tail = tail.next;
    }

    k %= length;
    if (k <= 0) {
      return head;
    }
    k = length - k;

    tail.next = head;
    while (k-- > 0) {
      tail = tail.next;
    }

    head = tail.next;
    tail.next = null;
    return head;
  }

  void print(ListNode node) {
    var i = 0;
    while (node != null && i < 10000) {
      System.out.printf("%d ", node.val);
      node = node.next;
    }
    System.out.println();
  }

  @Test
  void test() {
    var node = new ListNode(0);
    var flag = node;
    for (var i : List.of(0, 1, 2)) {
      flag.next = new ListNode(i);
      flag = flag.next;
    }

    print(rotateRight(node.next, 4));
  }
}
