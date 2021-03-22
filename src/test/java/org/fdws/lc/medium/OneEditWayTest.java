package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author FDws
 * @version Created on 2021/3/22 22:03
 */

public class OneEditWayTest {
  private boolean oneEdit(String first, String second) {
    final var step = first.length() - second.length();
    if (step > 1 || step < -1) {
      return false;
    }
    var count = 1;
    for (int i = 0, j = 0; i < first.length() && j < second.length(); i++, j++) {
      if (first.charAt(i) != second.charAt(j)) {
        if (step == 1) {
          j--;
        } else if(step == -1) {
          i--;
        }
        count--;
      }
      if (count < 0) {
        return false;
      }
    }
    return true;
  }

  @Test
  void test() {
    assertTrue(oneEdit("pale", "ple"));
    assertFalse(oneEdit("pales", "pal"));
    assertTrue(oneEdit("aa", "a"));
    assertTrue(oneEdit("", "a"));
    assertTrue(oneEdit("", ""));
    assertTrue(oneEdit("teacher", "beacher"));
  }
}
