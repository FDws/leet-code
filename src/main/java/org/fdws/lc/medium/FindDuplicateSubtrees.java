package org.fdws.lc.medium;

import java.util.*;

/**
 * @author FDws
 * @version Created on 2020/9/20 14:35
 */

public class FindDuplicateSubtrees {
    static class TreeNode {
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

    static Map<String, Integer> flag = new HashMap<>();
    static Map<Integer, Integer> flagInt = new HashMap<>();
    static List<TreeNode> result = new ArrayList<>();
    static int agg = 1;

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        calc(root);
        return result;
    }

    private static int calc(TreeNode node) {
        if (node == null) return 0;

        var strId = "(" + calc(node.left) + ',' + node.val + ',' + calc(node.right) + ')';

        var id = flag.get(strId);

        if (id == null) {
            id = agg++;
            flag.put(strId, id);
        }

        var count = flagInt.getOrDefault(id, 0) + 1;

        if (count == 2) {
            result.add(node);
        }
        flagInt.put(id, count);

        return id;
    }

    private static TreeNode build(List<Integer> values) {
        var root = new TreeNode(values.get(0));
        build(values.subList(1, values.size()), List.of(root));
        return root;
    }

    private static void build(List<Integer> values, List<TreeNode> nodes) {
        var next = new ArrayList<TreeNode>();
        for (var node : nodes) {
            if (!values.isEmpty()) {
                if (values.get(0) != null) {
                    node.left = new TreeNode(values.get(0));
                    next.add(node.left);
                }
                values.remove(0);
            }

            if (!values.isEmpty()) {
                if (values.get(0) != null) {
                    node.right = new TreeNode(values.get(0));
                    next.add(node.right);
                }
                values.remove(0);
            }
        }

        if (!next.isEmpty()) {
            build(values, next);
        }
    }

    private static void printNode(TreeNode node) {
        if (node == null) {
            System.out.print(", null");
            return;
        }
        System.out.print(", " + node.val);
        if (node.right != null) {
            printNode(node.left);
            printNode(node.right);
        } else if (node.left != null) {
            printNode(node.left);
        }
    }

    public static void main(String[] args) {

        var values = new Integer[]{2, 1, 1};
//        var values = new Integer[]{0, 0, 0, 0, null, null, 0, null, null, null, 0};
        var v = new ArrayList<>(Arrays.asList(values));
        final var nodes = build(v);

        findDuplicateSubtrees(nodes).forEach(n -> {
            System.out.println("");
            printNode(n);
        });
    }
}
