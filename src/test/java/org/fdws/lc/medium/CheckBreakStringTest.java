package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/3/15 22:51
 */

public class CheckBreakStringTest {
  public boolean checkIfCanBreak(String s1, String s2) {
    final var c1 = s1.toCharArray();
    final var c2 = s2.toCharArray();

    var ca1 = new int[26];
    var ca2 = new int[26];

    for (int i = 0; i < c1.length; i++) {
      ca1[c1[i] - 'a']++;
      ca2[c2[i] - 'a']++;
    }

    return check(ca1, ca2) || check(ca2, ca1);
  }

  private static boolean check(int[] c1, int[] c2) {
    var g = 0;
    for (int i = 0; i < c1.length; i++) {
      if (c1[i] > c2[i]) {
        g += c1[i] - c2[i];
      } else if (c2[i] > c1[i]) {
        g -= c2[i] - c1[i];
        if (g < 0) {
          return false;
        }
      }
    }
    return true;
  }

  @Test
  void test() {
    System.out.println(checkIfCanBreak("abc", "xya"));
    System.out.println(checkIfCanBreak("abe", "acd"));
    System.out.println(checkIfCanBreak("leetcodee", "interview"));
  }
}
