package org.fdws.lc.simple;

import java.util.HashMap;

/**
 * @author FDws
 * @version Created on 2020/9/17 22:31
 */

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        var charToStr = new String[26];
        var strToChar = new HashMap<String, Character>();

        var patterns = pattern.toCharArray();
        var parts = s.split(" ");

        if (patterns.length != parts.length) {
            return false;
        }

        for (int i = 0; i < patterns.length; i++) {
            var c = patterns[i];
            var idx = c - 'a';

            var pat = charToStr[idx];
            var str = parts[i];

            if (pat == null) {
                if (strToChar.containsKey(str)) {
                    return false;
                }

                charToStr[idx] = str;
                strToChar.put(str, c);
            } else if (!pat.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat dog cat"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}