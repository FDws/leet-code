package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author FDws
 * @version Created on 2021/1/6 23:12
 * @see <a href="https://leetcode-cn.com/problems/count-substrings-that-differ-by-one-character/">LeetCode</a>
 */

public class CountOneCharDiffTest {
    public int countSubstrings(String s, String t) {
        var sl = s.length();
        var tl = t.length();
        var result = 0;
        for (int i = 0; i < sl; i++) {
            result += count(s, t, i, 0);
        }
        for (int i = 1; i < tl; i++) {
            result += count(s, t, 0, i);
        }

        return result;
    }

    private static int count(String s, String t, int si, int ti) {
        var result = 0;
        var fij = 0;
        var gij = 0;
        for (; si < s.length() && ti < t.length(); si++, ti++) {
            if (s.charAt(si) == t.charAt(ti)) {
                gij++;
            } else {
                fij = gij + 1;
                gij = 0;
            }
            result += fij;
        }
        return result;
    }

    @Test
    void test() {
        assertEquals(6, countSubstrings("aba", "baba"));
        assertEquals(3, countSubstrings("ab", "bb"));
        assertEquals(0, countSubstrings("a", "a"));
        assertEquals(10, countSubstrings("abe", "bbc"));
    }
}
