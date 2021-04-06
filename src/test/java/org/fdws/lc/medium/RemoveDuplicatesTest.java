package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/4/6 22:35
 */

public class RemoveDuplicatesTest {
  public int removeDuplicates(int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    }

    int index = 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[index - 2] != nums[i]) {
        nums[index++] = nums[i];
      }
    }
    return index;
  }

  @Test
  void test() {
    var arr = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
    final var idx = removeDuplicates(arr);
    for (var i = 0; i < idx; i++) {
      System.out.printf("%d ", arr[i]);
    }
    System.out.println();
  }
}
