package com.vah.let.algorithm.dynamicplanning;

/**
 *@Description
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
你可以认为每种硬币的数量是无限的
 *@Author HuangJiang
 **/
class CoinChange {
}

/**
 * 动态规划  暴力算法
 */
fun coinChange(coins: IntArray, amount: Int): Int {

    // base case
    if (amount == 0) {
        return 0
    }
    if (amount < 0) {
        // 表示无解
        return -1
    }

    var res = Int.MAX_VALUE
    for (coin in coins) {
        val tres = coinChange(coins, amount - coin)
        if (tres == -1) { // 无解继续下一次
            continue
        }
        res = Math.min(res, tres + 1)
    }
    return if (res == Int.MAX_VALUE) -1 else res
}

/**
 * 规避重复子问题的自顶向下递归
 */
fun coinChange2(coins: IntArray, amount: Int): Int {
    // 用数组保存求解过的amount硬币数，规避重复子问题
    val ress = IntArray(amount + 1)
    for (i in ress.indices) {
        ress[i] = -666 // 定义小于-1的任意数表示ress[amount] 没有求解过
    }
    return coinChange(coins, amount, ress)
}

fun coinChange(coins: IntArray, amount: Int, ress: IntArray): Int {
    // base case
    if (amount == 0) {
        return 0
    }
    if (amount < 0) {
        // 表示无解
        return -1
    }
    if (ress[amount] != -666) {
        return ress[amount]
    }
    var res = Int.MAX_VALUE
    for (coin in coins) {
        // amount - coin 的最低值  那么amount的最小值就是tres+一枚硬币
        val tres = coinChange(coins, amount - coin, ress)
        if (tres == -1) { // 无解继续下一次
            continue
        }
        res = Math.min(res, tres + 1)
    }
    res = if (res == Int.MAX_VALUE) -1 else res
    ress[amount] = res
    return res
}

/**
 * 使用迭代自底向上
 */
fun coinChange3(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1)
    for (i in dp.indices) {
        // 初始化值  amount + 1   因为最多只需要amount枚硬币
        dp[i] = amount + 1
    }
    // base case
    dp[0] = 0

    for (curAmount in 0..amount) {
        for (coin in coins) {
            if (curAmount - coin < 0) {
                continue
            }
            dp[curAmount] = Math.min(dp[curAmount - coin] + 1, dp[curAmount])
        }
    }
    return if (dp[amount] == amount + 1) -1 else dp[amount]
}

fun main() {
    println(coinChange3(intArrayOf(2), 3))
}
