package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author FDws
 * @version Created on 2021/4/7 22:28
 */

public class RotateSearchTest {
  public boolean search(int[] nums, int target) {
    int i = 0, j = nums.length - 1, m = (i + j) / 2;
    while (i <= j) {
      if (nums[m] == target || nums[i] == target || nums[j] == target) {
        return true;
      }
      if (nums[m] > target && nums[i] < target) {
        j = m - 1;
      }//左侧有序区间，启动二分查找
      else if (nums[m] < target && nums[j] > target) {
        i = m + 1;
      }//右侧有序区间，启动二分查找
      else {
        i++;
        j--;
      }//仍在中间无序部分，左边界加1，右边界减一
      m = (i + j) / 2;
    }
    return false;
  }

  @Test
  void test() {
    assertTrue(search(new int[]{1, 0, 1, 1, 1}, 0));
    assertFalse(search(new int[]{1}, 0));
    assertTrue(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
    assertFalse(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    assertTrue(search(new int[]{0, 0, 1, 1, 2, 0}, 2));
    assertTrue(search(new int[]{4, 0, 1, 1, 2, 3}, 4));
  }
}
