package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author FDws
 * @version Created on 2020/12/20 22:11
 * @see <a href="https://leetcode-cn.com/problems/h-index-ii/">LeetCode</a>
 */

public class HIndexIITest {
    int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int max = 0;
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + right >> 1;

            if (citations[mid] >= n - mid) {
                max = n - mid;
                right = mid;
            } else if (citations[mid] < n - mid) {
                left = mid + 1;
            }
        }
        return max;
    }

    @Test
    void test() {
        assertEquals(3, hIndex(new int[]{0, 1, 3, 5, 6}));
        assertEquals(1, hIndex(new int[]{1}));
        assertEquals(2, hIndex(new int[]{0, 0, 4, 4}));
    }
}