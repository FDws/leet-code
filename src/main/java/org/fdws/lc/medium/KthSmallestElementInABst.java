package org.fdws.lc.medium;

/**
 * @author FDws
 * @version Created on 2020/9/22 23:08
 */

public class KthSmallestElementInABst {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallest0(root, k);
        return result;
    }

    private int kthSmallest0(TreeNode root, int k) {
        if (root == null) return 0;

        var left = 0;
        if (root.left != null) {
            left = kthSmallest0(root.left, k);
        }
        if (left == -1) {
            return -1;
        }

        var next = k - left;
        if (next == 1) {
            result = root.val;
            return -1;
        }

        var right = kthSmallest0(root.right, next - 1);
        return right == -1 ? -1 : right + left + 1;
    }
}
