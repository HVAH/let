package com.vah.let.algorithm.array

/**
 * 找出两个数组的交集
 *
 */

// 1 利用set 将其中一个转成set

// 2 利用map

// 3 先排序 然后比较  相同的加入结果集
fun id(arr1: IntArray, arr2: IntArray): IntArray {
    arr1.sort()
    arr2.sort()

    var index1 = 0
    var index2 = 0
    val result = mutableListOf<Int>()
    while (index1 < arr1.size && index2 < arr2.size) {
        if (arr1[index1] == arr2[index2]) {
            result.add(arr1[index1])
            index1++
            index2++
        } else if (arr1[index1] < arr2[index2]) {
            index1++
        } else {
            index2++
        }
    }
    return result.toIntArray()
}
