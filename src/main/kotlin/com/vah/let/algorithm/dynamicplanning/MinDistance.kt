package com.vah.let.algorithm.dynamicplanning;

import kotlin.math.min

/**
 *@Description 编辑距离
 * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符


示例1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/edit-distance
 *
 *@Author HuangJiang
 **/
class MinDistance {

}

fun minDistance(word1: String, word2: String): Int {
    val l1 = word1.length
    val l2 = word2.length

    // dp[i][j] 表示word1[0-i-1] 到 word2[0-j-1]的编辑次数
    val dp = Array(l1 + 1) { IntArray(l2 + 1) }
    // 初始化  0-0 表示""字符
    for (i in 1..l1) {
        dp[i][0] = i
    }
    for (j in 1..l2) {
        dp[0][j] = j
    }

    for (i in 1..l1) {
        for (j in 1..l2) {
            if (word1[i - 1] == word2[j - 1]) {
                // 相等 不用编辑
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1))
            }
        }
    }

    return dp[l1][l2]
}

/**
 * 暴力递归  超时
 */
fun minDistance2(word1: String, word2: String): Int {

    // i表示word1的下标
    // j 表示word2的下标
    fun dp(i: Int, j: Int): Int {

        if (i == -1) { // 表示word1到头 需要插入word2剩下的
            return j + 1
        }
        if (j == -1) { //// 表示word2到头 需要删除word1剩下的
            return i + 1
        }

        if (word1[i] == word2[j]) { // 相等不用处理 下标都向前
            return dp(i - 1, j - 1)
        } else {
            return Math.min(dp(i, j - 1) + 1, Math.min(dp(i - 1, j) + 1, dp(i - 1, j - 1) + 1))
        }
    }

    return dp(word1.length - 1, word2.length - 1)
}

/**
 * 加上缓存的递归 减少重复计算
 */
fun minDistance3(word1: String, word2: String): Int {
    val n = Array(word1.length) { IntArray(word2.length) }
    for (i in n.indices) {
        n[i].fill(-1, 0, n[i].size)
    }
    fun dp(i: Int, j: Int): Int {
        if (i == -1) { // 表示word1到头 需要插入word2剩下的
            return j + 1
        }
        if (j == -1) { //// 表示word2到头 需要删除word1剩下的
            return i + 1
        }
        return if (n[i][j] != -1) n[i][j] else {
            n[i][j] = if (word1[i] == word2[j]) { // 相等不用处理 下标都向前
                dp(i - 1, j - 1)
            } else {
                Math.min(
                    dp(i, j - 1) + 1,
                    Math.min(
                        dp(i - 1, j) + 1,
                        dp(i - 1, j - 1) + 1
                    )
                )
            }
            n[i][j]
        }
    }

    val dp = dp(word1.length - 1, word2.length - 1)
    println()
    return dp
}

fun main() {
    println(minDistance("horse", "ros"))
}
