package com.vah.let.algorithm.dynamicplanning;

/**
 *@Description 背包问题
 *@Author HuangJiang
 **/
class Knapsack {
}

fun main() {
    // 物品重量
    val w = intArrayOf(1, 4, 3)
    // 物品价值
    val value = intArrayOf(1500, 3000, 2000)
    // 背包容量
    val m = 8
    // 物品个数
    val n = value.size

    val v = Array(n + 1) { IntArray(m + 1) }

    // 第一行和第一列为0
    for (i in v.indices) {
        v[i][0] = 0
    }
    for (i in v[0].indices) {
        v[0][i] = 0
    }

    val l = Array(n + 1) { IntArray(m + 1) }

    for (i in 1 until v.size) {
        for (j in 1 until v[0].size) {
            if (w[i - 1] > j) { // 第i个物品的重量比当前容量大
                // 等于上面一个单元格放的
                v[i][j] = v[i - 1][j]
            } else {
                // 如果
                if (v[i - 1][j] < value[i - 1] + v[i - 1][j - w[i - 1]]) { // 记录最优解
                    l[i][j] = 1
                }

                // value[i - 1] + v[i - 1][j - w[i - 1]] 表示当前物品价值 加上 （放上一个物品时 在当前容量减去当前物品重量的剩余容量能放下的物品的最大的价值）
                v[i][j] = Math.max(v[i - 1][j], value[i - 1] + v[i - 1][j - w[i - 1]])
            }
        }
    }

    var i = l.size - 1
    var j = l[0].size - 1
    while (i > 0 && j > 0) {
        if (l[i][j] == 1) {
            println("将第${i}个物品放入背包")
            j -= w[i - 1]
        }
        i--
    }
}
