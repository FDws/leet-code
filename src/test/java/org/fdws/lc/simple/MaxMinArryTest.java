package org.fdws.lc.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author FDws
 * @version Created on 2021/1/3 21:48
 * @see <a href="https://leetcode-cn.com/problems/array-partition-i/">LeetCode</a>
 */

public class MaxMinArryTest {
    public int arrayPairSum(int[] nums) {
        var limit = 10000;
        var idx = new int[(limit << 1) + 1];
        for (var n : nums) {
            idx[n + limit]++;
        }

        var d = 0;
        var sum = 0;
        for (int i = 0; i < idx.length; i++) {
            if (idx[i] > 0) {
                var v = i - limit;
                var p = (idx[i] + (d ^ 1)) / 2 * v;
                sum += p;
                d = (d + idx[i]) % 2;
            }
        }
        return sum;
    }

    @Test
    void test() {
        assertEquals(4, arrayPairSum(new int[]{1, 2, 3, 4}));
        assertEquals(9, arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }

}
