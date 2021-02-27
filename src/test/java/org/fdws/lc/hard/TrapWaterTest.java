package org.fdws.lc.hard;

import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/2/27 20:39
 * @see <a href="https://leetcode-cn.com/problems/trapping-rain-water/">LeetCode</a>
 */

public class TrapWaterTest {
  public int trap(int[] height) {
    if (height.length < 3) {
      return 0;
    }
    var left = 0;
    var right = height.length - 1;

    var maxL = 0;
    var maxR = 0;

    var sum = 0;
    while (left < right) {
      maxL = Math.max(height[left], maxL);
      maxR = Math.max(height[right], maxR);

      if (maxL < maxR) {
        sum += Math.max(0, maxL - height[left]);
        left++;
      } else {
        sum += Math.max(0, maxR - height[right]);
        right--;
      }
    }
    return sum;
  }

  @Test
  void test() {
    System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
  }
}
