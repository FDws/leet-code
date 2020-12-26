package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author FDws
 * @version Created on 2020/12/26 16:12
 * @see <a href="https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/">LeetCode</a>
 */

public class MaxLengthWithUniqueCharTest {

    private int maxLength(List<String> arr) {
        var bits = new int[arr.size()];
        for (int i = 0; i < bits.length; i++) {
            bits[i] = toBit(arr.get(i));
        }

//        return maxSub(arr, new int[26], 0);
        return maxSub(bits, 0, 0);
    }

    private int maxSub(int[] bits, int pre, int index) {
        if (index >= bits.length) {
            return 0;
        }
        int max = 0;

        int curr = bits[index];
        if ((pre & curr) == 0) {
            max = Math.max(max, maxSub(bits, pre | curr, index + 1) + Integer.bitCount(curr));
        }

        return Math.max(max, maxSub(bits, pre, index + 1));

    }

    private int toBit(String s) {
        int bit = 0;
        for (var c : s.toCharArray()) {
            var pos = 1 << c - 'a';
            if ((bit & pos) != 0) {
                return 0;
            }
            bit |= pos;
        }
        return bit;
    }

    @Test
    void test() {
        assertEquals(4, maxLength(List.of("un", "ue", "iq")));
        assertEquals(6, maxLength(List.of("cha", "r", "act", "ers")));
        assertEquals(0, maxLength(List.of("yy", "bkhwmpbiisbldzknpm")));
    }
}
