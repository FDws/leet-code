package org.fdws.lc.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author FDws
 * @version Created on 2020/12/29 22:19
 * @see <a href="https://leetcode-cn.com/problems/add-without-plus-lcci/">LeetCode</a>
 */

public class NoPlusAddTest {
    public int add0(int a, int b) {
        while (b != 0) {
            var c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public int add(int a, int b) {
        var n = new byte[32];
        var pre = 0;
        for (int i = 0; i < 32; i++) {
            var ai = a >> i & 0x1;
            var bi = b >> i & 0x1;
            n[i] = (byte) (ai ^ bi ^ pre);
            var t = 1 << ai;
            t <<= bi;
            t <<= pre;
            pre = t >= 4 ? 1 : 0;
        }
        var result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= n[32 - i - 1];
        }

        return result;
    }

    @Test
    void test() {
        assertEquals(1, add0(1, 0));
        assertEquals(0, add0(0, 0));
        assertEquals(-1, add0(-1, 0));
        assertEquals(-10, add0(-1, -9));
        assertEquals(10, add0(1, 9));

    }
}
