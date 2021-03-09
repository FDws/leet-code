package org.fdws.lc.simple;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 交换数字, 使之大于原始并且最小
 *
 * @author FDws
 * @version Created on 2021/3/9 22:08
 */

public class ExchangeToMinMaxTest {
  String exchange(String str) {
    final var chars = str.toCharArray();

    int idx = -1;
    for (int i = chars.length - 1; i > 0; i--) {
      final var c1 = chars[i];
      final var c2 = chars[i - 1];

      if (c2 < c1) {
        idx = i - 1;
        break;
      }
    }

    if (idx < 0) {
      return str;
    }

    final var c = chars[idx];
    var min = idx + 1;
    for (int i = idx; i < chars.length; i++) {
      if (chars[i] > c && chars[i] < chars[min]) {
        min = i;
      }
    }

    if (min < chars.length) {
      var t = chars[min];
      chars[min] = chars[idx];
      chars[idx] = t;
    }

    Arrays.sort(chars, idx + 1, chars.length);
    return String.copyValueOf(chars);
  }

  @Test
  void test() {
    System.out.println(exchange("32132149587654321"));
    System.out.println(exchange("100000"));
  }
}
