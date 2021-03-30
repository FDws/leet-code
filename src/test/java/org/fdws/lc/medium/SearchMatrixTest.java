package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/3/30 23:22
 */

public class SearchMatrixTest {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (target < matrix[0][0] ||
      matrix.length == 0 ||
      matrix[0].length == 0 ||
      target > matrix[matrix.length - 1][matrix[0].length - 1]) {
      return false;
    }

    var left = 0;
    var right = matrix.length;
    while (left + 1 < right) {
      var mid = left + (right - left) / 2;
      if (matrix[mid][0] > target) {
        right = mid;
      } else if (matrix[mid][0] < target) {
        left = mid;
      } else {
        return true;
      }
    }

    var arr = matrix[left];
    left = 0;
    right = arr.length;
    while (left < right) {
      var mid = left + (right - left) / 2;
      if (arr[mid] > target) {
        right = mid;
      } else if (arr[mid] < target) {
        left = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }

  @Test
  void test() {
    System.out.println(searchMatrix(new int[][]{
      {1, 3, 5, 7},
      {10, 11, 16, 20},
      {23, 30, 34, 60}
    }, 3));

    System.out.println(searchMatrix(new int[][]{
      {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
    }, 13));
  }
}
