package org.fdws.lc.medium;

import java.util.Arrays;

/**
 * @author FDws
 * @version Created on 2021/3/21 22:33
 */

public class SetZerosTest {
  void setZeros(int[][] matrix) {
    var firstRowIsZero = false;
    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        firstRowIsZero = true;
        break;
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        matrix[0][0] = 0;
        break;
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < matrix[i].length; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    for (int i = 1; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 1; j < matrix.length; j++) {
          matrix[j][i] = 0;
        }
      }
    }

    if (matrix[0][0] == 0) {
      for (int i = 1; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }

    if (firstRowIsZero) {
      Arrays.fill(matrix[0], 0);
    }
  }
}
