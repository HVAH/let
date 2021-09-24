package com.vah.let.algorithm.sort;

/**
 *@Description 基数排序
 *@Author HuangJiang
 **/
class RadixSort {
}

fun main() {
    val arr = intArrayOf(899, 9, 1, 7, 2, 344, 5, 4, 6, 0)
    radixSort(arr)
    println()
}

fun radixSort(arr: IntArray) {
    val bucket = Array<IntArray>(10) { IntArray(arr.size) }
    var k = 1
    while (true) {
        val aSize = IntArray(10)
        var f = true
        for (i in arr.indices) {
            val w = if (arr[i] == 0) 0  else  arr[i] / k % 10
            bucket[w][aSize[w]++] = arr[i]
            f = f && w==0
        }
        if (f) {
            break
        }
        var index = 0
        for (i in aSize.indices) {
            for (j in 0 until aSize[i]) {
                arr[index++] = bucket[i][j]
            }
        }
        k *= 10
    }
}
