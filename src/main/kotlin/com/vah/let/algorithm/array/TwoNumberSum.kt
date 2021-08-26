package com.vah.let.algorithm.array

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
 * 并返回它们的数组下标
 *
 * */

// 1 先排序  遍历元素 再利用二分查找 target - arr[i]    O(n*logn)

// 2 利用map存储每个元素对应的index，再遍历数组 找出target - arr[i]

fun sum(arr: IntArray, target: Int): IntArray {
    val result = IntArray(2)

    val map = mutableMapOf<Int, Int>()
    for (i in arr.indices) {
        map[arr[i]] = i
    }
    for (i in arr.indices) {
        val key = target - arr[i]
        val i1 = map[key] ?: continue
        if (map.containsKey(key) && i != i1) {
            result[0] = i
            result[1] = i1
            break
        }
    }
    return result
}

fun main() {
    sum(intArrayOf(2,5,5,11), 10).forEach { print(it) }
}
