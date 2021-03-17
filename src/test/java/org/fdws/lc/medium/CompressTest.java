package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author FDws
 * @version Created on 2021/3/17 22:16
 */

public class CompressTest {
  public int compress(char[] chars) {
    if (chars.length == 1) {
      return 1;
    }

    char pre = chars[0];
    int num = 1;
    int sum = 0;

    var c = chars[1];
    var idx = 0;
    for (int i = 1; i < chars.length + 1; i++) {
      c = i == chars.length ? '0' : chars[i];

      if (c != pre) {
        chars[idx] = pre;
        idx++;
        idx = patchN(chars, idx, num);

        sum += num > 1 ? numI(num) + 1 : 1;
        pre = c;
        num = 0;
      }
      num += 1;
    }

    return sum;
  }

  private static int patchN(char[] c, int begin, int n) {
    if (n == 1) {
      return begin;
    }

    final var s = String.valueOf(n).toCharArray();
    System.arraycopy(s, 0, c, begin, s.length);
    return begin + s.length;
  }

  private static int numI(int i) {
    int n = 1;
    while (i / 10 > 0) {
      i /= 10;
      n++;
    }
    return n;
  }

  @Test
  void test() {
    var c1  = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    System.out.println(compress(c1));
    System.out.println(Arrays.toString(c1));

    c1 = "abbbbbbbbbbbb".toCharArray();
    System.out.println(compress(c1));
    System.out.println(Arrays.toString(c1));
  }
}
