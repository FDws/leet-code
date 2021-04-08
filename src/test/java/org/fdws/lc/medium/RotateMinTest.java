package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author FDws
 * @version Created on 2021/4/8 22:42
 */

public class RotateMinTest {
  public int findMin(int[] nums) {
    var min = nums[0];
    var left = 0;
    var right = nums.length;
    while (left < right) {
      if (right - left == 1) {
        return Math.min(nums[left], min);
      }
      var mid = left + (right - left) / 2;
      min = Math.min(min, nums[mid]);
      if (nums[mid] < nums[left] || nums[right - 1] > nums[left]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return min;
  }

  @Test
  void test() {
    assertEquals(1, findMin(new int[]{5, 1, 2, 3, 4}));
  }
}
