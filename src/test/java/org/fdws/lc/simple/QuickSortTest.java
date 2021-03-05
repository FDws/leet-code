package org.fdws.lc.simple;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author FDws
 * @version Created on 2021/3/5 23:12
 */

public class QuickSortTest {
  void sort(int[] s, int b, int e) {
    var left = b;
    var right = e;

    if (right - left <= 1) {
      return;
    }

    var flag = s[left];

    while (left < right) {
      do {
        left++;
      } while (left < s.length && s[left] <= flag);

      do {
        right--;
      } while (s[right] > flag);

      if (left < right) {
        var t = s[left];
        s[left] = s[right];
        s[right] = t;
      }
    }

    var t = s[right];
    s[right] = s[b];
    s[b] = t;

    sort(s, b, right);
    sort(s, left + 1, e);
  }

  @Test
  void test() {
    var a = new int[]{5, 0, 3, 3, 3, 1, 6};
    sort(a, 0, a.length);
    System.out.println(Arrays.toString(a));
  }
}
