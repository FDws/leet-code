package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/3/16 22:16
 */

public class PartitionTwoArrayTest {
  public boolean canPartition(int[] nums) {
    var sum = 0;
    for (var n : nums) {
      sum += n;
    }

    if ((sum & 0x1) == 1) {
      return false;
    }

    var half = sum >> 1;
    var dp = new boolean[half + 1];
    dp[0] = true;
    for (var n : nums) {
      for (int i = dp.length - 1; i >= n; i--) {
        dp[i] |= dp[i - n];
      }
    }
    return dp[dp.length - 1];
  }

  @Test
  void test() {
    System.out.println(canPartition(new int[]{1, 5, 5, 11}));
    System.out.println(canPartition(new int[]{1, 5, 5, 12}));
  }
}
