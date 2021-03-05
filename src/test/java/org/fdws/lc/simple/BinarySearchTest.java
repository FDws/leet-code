package org.fdws.lc.simple;

import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/3/5 22:31
 */

public class BinarySearchTest {
  int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    var left = 0;
    var right = nums.length;

    while (left < right) {
      var mid = left + (right - left >> 1);
      var value = nums[mid];
      if (value < target) {
        left = mid + 1;
      } else if (value >= target) {
        right = mid;
      }
//      else if (value == target) {
//        right = mid;
//      }
    }

    return left;
  }

  @Test
  void test() {
    System.out.println(binarySearch(new int[]{1, 2, 3, 3, 3, 4, 5,}, 3));
    System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5,}, 5));
    System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5,}, 1));
    System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5,}, 0));
    System.out.println(binarySearch(new int[]{1, 5}, 0));
    System.out.println(binarySearch(new int[]{1, 3, 5, 6}, 2));
    System.out.println(binarySearch(new int[]{1, 3, 5, 6}, 7));
    System.out.println(binarySearch(new int[]{1, 3, 5, 6}, 0));
  }
}
