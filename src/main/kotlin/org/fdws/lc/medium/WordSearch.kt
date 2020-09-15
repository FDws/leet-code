package org.fdws.lc.medium

/**
 * @author FDws
 * @version Created on 2020/9/13 14:14
 */

object WordSearch {
    @JvmStatic
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (exist(i, j, board, word, 0)) {
                    return true
                }
            }
        }
        return false
    }

    private fun exist(x: Int, y: Int, board: Array<CharArray>, word: String, idx: Int): Boolean {
        if (idx >= word.length) return true

        val boardOutOfRange = x < 0 || y < 0 || x >= board.size || y >= board[0].size

        if (boardOutOfRange) {
            return false
        }

        val char = board[x][y]
        if (char == '.') return false

        if (char != word[idx]) {
            return false
        }

        board[x][y] = '.'

        val result =
            exist(x, y + 1, board, word, idx + 1) ||
                    exist(x, y - 1, board, word, idx + 1) ||
                    exist(x + 1, y, board, word, idx + 1) ||
                    exist(x - 1, y, board, word, idx + 1)
        board[x][y] = char
        return result
    }
}

fun main() {
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )
    println(WordSearch.exist(board, "ABF"))
    println(WordSearch.exist(board, "ABCCED"))
    println(WordSearch.exist(board, "SEE"))
    println(WordSearch.exist(board, "ABCB"))
}