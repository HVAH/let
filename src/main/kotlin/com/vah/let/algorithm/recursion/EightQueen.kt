package com.vah.let.algorithm.recursion;

import kotlin.math.abs

/**
 *@Description 八皇后求解 n皇后求解 n皇后解的次数
 *
 *@Author HuangJiang
 **/
class EightQueen {
}

fun main() {
    val message = totalNQueens(10)
    println("=======================")
    println(message)
    println(countQ(10, 0, mutableListOf(), mutableListOf(), mutableListOf()))
}

// n 皇后
fun totalNQueens(n: Int): Int {
    val count = Count()
    checkN(IntArray(n), 0, count)
    return count.count
}

data class Count(
    var count: Int = 0
)

/**
 * 摆放第n个皇后
 */
fun checkN(arr: IntArray, n: Int, count: Count) {
    if (n == arr.size) { // 已经摆放完了
        arr.forEach { print(it) }
        println()
        // 次数加1
        count.count++
        return
    }
    for (i in arr.indices) {
        // 摆放第n个皇后的位置
        arr[n] = i
        if (judgeKill(arr, n)) { // 该位置可以行
            // 摆 N+1
            checkN(arr, n + 1, count)
        }
        // 回到上面继续摆放第n个皇后的位置
    }
}

/**
 * 判断位置是否可行
 * 分别与前面每一个皇后的位置对比 时间复杂度 O(n)
 * 优化： 最好的情况是O(1)判断出该位置所在的列和所在的两条斜线上是否有皇后
 * */
fun judgeKill(arr: IntArray, n: Int): Boolean {
    //
    for (i in 0 until n) {
        // arr[i] == arr[n] 表示在同一列  (x2 - x1) / (y2 -y1) = 1/-1 表示斜率为1或-1 表示在同一斜线上
        if (arr[i] == arr[n] || abs(i - n) == abs(arr[i] - arr[n])) {
            // 表示冲突
            return false
        }
    }
    return true
}

//
fun countQ(
    n: Int,
    row: Int,
    lineList: MutableList<Int>,
    inclined1List: MutableList<Int>,
    inclined2List: MutableList<Int>
): Int {
    if (n == row) {
        // 最后一个摆好了 解的次数加一
        return 1
    }
    var count = 0
    for (i in 0 until n) { // 依次摆第n个皇后的第i列
        if (lineList.contains(i)) {
            continue
        }
        // （x2 - x1）/ (y2 - y1) = 1 -> x2 -y2 = x1 - y1 表示在同一 '\' 反斜线上
        // (x2 - x1）/ (y2 - y1) = -1 -> x2 + y2 = x1 + y1 表示在同一 / 斜线上
        val inclined1 = row - i //
        if (inclined1List.contains(inclined1)) { // 有在同一 '\' 反斜线上的皇后
            continue
        }
        val incLined2 = row + i
        if (inclined2List.contains(incLined2)) { // 有在同一 '/' 斜线上的皇后
            continue
        }

        // 表示可以改在这个位置  递归摆放第 row+1行上的皇后
        lineList.add(i)
        inclined1List.add(inclined1)
        inclined2List.add(incLined2)
        count += countQ(n, row + 1, lineList, inclined1List, inclined2List)
        // 上面的调用结束后  表示 [row][i] 后面可能摆放的皇后都尝试完了 这是需要摆 [row][i++] 了  得移除[i]这个位置  尝试进行下一个位置的摆放
        lineList.remove(i)
        inclined1List.remove(inclined1)
        inclined2List.remove(incLined2)
    }
    return count
}
