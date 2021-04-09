package org.fdws.lc.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author FDws
 * @version Created on 2021/4/9 22:59
 */

public class RotateSearchMinTest {
  public int findMin(int[] nums) {
    var left = 0;
    var right = nums.length - 1;
    while (left < right) {
      var mid = left + (right - left) / 2;
      if (nums[left] == nums[right]) {
        right--;
      } else if (nums[right] >= nums[mid]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return nums[left];
  }

  @Test
  void test() {
    assertEquals(1, findMin(new int[]{1, 3, 5}));
    assertEquals(0, findMin(new int[]{2, 2, 2, 0, 1}));
    assertEquals(0, findMin(new int[]{3, 4, 0, 1, 1}));
  }
}
