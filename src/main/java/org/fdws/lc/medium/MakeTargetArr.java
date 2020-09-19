package org.fdws.lc.medium;

/**
 * @author FDws
 * @version Created on 2020/9/19 20:21
 */

public class MakeTargetArr {
    public static int minOperations(int[] nums) {
        var max = 0;
        var count = 0;
        for (var n : nums) {
            max = Math.max(n, max);
        }

        for (var n : nums) {
            count += Integer.bitCount(n);
        }
        return count + Integer.toBinaryString(max).length() - 1;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 5}));
        System.out.println(minOperations(new int[]{2, 2}));
        System.out.println(minOperations(new int[]{4, 2, 5}));
        System.out.println(minOperations(new int[]{3, 2, 2, 4}));
        System.out.println(minOperations(new int[]{2, 4, 8, 16}));
    }
}
