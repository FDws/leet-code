package org.fdws.lc.simple;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author FDws
 * @version Created on 2021/3/11 22:33
 */

public class TwoNumSumTest {
  public int[] twoSum(int[] nums, int target) {
    var map = new HashMap<Integer, Integer>();

    for (var i = 0; i < nums.length; i++) {
      var sub = target - nums[i];
      if (map.containsKey(sub)) {
        return new int[]{map.get(sub), i};
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[2];
  }

  @Test
  void test() {
    System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 5, 9}, 9)));
  }
}
