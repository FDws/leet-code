package org.fdws.lc.hard;

import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/3/29 22:44
 */

public class MinCutToHWTest {
  public int minCut(String s) {
    var length = s.length();
    var dp = new boolean[length][length];

    for (int j = 0; j < dp.length; j++) {
      for (int i = j; i >= 0; i--) {
        if (j == i) {
          dp[i][j] = true;
        } else if (j == i + 1) {
          dp[i][j] = s.charAt(i) == s.charAt(j);
        } else {
          dp[i][j] = s.charAt(j) == s.charAt(i) && dp[i + 1][j - 1];
        }
      }
    }

    var minDp = new int[s.length()];
    for (int i = 1; i < minDp.length; i++) {
      if (dp[0][i]) {
        minDp[i] = 0;
      } else {
        var min = minDp[i - 1] + 1;

        for (int j = 1; j < i; j++) {
          if (dp[j][i]) {
            min = Math.min(minDp[j - 1] + 1, min);
          }
        }
        minDp[i] = min;
      }
    }

    return minDp[minDp.length - 1];
  }

  @Test
  void test() {
    System.out.println(minCut("aab"));
    System.out.println(minCut("ab"));
  }
}
