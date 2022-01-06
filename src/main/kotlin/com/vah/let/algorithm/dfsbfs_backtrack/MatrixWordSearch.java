package com.vah.let.algorithm.dfsbfs_backtrack;

/**
 * @Description 矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * @Author Jiang
 * @Date 2022/1/6 3:04 下午
 **/
public class MatrixWordSearch {

    public static boolean exist(char[][] board, String word) {
        int width = board[0].length;
        int length = board.length;
        char star = word.charAt(0);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (star == board[i][j]) {

                }
            }
        }
    }

    public static boolean next(int i, int j, char[][] board, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        char thisChar = word.charAt(index);
        if (i < board.length && j < board[0].length) {
            if (board[i][j] == thisChar) {
                return next(i, j + 1, board, word, index + 1);
            } else {
                next(i + 1, j, board, word, index);
                next(i, j - 1, board, word, index);
                next(i - 1, j, board, word, index);
            }
        }
        return false;
    }
}
