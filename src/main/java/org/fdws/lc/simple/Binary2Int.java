package org.fdws.lc.simple;


/**
 * @author FDws
 * @version Created on 2020/12/19 21:42
 * @see <a href="https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/">LeetCode</a>
 */

public class Binary2Int {
    public int getDecimalValue(ListNode head) {
        var node = head;
        var result = 0;
        while (node != null) {
            result = result << 1 | node.val;
            node = node.next;

        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode build(int[] ns) {
        var head = new ListNode(ns[0]);
        var tmp = head;
        for (int i = 1; i < ns.length; i++) {
            tmp.next = new ListNode(ns[i]);
            tmp = tmp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        final var b = new Binary2Int();

        System.out.println(b.getDecimalValue(build(new int[]{1, 0, 1})));
        System.out.println(b.getDecimalValue(build(new int[]{1})));
        System.out.println(b.getDecimalValue(build(new int[]{0, 0})));
        System.out.println(b.getDecimalValue(build(new int[]{0})));
        System.out.println(b.getDecimalValue(build(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0})));
    }
}
