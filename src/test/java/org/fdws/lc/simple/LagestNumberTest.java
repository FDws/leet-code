package org.fdws.lc.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author FDws
 * @version Created on 2020/12/24 22:50
 * @see <a href="https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/">LeetCode</a>
 */

public class LagestNumberTest {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int sMax = -1;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                sMax = max;
                max = nums[i];
            } else if (nums[i] > sMax) {
                sMax = nums[i];
            }

        }

        return max >= sMax * 2 ? maxIndex : -1;
    }

    @Test
    void test() {
        assertEquals(3, dominantIndex(new int[]{0, 0, 0, 1}));
        assertEquals(1, dominantIndex(new int[]{3, 6, 1, 0}));
        assertEquals(-1, dominantIndex(new int[]{1, 2, 3, 4}));
        assertEquals(2, dominantIndex(new int[]{1, 0, 2}));
    }
}
