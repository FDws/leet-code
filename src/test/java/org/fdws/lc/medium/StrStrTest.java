package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author FDws
 * @version Created on 2021/3/7 15:39
 */

public class StrStrTest {
  public int strStr(String haystack, String needle) {
    if (needle.isEmpty()) {
      return 0;
    }

    if (haystack.length() < needle.length()) {
      return -1;
    }

    final var next = next(needle);
    var j = 0;
    var i = 0;

    while (i < haystack.length() && j < needle.length()) {
      if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
        i++;
        j++;
      } else {
        j = next[j];
      }
    }

    if (j == needle.length()) {
      return i - j;
    }

    return -1;
  }

  private static int[] next(String str) {
    final var chars = str.toCharArray();
    final var next = new int[chars.length];

    next[0] = -1;

    var i = 2;
    for (; i < chars.length; i++) {
      var j = next[i - 1];

      while (j >= 0) {
        if (chars[j] == chars[i - 1]) {
          next[i] = j + 1;
          break;
        }

        j = next[j];
        next[i] = 0;
      }
    }

    return next;
  }

  @Test
  void test() {
    System.out.println(Arrays.toString(next("abcabc")));
    System.out.println(Arrays.toString(next("abcabceabc")));
    System.out.println(Arrays.toString(next("aabaaac")));
    System.out.println(Arrays.toString(next("aaa")));
    System.out.println(Arrays.toString(next("ll")));

    assertEquals(strStr("ababababca", "abababca"), 2);
    assertEquals(strStr("hello", "ll"), 2);
    assertEquals(strStr("abcabceabc", "abceabc"), 3);
    assertEquals(strStr("aaa", "bba"), -1);
    assertEquals(strStr("aabaaabaaac", "aabaaac"), 4);
  }
}
