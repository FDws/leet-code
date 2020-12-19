package org.fdws.lc.hard;

/**
 * @author FDws
 * @version Created on 2020/12/19 13:52
 * @see <a href="https://leetcode-cn.com/problems/distinct-subsequences-ii/">LeetCode</a>
 */

public class DistinctSubseqII {

    public int distinctSubseqII(String S) {
        // abcb ->
        //       a
        //       b, ab
        //       c, ac, bc, abc,
        //       bb, cb, abb, acb, bcb, abcb
        // abb ->
        //      a
        //      b, ab
        //      bb, abb
        int[] end = new int[26]; // 本字符添加之前的长度
        int res = 0;
        int added; // 当前额外增加的数量
        int mod = (int) 1e9 + 7;

        System.out.println('\n' + S);
        for (char c : S.toCharArray()) {
            // 额外增加的数量等于前面的数量加上1(当前字符串)减去最后一次相同字符添加之前的数量
            added = (res + 1 - end[c - 'a']) % mod;

            end[c - 'a'] = (res + 1) % mod; // 影响的为前一个字符的数量加上单字符的数量

            res = (res + added) % mod;
            System.out.printf("%2c, %2d, %2d\n", c, res, end[c - 'a']);
        }
        return (res + mod) % mod;
    }

    public static void main(String[] args) {
        final var sub = new DistinctSubseqII();
        System.out.println(sub.distinctSubseqII("abc"));
        System.out.println(sub.distinctSubseqII("aba"));
        System.out.println(sub.distinctSubseqII("abb"));
        System.out.println(sub.distinctSubseqII("abcb"));
        System.out.println(sub.distinctSubseqII("abccc"));
        System.out.println(sub.distinctSubseqII("abbbc"));
        System.out.println(sub.distinctSubseqII("abbb"));
        System.out.println(sub.distinctSubseqII("abb"));
        System.out.println(sub.distinctSubseqII("abcd"));
    }
}
