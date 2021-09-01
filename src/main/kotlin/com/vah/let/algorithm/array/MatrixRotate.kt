package com.vah.let.algorithm.array;

/**
 *@Description 图像旋转  旋转90度
 *@Author HuangJiang
 **/
class MatrixRotate {
}

// 第一步  以中心位置上下对调  第二步 以斜对角对称互换(i=j的数即为斜对角线上的数)
fun rotate(matrix: Array<IntArray>) {
    val size = matrix.size
    for (i in 0 until size / 2) {
        val temp = matrix[i]
        matrix[i] = matrix[size - i - 1]
        matrix[size - i - 1] = temp
    }
    for ( i in 0 until size) {
        for (j in i + 1 until size) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }

}

fun show(matrix: Array<IntArray>) {
    for (ints in matrix) {
        for (int in ints) {
            print("$int  ")
        }
        println()
    }
}

fun main() {
    val arr = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    show(arr)
    rotate(arr)
    println("rotate(arr) =======")
    show(arr)
}
