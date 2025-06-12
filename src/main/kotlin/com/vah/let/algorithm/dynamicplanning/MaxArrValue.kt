package com.vah.let.algorithm.dynamicplanning

/**
 * @Description 最大价值
 * 给定相同长度的数组nums 和 value,每次可以从nums的开头或者结尾拿走一个数n（不能从同一个位置拿），并得到一个值 value = values[i - 1] * n, 其中i表示第几次从nums拿数
 * 将所有数字
 * @Author Jiang
 * @Date 2022/1/11 6:55 下午
 **/
object MaxArrValue {

    fun max(nums: IntArray, values: IntArray) {
        val dp = Array<IntArray>(nums.size) { IntArray(2) }

        dp[0][0] = getValue(1, nums[0], nums, values)
        dp[0][1] = getValue(1, nums[nums.size - 1], nums, values)
        var l = 0
        var r = nums.size - 1
        for (i in 2..nums.size) {
            dp[i - 1][0] = Math.max(dp[i - 2][0], dp[i -2][1]) + getValue(i, nums[i - 1], nums, values)
        }
    }

    fun getValue(i: Int, num: Int, nums: IntArray, values: IntArray): Int {
        return num * values [i - 1]
    }
}
