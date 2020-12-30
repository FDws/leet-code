package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author FDws
 * @version Created on 2020/12/30 22:45
 * @see <a href="https://leetcode-cn.com/problems/determine-if-two-strings-are-close/">LeetCode</a>
 */

public class DetermineIfTwoStringsAreCloseTest {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.equals(word2)) {
            return true;
        }

        var w1 = new int[26];
        var w2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            var idx1 = word1.charAt(i) - 'a';
            var idx2 = word2.charAt(i) - 'a';

            w1[idx1] += 1;
            w2[idx2] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (w1[i] > 0 && w2[i] == 0) {
                return false;
            }
        }

        Arrays.sort(w1);
        Arrays.sort(w2);
        return Arrays.equals(w1, w2);
    }

    @Test
    void test() {
        assertTrue(closeStrings("abc", "cba"));
        assertTrue(closeStrings("abcbcc", "aabbbc"));
        assertTrue(closeStrings("cabbba", "abbccc"));
        assertFalse(closeStrings("cabbba", "aabbss"));
        assertFalse(closeStrings("uau", "ssx"));
    }
}
