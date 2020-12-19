package org.fdws.lc.hard;


/**
 * @author FDws
 * @version Created on 2020/12/19 22:10
 * @see <a href="https://leetcode-cn.com/problems/n-queens-ii/">LeetCode</a>
 */

public class NQueensII {
    private int result;
    private int last;

    public int totalNQueens(int n) {
        result = 0;
        last = 0;
        int[] xR = new int[n];
        int[] l = new int[n << 1];
        int[] r = new int[n << 1];
        rev(0, xR, l, r);
        return n % 2 == 0 ? result * 2 : (result - last) * 2 + last;
    }

    private void rev(int x, int[] xR, int[] l, int[] r) {
        var n = xR.length;
        var mid = x == 0 ? n + 1 >> 1 : n;
        var tmp = 0;
        for (int i = 0; i < mid; i++) {
            if (x == 0) {
                tmp = result;
            }

            var leftUp = x - i + n;
            var rightUp = x + i;
            if (xR[i] == 0 && l[leftUp] == 0 && r[rightUp] == 0) {
                if (x == n - 1) {
                    result += 1;
                } else {
                    xR[i] = 1;
                    l[leftUp] = 1;
                    r[rightUp] = 1;
                    rev(x + 1, xR, l, r);
                    xR[i] = 0;
                    l[leftUp] = 0;
                    r[rightUp] = 0;
                }
            }

            if (x == 0) {
                last = result - tmp;
            }
        }
    }

    public static void main(String[] args) {
        final var q = new NQueensII();
        System.out.println(q.totalNQueens(2));
        System.out.println(q.totalNQueens(4));
        System.out.println(q.totalNQueens(5));
        System.out.println(q.totalNQueens(8));
    }
}
