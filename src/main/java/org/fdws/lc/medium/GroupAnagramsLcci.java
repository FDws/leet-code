package org.fdws.lc.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author FDws
 * @version Created on 2020/9/21 22:28
 */

public class GroupAnagramsLcci {
    public static List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();

        for (var str : strs) {
            var cc = str.toCharArray();
            Arrays.sort(cc);
            var key = new String(cc);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        var begin = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        }
        System.out.println(System.currentTimeMillis() - begin);
    }
}
