package org.fdws.lc.medium;

import org.fdws.lc.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FDws
 * @version Created on 2021/3/17 21:56
 */

public class GenerateNodeTest {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return List.of();
    }

    if (n == 1) {
      return List.of(new TreeNode(1));
    }

    return generate(1, n + 1);
  }

  private static List<TreeNode> generate(int low, int high) {
    if (low >= high) {
      return List.of(new TreeNode(-1));
    }

    if (low + 1 == high) {
      return List.of(new TreeNode(low));
    }

    final var roots = new ArrayList<TreeNode>();
    for (int i = low; i < high; i++) {
      final var left = generate(low, i);
      final var right = generate(i + 1, high);
      final var fi = i;
      left.forEach(l -> {
        right.forEach(r -> {
          final var root = new TreeNode(fi);
          root.left = l.val < 0 ? null : l;
          root.right = r.val < 0 ? null : r;
          roots.add(root);
        });
      });
    }

    return roots;
  }

  @Test
  void test() {
    System.out.println(generateTrees(3).size());
  }
}
