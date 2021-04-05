package org.fdws.lc.simple;

import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/4/5 21:30
 */

public class MergeSortedArrTest {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    var neo = new int[m + n];
    var idx = 0;
    var i1 = 0;
    var i2 = 0;
    while (idx < m + n) {
      while (i1 < m && (i2 >= n || nums1[i1] <= nums2[i2])) {
        System.out.println(1);
        neo[idx++] = nums1[i1++];
      }
      while (i2 < n && (i1 >= m || nums1[i1] > nums2[i2])) {
        neo[idx++] = nums2[i2++];
        System.out.println(2);
      }
      System.out.println(3);
    }
    System.arraycopy(neo, 0, nums1, 0, neo.length);
  }

  @Test
  void test() {
    merge(new int[4], 2, new int[2], 2);
  }
}
