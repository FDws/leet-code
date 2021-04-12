package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author FDws
 * @version Created on 2021/4/12 22:50
 */

public class LargestNumberTest {
  public String largestNumber(int[] nums) {
    var num = new Integer[nums.length];
    for (int i = 0; i < nums.length; i++) {
      num[i] = nums[i];
    }
    Arrays.sort(num, (b, a) -> (int) (Long.parseLong(a + String.valueOf(b)) - Long.parseLong(b + String.valueOf(a))));
    var result = Arrays.stream(num).map(e -> e.toString()).collect(Collectors.joining(""));
    for (int i = 0; i < result.length(); i++) {
      if (result.charAt(i) != '0') {
        return result.substring(i);
      }
    }
    return "0";
  }

  @Test
  void test() {
    System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    System.out.println(largestNumber(new int[]{0, 0}));
  }
}
