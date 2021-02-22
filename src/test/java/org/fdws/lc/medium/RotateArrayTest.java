package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author FDws
 * @version Created on 2021/2/22 21:59
 */

public class RotateArrayTest {
  public void rotate(int[] nums, int k) {
    k %= nums.length;

    if (k == 0) {
      return;
    }
    var total = 0;
    var begin = 0;
    var i = nums.length - k;
    while (total < nums.length) {
      var idx = begin;
      var t = nums[idx];
      while (total < nums.length) {
        var next = (idx + i) % nums.length;
        if (next == begin) {
          if (idx != begin) {
            nums[idx] = t;
            total += 1;
          }
          break;
        }

        nums[idx] = nums[next];
        idx = next;
        total += 1;
      }

      begin += 1;
    }
  }

  @Test
  void test() {
    var arr = new int[]{-1, -100, 3, 99};
    rotate(arr, 2);
    assertArrayEquals(new int[]{3, 99, -1, -100}, arr);

    arr = new int[]{1, 2, 3, 4, 5, 6, 7};
    rotate(arr, 3);
    assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, arr);

    arr = new int[]{1};
    rotate(arr, 0);
    assertArrayEquals(new int[]{1}, arr);

    arr = new int[]{1, 2};
    rotate(arr, 2);
    assertArrayEquals(new int[]{1, 2}, arr);
  }
}
