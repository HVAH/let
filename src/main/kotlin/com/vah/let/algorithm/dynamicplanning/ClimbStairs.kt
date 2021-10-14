package com.vah.let.algorithm.dynamicplanning;

import java.util.LinkedList
import java.util.zip.CheckedOutputStream

/**
 *@Description
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *@Author HuangJiang
 **/
class ClimbStairs {
}

/**
 * 当n=1时 f(1) = 1 ;n=2时 f(2) = 2; n=3时 f(3)=3 n = 4时 f(4)  = 5
 * 可以发现 n>2 时 f(n) = f(n-1) + f(n-2)
 * 当前解法 当n比较大时  会很耗时
 */
fun climbStairs(n: Int): Int {
    if (n <= 1) {
        return 1
    }
    if (n < 3) {
        return n
    }
    return climbStairs(n - 1) + climbStairs(n - 2)
}

/**
 * 循环  有点类似于动态规划
 */
fun climbStairs2(n:Int): Int {
    if (n < 3) {
        return n
    }
    val queen = IntArray(n)
    queen[0] = 1
    queen[1] = 2

    for (i in 2 until n) {
        queen[i] = queen[i - 2] + queen[i - 1]
    }
    return queen[n]
}

fun main() {
    println(climbStairs(100))
}
