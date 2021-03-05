package org.fdws.lc.simple;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author FDws
 * @version Created on 2021/3/5 23:05
 */

public class MergeSortedArrayTest {
  int[] merge(int[] a, int[] b) {
    var c = new int[a.length + b.length];
    var ai = 0;
    var bi = 0;

    while (ai + bi < c.length) {
      var next = ai + bi;
      if (ai >= a.length) {
        System.arraycopy(b, bi, c, next, b.length - bi);
        break;
      } else if (bi >= b.length) {
        System.arraycopy(a, ai, c, next, a.length - ai);
        break;
      } else if (a[ai] > b[bi]) {
        c[next] = b[bi];
        bi++;
      } else {
        c[next] = a[ai];
        ai++;
      }
    }

    return c;
  }

  @Test
  void test() {
    System.out.println(Arrays.toString(merge(new int[]{1, 2, 3}, new int[]{0, 4, 5})));
    System.out.println(Arrays.toString(merge(new int[]{0}, new int[]{0, 4, 5})));
  }
}
