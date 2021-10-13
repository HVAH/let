package com.vah.let.algorithm.greed;

/**
 *@Description
 * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。

示例 1：

输入：cards = [1,2,8,9], cnt = 3

输出：18

解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。

示例 2：

输入：cards = [3,3,1], cnt = 1

输出：0

解释：不存在获取有效得分的卡牌方案。

提示：

1 <= cnt <= cards.length <= 10^5
1 <= cards[i] <= 1000

 *@Author HuangJiang
 **/
class MaxmiumScore {
    fun maxmiumScore(cards: IntArray, cnt: Int): Int {
        cards.sortDescending()
        var lastOdd = 0
        var lastEven = 0
        var res = 0
        for (i in 0 until cnt) {
            res += cards[i]
            if (cards[i] and 1 ==0) {
                lastEven = cards[i]
            } else {
                lastOdd = cards[i]
            }
        }
        if (res and 1 == 0) {
            return res
        }

        var max1 = 0
        var max2 = 0

        for (i in cnt until cards.size) {
            if (lastOdd != 0 && max1 == 0 && cards[i] and 1 == 0) {
                max1 = res - lastOdd + cards[i]
            }
            if (lastEven != 0 && max2 == 0 && cards[i] and 1 != 0) {
                max2 = res - lastEven + cards[i]
            }
        }
        return Math.max(max1, max2)
    }
}

fun maxmiumScore(cards: IntArray, cnt: Int): Int {
    var res = 0
    cards.sortDescending()
    var lastOdd = 0 // 最后一个奇数
    var lastEven = 0 // 最后一个偶数
    for (i in 0 until cnt) {
        res+=cards[i]
        if (cards[i] and 1 == 0) {
            lastEven = cards[i]
        } else {
            lastOdd = cards[i]
        }
    }
    // 如果前面的加起来刚好是偶数直接返回
    if (res and 1 == 0) {
        return res
    }
    // 不是偶数  那就找前面的最小的一个数尝试替换成后面最大的一个数
    var max1 = 0
    var max2 = 0
    for (i in cnt until cards.size)  {

        // 最后是偶数 那就得加上一个奇数
        if (lastEven != 0 && cards[i] and 1 != 0 && max2 == 0) {
            max2 = res - lastEven + cards[i]
        }
        if (lastOdd != 0 && cards[i] and 1 == 0 && max1 == 0) {
            max1 = res - lastOdd + cards[i]
        }

    }
    return Math.max(max1, max2)
}

fun main() {
    maxmiumScore(intArrayOf(1,2,8,9), 3)
}
