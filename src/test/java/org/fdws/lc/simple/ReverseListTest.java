package org.fdws.lc.simple;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

/**
 * @author FDws
 * @version Created on 2021/2/27 0:37
 */

public class ReverseListTest {
  class Node {
    private final int value;
    private Node next;

    Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }

    Node(int value) {
      this(value, null);
    }
  }

  Node reverse(Node root) {
    Node pre = null;
    var next = root.next;

    while (next != null) {
      var t = next.next;
      next.next = root;
      root.next = pre;
      pre = root;
      root = next;
      next = t;
    }
    return root;
  }

  @Test
  void test() {
    var root = new Node(0, null);
    var next = root;
    for (var it : List.of(1, 2, 3, 4, 5)) {
      next.next = new Node(it, null);
      next = next.next;
    }
    root = reverse(root);
    int i = 0;
    while (root != null && i++ < 1000) {
      System.out.println(root.value);
      root = root.next;
    }
  }
}
