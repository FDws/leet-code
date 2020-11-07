package org.fdws.lc.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FDws
 * @version Created on 2020/11/7 15:52
 */

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 两个不同值模k有相同余数, 表示两个下标之间的数值之和为k的倍数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int v = k != 0 ? sum % k : sum;
            Integer o = map.put(v, i);
            if (o != null) {
                if (i - o > 1) return true;
                map.put(v, o);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var c = new ContinuousSubarraySum();
        System.out.println(c.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
    }
}
