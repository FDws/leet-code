package org.fdws.lc.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FDws
 * @version Created on 2020/12/21 22:39
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-preorder-traversal/">LeetCode</a>
 */

public class BTreePreTraversal {

    class TreeNode {
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

    List<Integer> preorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        var tmp = new ArrayList<TreeNode>();

        while (root != null) {
            result.add(root.val);
            if (root.right != null) {
                tmp.add(root.right);
            }
            if (root.left != null) {
                tmp.add(root.left);
            }

            if (tmp.isEmpty()) {
                break;
            }
            root = tmp.remove(tmp.size() - 1);
        }
        return result;
    }

    void dg(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            dg(root.left, result);
            dg(root.right, result);
        }
    }
}
