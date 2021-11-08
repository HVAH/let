package com.vah.let.algorithm.sort;

/**
 *@Description 快速排序
 *@Author HuangJiang
 **/
class QuicklySort {
}

fun main() {
    val arr = intArrayOf(8, 9, 1, 7, 2, 3, 5, 4, 6, 0)
    quicklySort(arr, 0, arr.size - 1)
    arr.forEach { print("$it,") }
}

fun quicklySort(array: IntArray, low: Int, high: Int) {
    if (low < high) {
        val p = getPartion(array, low, high)
        quicklySort(array, low, p - 1)
        quicklySort(array, p + 1, high)
    }
}

fun getPartion(array: IntArray, low: Int, high: Int): Int {
    val key = array[low]
    var high = high
    var low = low
    while (low < high) {
        while (low < high && array[high] >= key) {
            high--
        }
        array[low] = array[high]
        while (low < high && array[low] < key) {
            low++
        }
        array[high] = array[low]
    }
    array[low] = key
    return high
}
