package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/3/12 22:33
 */

public class LongestPalindromeTest {
  public String longestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }

    final var chars = s.toCharArray();
    final int[] be = {0, 0};
    for (int i = 0; i < s.length(); i++) {
      i = find(chars, i, be);
    }
    return s.substring(be[0], be[1] + 1);
  }

  private static int find(char[] arr, int left, int[] be) {
    var right = left;
    while (right < arr.length - 1 && arr[right + 1] == arr[left]) {
      right++;
    }

    int tmp = right;

    while (left > 0 && right < arr.length - 1 && arr[left - 1] == arr[right + 1]) {
      left--;
      right++;
    }

    if (right - left > be[1] - be[0]) {
      be[0] = left;
      be[1] = right;
    }

    return tmp;
  }

  @Test
  void test() {
    System.out.println(longestPalindrome("a"));
    System.out.println(longestPalindrome("bb"));
    System.out.println(longestPalindrome("babad"));
    System.out.println(longestPalindrome("cbbd"));
    System.out.println(longestPalindrome("ac"));
  }
}
