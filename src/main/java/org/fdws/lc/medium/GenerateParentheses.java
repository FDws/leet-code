package org.fdws.lc.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FDws
 * @version Created on 2020/9/16 22:53
 */

public class GenerateParentheses {
    /**
     */
    public static List<String> generateParenthesis(int n) {
        var chs = new char[n << 1];
        chs[0] = '(';

        var result = new ArrayList<String>();
        generate(chs, 1, 1, 0, result);
        return result;
    }

    private static void generate(char[] chs, int idx, int right, int left, List<String> result) {
        if (idx == chs.length) {
            result.add(String.valueOf(chs));
        } else {
            var mid = chs.length >> 1;

            if (right < mid) {
                chs[idx] = '(';
                generate(chs, idx + 1, right + 1, left, result);
            }
            if (left < right) {
                chs[idx] = ')';
                generate(chs, idx + 1, right, left + 1, result);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }
}
