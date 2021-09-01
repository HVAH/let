package com.vah.let.algorithm.array

/**
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
数独部分空格内已填入了数字，空白格用 '.' 表示
 *
 *
 *
 * 输入：board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：true

 * **/

/**
 * 分别使用三个二维数组记录每行每列每个3x3单元格是否出现这个数
 */
fun shudu(arr: Array<CharArray>): Boolean {
    val cell = Array(arr.size) { BooleanArray(arr.size) }
    val column = Array(arr.size) { BooleanArray(arr.size) }
    val line = Array(arr.size) { BooleanArray(arr.size) }
    for (i in arr.indices) {
        for (j in arr.indices) {
            val value = arr[i][j]
            if (value == '.') {
                continue
            }
            // 当前格子的值
            val num = value - '0' - 1
            // 当前格子所在的单元格
            val k = i / 3 * 3 + j / 3
            if (cell[k][num] || column[j][num] || line[i][num]) {
                return false
            }
            cell[k][num] = true
            column[j][num] = true
            line[i][num] = true
        }
    }
    return true
}

fun shudu2(arr: Array<CharArray>): Boolean {
    val cell = IntArray(arr.size)
    val column = IntArray(arr.size)
    val line = IntArray(arr.size)
    for (i in arr.indices) {
        for (j in arr.indices) {
            val value = arr[i][j]
            if (value == '.') {
                continue
            }
            // 当前格子的值 进行位运算
            val num = 1 shl (value - '0' - 1)
            // 当前格子所在的单元格
            val k = i / 3 * 3 + j / 3
            if (cell[k] and num > 0 || column[j] and num > 0 || line[i] and num > 0) {
                return false
            }
            cell[k] = num or cell[k]
            line[i] = num or line[i]
            column[j] = num or column[j]
        }
    }
    return true
}

fun main() {
    println(4 and 2)
}


