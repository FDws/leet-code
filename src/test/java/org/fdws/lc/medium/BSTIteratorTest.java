package org.fdws.lc.medium;

import org.fdws.lc.TreeNode;

/**
 * @author FDws
 * @version Created on 2021/3/28 22:54
 */

public class BSTIteratorTest {
  TreeNode root;

  boolean me;
  BSTIteratorTest left;
  BSTIteratorTest right;

  public BSTIteratorTest(TreeNode root) {
    this.root = root;
    if (root.left != null) {
      left = new BSTIteratorTest(root.left);
    }
    if (root.right != null) {
      right = new BSTIteratorTest(root.right);
    }
  }

  public int next() {
    BSTIteratorTest other = this;
    while (true) {
      if (other.left != null && other.left.hasNext()) {
        other = other.left;
        continue;
      }
      if (!other.me) {
        other.me = true;
        return other.root.val;
      }
      other = other.right;
    }
  }

  public boolean hasNext() {
    if (left != null && left.hasNext()) {
      return true;
    }
    if (!me) {
      return true;
    }
    return right != null && right.hasNext();
  }
}
