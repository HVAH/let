package com.vah.let.algorithm.dynamicplanning;

/**
 *@Description
 *
 * 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnq4km/
 *@Author HuangJiang
 **/
class Rob {
}

/**
 * 思路  不能连续偷  但是可以连续不偷
 * 确定转态
 * 如果第[i] 天偷了 那么i+1 一定不能偷
 * 如果[i] 没偷 那么[i+1] 可以选择偷 也可以选择不偷
 * 确定转态转移方程
 * 用sum[i][1] 表示到第i被偷家的最大金额
 * 用sum[i][0] 表示到第i没被偷家的最大金额
 * 有  sum[i][1] = sum[i-1][0] + num[i]
 *     sum[i][0] = max(sum[i-1][0],sum[i-1][1])
 *     res = max(res, sum[i][1],sum[i][0])
 * sum.max 即为能偷的最大金额
 */
fun rob(nums: IntArray): Int {
    val dp = Array(nums.size) { IntArray(2) }
    // 初始状态
    dp[0][0] = 0 // 第一家没偷
    dp[0][1] = nums[0] // 第一家偷了
    var max = 0

    for (i in 1 until nums.size) {
        dp[i][1] = dp[i - 1][0] + nums[i]
        dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0])
        max = Math.max(max, Math.max(dp[i][1], dp[i][0]))
    }

    return max
}

/**
 * 上一个解法中可以发现 第i天的金额只跟前一天两种转态相关，所以可以省略掉数组
 */
fun rob2(nums: IntArray): Int {
    var norob = 0
    var rob = nums[0]

    for (i in 1 until nums.size) {
        val currob = norob + nums[i]
        norob = Math.max(norob, rob)
        rob = currob
    }

    return Math.max(norob, rob)
}



fun main() {
    rob(intArrayOf(2, 7, 9, 3, 1))
}
