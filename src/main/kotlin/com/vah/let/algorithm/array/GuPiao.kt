package com.vah.let.algorithm.array;

/**
 *@Description
 * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票
 *@Author HuangJiang
 **/
class GuPiao {
}

fun main() {
//    println(moveArray2(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3))
}

// [2,3,5,1,6]
/**
 * * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票
 */
fun maxSell(prices: IntArray): Int {
    val size = prices.size
    var i = 0
    var max = 0
    while (i + 1 < size) {
        if (prices[i] < prices[i + 1]) {
            println("在 ${i + 1} 天以 ${prices[i]} 元买入")
            println("在 ${i + 2} 天以 ${prices[i + 1]} 元卖出")

            max += prices[i + 1] - prices[i]
        }
        i++
    }


    return max
}

