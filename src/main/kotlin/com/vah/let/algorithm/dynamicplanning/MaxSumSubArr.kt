package com.vah.let.algorithm.dynamicplanning;

/**
 *@Description 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 *@Author HuangJiang
 **/
class MaxSumSubArr {

}


fun maxSubArray(nums: IntArray): Int {
    val dp = IntArray(nums.size)
    // 初始状态
    dp[0] = nums[0]

    for (i in 1 until nums.size) {
        // 如果dp[i-1] < 0 舍弃 因为会导致dp[i]变的更小
        dp[i] = Math.max(0, dp[i - 1] )+ nums[i]
    }

    return dp.max()!!
}

fun maxSubArray2(nums: IntArray): Int {
    var tMax = nums[0]
    var rMax = tMax
    for (i in 1 until nums.size) {
        tMax = Math.max(0,tMax) + nums[i]
        rMax = Math.max(rMax, tMax)
    }
    return rMax
}

fun main() {
    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
}
