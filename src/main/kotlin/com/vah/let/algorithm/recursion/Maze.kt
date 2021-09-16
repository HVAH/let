package com.vah.let.algorithm.recursion;

/**
 *@Description 迷宫 找到路线
 *@Author HuangJiang
 **/
class Maze {

}

fun main() {
    val array = Array<IntArray>(8) { IntArray(7) }
    creatMap(array)
    go(array, 1, 1)


    println()
    for (ints in array) {
        for (int in ints) {
            print("$int  ")
        }
        println()
    }
}

fun creatMap(array: Array<IntArray>) {
    // 用1表示墙
    for (i in 0 until 8) {
        array[i][0] = 1
        array[i][6] = 1
    }
    for (i in 0 until 7) {
        array[0][i] = 1
        array[7][i] = 1
    }
    array[3][1] = 1
    array[3][2] = 1
    for (ints in array) {
        for (int in ints) {
            print("$int  ")
        }
        println()
    }
}

/**
 * 策略  下右上左
 * （6，5）为终点
 */
fun go(array: Array<IntArray>, i: Int, j: Int): Boolean {
    if (array[6][1] == 2) {
        return true
    } else {
        val location = array[i][j]
        if (location == 1) { // 撞墙
            return false
        } else if (location == 3) { // 之前走过了  走不通
            return false
        } else if (location == 2) { // 走通过了 不能重复走
            return false
        } else { // 没有走过
            // 假定该点可以走
            array[i][j] = 2
            return if (goLeft(array, i, j)) {
                true
            } else if (goUp(array, i, j)) {
                true
            } else if (goRight(array, i, j)) {
                true
            } else if (goDown(array, i, j)) {
                true
            } else {
                // 改点走不通
                array[i][j] = 3
                false
            }
        }
    }
}

// 最短寻路 // TODO 最短寻路 待实现
fun fastGo(array: Array<IntArray>, i: Int, j: Int, endI: Int, endJ: Int): Boolean {
    if (array[endI][endJ] == 2) {
        return true
    } else {
        val location = array[i][j]
        if (location == 1) { // 撞墙
            return false
        } else if (location == 3) { // 之前走过了  走不通
            return false
        } else if (location == 2) { // 走通过了 不能重复走
            return false
        } else { // 没有走过
            // 选择策略
            // 假定该点可以走
            array[i][j] = 2
            return if (goLeft(array, i, j)) {
                true
            } else if (goUp(array, i, j)) {
                true
            } else if (goRight(array, i, j)) {
                true
            } else if (goDown(array, i, j)) {
                true
            } else {
                // 改点走不通
                array[i][j] = 3
                false
            }
        }
    }
    val listOf = listOf(goUp)
}

val goUp =  fun(array: Array<IntArray>, i: Int, j: Int) = go(array, i - 1, j)

val goDown = fun(array: Array<IntArray>, i: Int, j: Int) = go(array, i + 1, j)

val goRight = fun(array: Array<IntArray>, i: Int, j: Int) = go(array, i, j + 1)

val goLeft = fun(array: Array<IntArray>, i: Int, j: Int) = go(array, i, j - 1)

