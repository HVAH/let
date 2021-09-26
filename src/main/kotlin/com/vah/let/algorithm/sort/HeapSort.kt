package com.vah.let.algorithm.sort;

/**
 *@Description 堆排序
 *@Author HuangJiang
 **/
class HeapSort {
}

fun main() {
    val arr = intArrayOf(4,6,8,5,9)
    heapSort(arr)
    println()
}

fun heapSort(arr: IntArray) {
    //1 构建大顶堆(一种完全二叉树 父节点大于等于其左右节点)
    for (i in arr.size / 2 - 1 downTo  0 ) {
        transformHeap(arr, i, arr.size)
    }
    //2 调整交换
    for (i in arr.size - 1 downTo  1) {
        val t = arr[i]
        arr[i] = arr[0]
        arr[0] = t
        transformHeap(arr, 0, i)
    }
}

/**
 * 功能描述: 转换堆
 * @Param: arr 数组
 * @Param: i 非叶子节点在数组中的索引
 * @Param: length 需要调整的数组的长度
 * @Return:
 */
fun transformHeap(arr: IntArray, i: Int, length: Int) {
    val t = arr[i]
    var i = i
    var k = i * 2 + 1
    while (k < length) {
        if (k + 1 < length && arr[k] < arr[k + 1]) { // 右节点大  就变成右节点
            k++
        }
        if (arr[k] > t) {
            arr[i] = arr[k]
            i = k
        } else { // 从下至上所以可以直接退出
            break
        }
        k = k * 2 + 1 // 继续左节点
    }
    arr[i] = t
}
