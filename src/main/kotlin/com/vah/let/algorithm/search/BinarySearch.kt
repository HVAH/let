package com.vah.let.algorithm.search;

/**
 *@Description 二分查找
 *@Author HuangJiang
 **/
class BinarySearch {
}

/**
 * 递归写法
 */
fun s1(target: Int, arr: IntArray, l: Int, r: Int): Int? {
    if (l == r) {
        if (arr[l] == target) {
            return target
        }
        return null
    }
    val m = (l + r) / 2
    return if (target == arr[m]) {
        target
    } else if (target > arr[m]) {
        s1(target, arr, m + 1, r)
    } else {
        s1(target, arr, l, m)
    }
}

fun s2(target: Int, arr: IntArray): Int? {
    var l = 0
    var r = arr.size - 1
    var m = (l + r) / 2

    while (l < r) {
        if (arr[m] == target) {
            return target
        } else if (target > arr[m]) {
            l = m + 1
            m = (l + r) / 2
        } else {
            r = m
            m = (l + r) / 2
        }
    }

    if (l >= arr.size || r < 0) {
        return null
    }
    if (arr[l] == target) {
        return target
    }
    return null
}

fun main() {
    val target = -1
    val arr = intArrayOf(1, 2, 4, 5, 6, 7, 8, 9, 10)
    val i = s1(target, arr, 0, arr.size - 1)
    println("递归模式找到->${i}")
    println("循环模式找到->${s2(target, arr)}")
}
