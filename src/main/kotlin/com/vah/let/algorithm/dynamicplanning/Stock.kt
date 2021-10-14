package com.vah.let.algorithm.dynamicplanning;

/**
 *@Description 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *@Author HuangJiang
 **/
class Stock {
}

/**
 * 动态规划
 * 用一个二维数组 dp[i][0]表示第i+1天没有持有股票时的利润，有两种情况 一 当天没有买卖股票，那么dp[i][0] = dp[i-1][0](因为当天没操作，所以等于前一天的)
 * 二 如果当天卖出 dp[i][0] = dp[i-1][1] + prices[i](前一天持有的的利润 + 当天的价格)，那么当天没有持有的价格就是两者中大的那一个
 * 用dp[i][1]表示第i+1天持有股票的利润，同样的 一种是没有进行买卖，那么dp[i][1] = dp[i-1][1],如果买入 dp[i][1] = -prices[i]
 * 推导出以下公式
 *  dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
dp[i][1] = Math.max(dp[i - 1][1], -prices[i])

确定边界 dp[0][0] = 0  dp[0][1] = -prices[0]
 */
fun maxProfit(prices: IntArray): Int {
    val dp = Array(prices.size) { IntArray(2) }
    dp[0][0] = 0
    dp[0][1] = -prices[0]

    for (i in 1 until prices.size) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
        dp[i][1] = Math.max(dp[i - 1][1], -prices[i])
    }
    return dp[prices.size - 1][0]
}

/**
 * 上面的可以发现
 * dp[i][0] 和 dp[i][1] 最多只依赖前一次的数据
 * 二维数组是多余的  可以用变量代替
 */
fun maxProfit2(prices: IntArray): Int {
    var preHold = -prices[0]
    var preNoHold = 0
    for (i in 1 until prices.size) {
        preNoHold = Math.max(preNoHold, preHold + prices[i])
        preHold = Math.max(preHold, -prices[i])
    }
    return preNoHold // 最后没有持有股票（卖出）利润最大
}

/**
 * 双指针
 * 一个指针 minPrice表示访问过的最小的值
 * 另外一个 一直往后走
 * 比较差值 一直取最大的那个
 */
fun maxProfit3(prices: IntArray): Int {
    if (prices.isEmpty()) {
        return 0
    }
    var minPrice = prices[0]
    var maxPro = 0
    for (price in prices) {
        minPrice = Math.min(minPrice, price)
        maxPro = Math.max(maxPro, price - minPrice)
    }
    return maxPro
}
