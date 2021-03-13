package org.fdws.lc.simple;

import org.junit.jupiter.api.Test;

/**
 * @author FDws
 * @version Created on 2021/3/13 22:57
 */

public class TransposeMatrixTest {

  public int[][] transpose(int[][] matrix) {
    if (matrix.length == 0) {
      return matrix;
    }

    final var neo = new int[matrix[0].length][matrix.length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        neo[j][i] = matrix[i][j];
      }
    }
    return neo;
  }

  @Test
  void test() {
    final var arr = new int[][]{{2, 4, -1}, {-10, 5, 11}, {18, -7, 6}};
    var neo = transpose(arr);
    for (var i : neo) {
      for (var j : i) {
        System.out.printf("%2d ", j);
      }
      System.out.println();
    }
  }
}
