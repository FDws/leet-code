package org.fdws.lc.medium;

import java.util.*;

/**
 * @author FDws
 * @version Created on 2020/9/19 15:59
 */

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        var test = new boolean[s.length() + 1];
        test[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (test[i]) {
                for (String word : wordDict) {
                    var len = word.length();
                    if (s.length() >= i + len && s.startsWith(word, i)) {
                        test[i + len] = true;
                    }
                }
            }

        }
        return test[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        System.out.println(wordBreak("aaaaaaa", List.of("aaaa", "aaa")));
        System.out.println(wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));

    }
}
