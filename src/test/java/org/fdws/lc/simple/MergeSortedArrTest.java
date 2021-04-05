package org.fdws.lc.simple;

import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/4/5 21:30
 */

public class MergeSortedArrTest {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    var neo = new int[m + n];
    var idx = neo.length - 1;
    var i1 = m - 1;
    var i2 = n - 1;
    while (idx >= 0) {
      if (i1 >= 0 && (i2 < 0 || nums1[i1] >= nums2[i2])) {
        nums1[idx] = nums1[i1];
        i1--;
      } else {
        nums1[idx] = nums2[i2];
        i2--;
      }
      idx--;
    }
  }

  @Test
  void test() {
    merge(new int[4], 2, new int[2], 2);
  }
}
