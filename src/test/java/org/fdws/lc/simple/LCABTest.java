package org.fdws.lc.simple;

import org.fdws.lc.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author FDws
 * @version Created on 2021/3/10 22:16
 */

public class LCABTest {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == p || root == q || root == null) {
      return root;
    }
    final var left = lowestCommonAncestor(root.left, p, q);
    final var right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
      return root;
    }

    if (left == null && right != null) {
      return right;
    }
    return left;
  }
}
