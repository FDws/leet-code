package org.fdws.lc.simple;


import org.fdws.lc.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author FDws
 * @version Created on 2021/3/23 22:40
 */

public class KthLargestTest {

  private int kth(TreeNode root, int k) {
    var stack = new LinkedList<TreeNode>();

    do {
      while (root != null) {
        stack.addLast(root);
        root = root.right;
      }

      if (!stack.isEmpty()) {
        root = stack.removeLast();
        System.out.println(root.val);
        k--;
        if (k == 0) {
          return root.val;
        }
        root = root.left;
      }
    } while (!stack.isEmpty() || root != null);
    return 0;
  }

  public static TreeNode build(List<Integer> values, int empty) {
    final var queue = new LinkedList<TreeNode>();
    final var head = new TreeNode(values.get(0));
    queue.add(head);

    int idx = 1;
    while (idx < values.size()) {
      final var value = values.get(idx);
      final var poll = queue.pollFirst();
      if (value != empty) {
        poll.left = new TreeNode(value);
        queue.addLast(poll.left);
      }

      idx++;

      if (idx < values.size()) {
        if (values.get(idx) != empty) {
          poll.right = new TreeNode(values.get(idx));
          queue.addLast(poll.right);
        }
        idx++;
      }
    }
    return head;
  }

  void print(TreeNode node) {
    if (node == null) {
      return;
    }
    print(node.left);
    System.out.printf("%d ", node.val);
    print(node.right);
  }

  @Test
  void test() {
    kth(build(List.of(3, 1, 4, 0, 2), 0), 1);
    System.out.println();
    System.out.println(kth(build(List.of(5, 3, 6, 2, 4, 0, 0, 1), 0), 3));
  }
}
