package com.vah.let.algorithm.dfsbfs_backtrack

object WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val width: Int = board[0].size
        val length = board.size
        val star = word[0]
        for (i in 0 until length) {
            for (j in 0 until width) {
                if (star == board[i][j]) {
                }
            }
        }
        return false
    }

    fun next(i: Int, j: Int, board: Array<CharArray>, word: String, index: Int): Boolean {
        if (index == word.length) {
            return true
        }
        val thisChar = word[index]
        if (i < board.size && j < board[0].size) {
            if (board[i][j] == thisChar) {
                return next(i, j + 1, board, word, index + 1)
            } else {
                //
            }
        }
        return false
    }
}
