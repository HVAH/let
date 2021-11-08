package com.vah.let.algorithm.sort;

import java.util.PriorityQueue

/**
 *@Description top k
 *@Author HuangJiang
 **/
class TopK {
}

fun main() {
    val arr = IntArray(100000)
    val random = java.util.Random()
    for (i in 0..99999) {
        arr[i] = random.nextInt(99999)
    }
    val topK = topK(arr.copyOf(), 10)
    topK.sort()
    topK.forEach { print("$it,") }

    val quickSearch = quickSearch(arr.copyOf(), 0, arr.size - 1, 10)
    println()
    quickSearch?.sort()
    quickSearch?.forEach { print("$it,") }
    println()
}

/**
 * 使用小顶堆
 */
fun topK(array: IntArray, k: Int): IntArray {
    val queue = PriorityQueue<Int>(k)
    for (i in 0 until k) {
        queue.add(array[i])
    }
    for (i in k until array.size)  {
        if (array[i] > queue.peek()) {
            queue.poll()
            queue.add(array[i])
        }
    }
    return queue.toIntArray()
}

fun getLeastNumbers(arr: IntArray, k: Int): IntArray? {
    return if (k == 0 || arr.isEmpty()) {
        IntArray(0)
    } else quickSearch(arr, 0, arr.size - 1, k - 1)
}

private fun quickSearch(nums: IntArray, lo: Int, hi: Int, k: Int): IntArray? {
    val p = partition(nums, lo, hi)
    if (p == nums.size - k -1) {
        return nums.copyOfRange(nums.size - k , nums.size)
    }
    // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
    return if (p > nums.size - k -1) quickSearch(nums, lo, p - 1, k) else quickSearch(nums, p + 1, hi, k)
}

fun quicklySort2(arr: IntArray, l: Int, r: Int) {
    if (l < r) {
        val partition = partition(arr, l, r)
        quicklySort2(arr, l, partition-1)
        quicklySort2(arr, partition + 1, r)
    }
}

// 快排切分
private fun partition(array: IntArray, lo: Int, hi: Int): Int {
    val key = array[lo]
    var high = hi
    var low = lo
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



