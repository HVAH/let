package com.vah.let.algorithm.sort;

/**
 *@Description 选择排序
 * 每一次外循环 最小的再最前面
 *@Author HuangJiang
 **/
class SelectSort {
}

fun main() {
    select(intArrayOf(9,3,4,2,0,6,5))
}

fun select(arr: IntArray) {
    for (i in arr.indices) {
        for (j in i + 1 until arr.size) {
            if (arr[i] > arr[j]) {
                val t = arr[i]
                arr[i] = arr[j]
                arr[j] = t
            }
        }
        arr.forEach { print(it) }
        println()
    }
}
