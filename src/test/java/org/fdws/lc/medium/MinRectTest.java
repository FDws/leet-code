package org.fdws.lc.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * @author FDws
 * @version Created on 2021/1/4 22:45
 */

public class MinRectTest {
    public int minAreaRect(int[][] points) {
        var pm = new HashSet<Integer>();
        for (var p : points) {
            pm.add(calc(p[0], p[1]));
        }

        var result = Integer.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                var p1 = points[i];
                var p2 = points[j];

                if (p1[0] != p2[0] && p1[1] != p2[1] &&
                        pm.contains(calc(p1[0], p2[1])) && pm.contains(calc(p2[0], p1[1]))) {
                    result = Math.min(result, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private static int calc(int x, int y) {
        return 40001 * x + y;
    }

    @Test
    void test() {
        assertEquals(4, minAreaRect(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}}));
        assertEquals(2, minAreaRect(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}}));
    }
}
