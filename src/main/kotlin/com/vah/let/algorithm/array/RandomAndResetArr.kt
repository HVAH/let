package com.vah.let.algorithm.array;

import java.util.Random

/**
 *@Description 打乱数组
 *@Author HuangJiang
 **/
class RandomAndResetArr(val nums: IntArray) {

    fun reset(): IntArray {
        return nums
    }

    fun shuffle(): IntArray {
        if (nums.size == 0) return nums
        val clone = nums.clone()
        val size = clone.size
        val random = Random()
        for (i in 1 until size) {
            val index = random.nextInt(i+1)
            val t = clone[i]
            clone[i] = clone[index]
            clone[index] = t
        }
        return clone
    }
}

fun main() {
    val randomAndResetArr = RandomAndResetArr(intArrayOf(1, 2, 3))
    randomAndResetArr.shuffle()
}

