package org.fdws.lc.hard;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author FDws
 * @version Created on 2021/1/16 16:14
 * @see <a href="https://leetcode-cn.com/problems/jump-game-ii/">LeetCode</a>
 */

public class JumpGameIITest {
    int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int length = nums.length;
        int startJump = 0;
        int maxPosition = nums[0];
        int steps = 0;

        while (maxPosition < length - 1) {
            int max = maxPosition;
            for (int i = startJump + 1; i <= max; i++) {
                if (i + nums[i] > maxPosition) {
                    maxPosition = i + nums[i];
                    startJump = i;
                }
            }
            steps++;
        }
        return steps + 1;
    }

    @Test
    void test() {
        assertEquals(2, jump(new int[]{2, 3, 1, 1, 4}));
        assertEquals(3, jump(new int[]{5, 4, 0, 1, 3, 6, 8, 0, 9, 4, 9, 1, 8, 7, 4, 8}));
    }
}
