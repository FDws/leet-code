package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FDws
 * @version Created on 2021/3/31 22:27
 */

public class SubSet90Test {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    var result = new ArrayList<List<Integer>>();
    result.add(new ArrayList<>());
    if (nums == null || nums.length == 0) {
      return result;
    }

    Arrays.sort(nums);
    result.add(List.of(nums[0]));

    var preSize = 1;
    for (int i = 1; i < nums.length; i++) {
      var size = result.size();
      if (nums[i] != nums[i - 1]) {
        preSize = size;
      }

      for (int j = size - preSize; j < size; j++) {
        final var tmp = new ArrayList<>(result.get(j));
        tmp.add(nums[i]);
        result.add(tmp);
      }
    }
    return result;
  }

  @Test
  void test() {
    subsetsWithDup(new int[]{1, 2, 2}).forEach(it -> {
      it.forEach(i -> System.out.printf("%d ", i));
      System.out.println();
    });
  }
}
