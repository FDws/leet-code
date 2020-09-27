package org.fdws.lc.medium;

/**
 * @author FDws
 * @version Created on 2020/9/27 23:11
 */

public class CountUnhappyFriends {
    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        var count = 0;
        var pp = new int[n];
        for (var p : pairs) {
            pp[p[0]] = p[1];
            pp[p[1]] = p[0];
        }
        for (int i = 0; i < pp.length; i++) {
            if (favorite(i, pp, preferences)) {
                count += 1;
            }
        }
        return count;
    }

    private static boolean favorite(int x, int[] pair, int[][] relation) {
        var y = pair[x];

        for (var rx : relation[x]) {
            if (y == rx) {
                return false;
            } else {
                int u = pair[rx];

                for (var v : relation[rx]) {
                    if (v == u) {
                        break;
                    }
                    if (v == x) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(unhappyFriends(4,
                new int[][]{
                        {1, 2, 3},
                        {3, 2, 0},
                        {3, 1, 0},
                        {1, 2, 0}
                }, new int[][]{
                        {0, 1}, {2, 3}
                }));

        System.out.println(unhappyFriends(
                2, new int[][]{{1}, {0}}, new int[][]{{1, 0}}
        ));

        System.out.println(unhappyFriends(
                4, new int[][]{
                        {1, 3, 2}, {2, 3, 0},
                        {1, 3, 0}, {0, 2, 1}
                }, new int[][]{{1, 3}, {0, 2}}
        ));

        System.out.println(unhappyFriends(
                6,
                new int[][]{
                        {1, 4, 3, 2, 5},
                        {0, 5, 4, 3, 2},
                        {3, 0, 1, 5, 4},
                        {2, 1, 4, 0, 5},
                        {2, 1, 0, 3, 5},
                        {3, 4, 2, 0, 1}},
                new int[][]{
                        {3, 1},
                        {2, 0},
                        {5, 4}}
        ));
    }
}
