package org.fdws.lc.medium;

import java.util.ArrayList;

/**
 * @author FDws
 * @version Created on 2020/9/13 14:39
 */

public class WordSearchJ {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exist(int x, int y, char[][] board, String word, int idx) {
        if (idx >= word.length()) return true;
        var boardOutOfRange = x < 0 || y < 0 || x >= board.length || y >= board[0].length;

        if (boardOutOfRange) {
            return false;
        }

        var cha = board[x][y];
        if (cha == '.') return false;

        if (cha != word.charAt(idx)) {
            return false;
        }
        board[x][y] = '.';
        var result = exist(x, y + 1, board, word, idx + 1)
                || exist(x, y - 1, board, word, idx + 1)
                || exist(x - 1, y, board, word, idx + 1) ||
                exist(x + 1, y, board, word, idx + 1);
        board[x][y] = cha;
        return result;
    }

    private static long javaTest(char[][] board, String word, int count) {
        var begin = System.nanoTime();
        for (int i = 0; i < count; i++) {
            WordSearchJ.exist(board, word);
        }
        var end = System.nanoTime();
        return end - begin;
    }

    private static long kotlinTest(char[][] board, String word, int count) {
        var begin = System.nanoTime();
        for (int i = 0; i < count; i++) {
            WordSearch.exist(board, word);
        }
        var end = System.nanoTime();
        return end - begin;
    }

    public static void main(String[] args) {
        var board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        var word = "ABCCED";
        var count = 100000000;

        var idx = 16;
        var javaSpend = new ArrayList<Long>(idx);
        var ktSpend = new ArrayList<Long>(idx);
        for (int i = 0; i < idx; i++) {
            javaSpend.add(javaTest(board, word, count));
            ktSpend.add(kotlinTest(board, word, count));
        }

        System.out.println(javaSpend);
        System.out.println(ktSpend);

    }
}
