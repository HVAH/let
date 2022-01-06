package com.vah.let.algorithm.array;

/**
 *@Description 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *@Author HuangJiang
 **/
object MinArray {
    fun minArray(numbers: IntArray): Int {
        var t = numbers[0]
        for (i in 1 until numbers.size) {
            if (t > numbers[i]) {
                return numbers[i]
            } else {
                t = numbers[i]
            }
        }
        return numbers[0]
    }

    fun minArray2(nums: IntArray): Int {
        if (nums[0] < nums[nums.size - 1]) {
            return nums[0]
        }
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            var m = (l + r) / 2
            // 存在 nums[l] >= nums[r]
            if (nums[m] < nums[r]) {
                // nums[m] 在右  x 在[l,m]
                r = m
            } else if (nums[m] > nums[r]) {
                // nums[m]在左 x 在[m +1,r]
                l = m + 1
            } else {
                // 无法判断在左在右
                r--
            }
        }
        return nums[l]
    }
}

fun main() {
    MinArray.minArray2(intArrayOf(3, 1, 3))
}
