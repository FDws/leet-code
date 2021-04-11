package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/4/11 22:41
 */

public class NthUglyNumberTest {
  public int nthUglyNumber(int n) {

    var arr = new int[n];
    arr[0] = 1;
    int p2 = 0;
    int p3 = 0;
    int p5 = 0;
    for (int i = 1; i < n; i++) {
      var n2 = arr[p2] * 2;
      var n3 = arr[p3] * 3;
      var n5 = arr[p5] * 5;
      arr[i] = Math.min(n2, Math.min(n3, n5));
      if (arr[i] == n2) {
        p2++;
      }
      if (arr[i] == n3) {
        p3++;
      }
      if (arr[i] == n5) {
        p5++;
      }
    }
    return arr[n - 1];
  }

  @Test
  void test() {
    System.out.println(nthUglyNumber(10));
  }
}
