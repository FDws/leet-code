package org.fdws.lc.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FDws
 * @version Created on 2020/9/25 23:22
 */

public class Combinations {
    private static final List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        result.clear();
        combine(new int[k], n, k, 1, 0);
        return result;
    }

    private static void combine(int[] arr, int n, int k, int begin, int idx) {
        if (idx == k) {
            var part = new ArrayList<Integer>(k);
            for (var a : arr) {
                part.add(a);
            }
            result.add(part);
            return;
        }

        for (int i = begin; i <= n - k + 1 + idx; i++) {
            arr[idx] = i;
            combine(arr, n, k, i + 1, idx + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 3));
//        System.out.println(combine(4, 2));
//        System.out.println(combine(4, 4));
//        System.out.println(combine(4, 1));
//        System.out.println(combine(1, 1));
    }
}
