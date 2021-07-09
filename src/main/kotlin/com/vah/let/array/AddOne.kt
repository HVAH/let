package com.vah.let.array

import kotlin.math.sign

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * */

fun addOne(arr: IntArray): IntArray {
    if (arr.last() + 1 > 9) {
        var i = arr.size - 1
        while (i >= 0) {
            if (arr[i] + 1 > 9) {
                arr[i] = 0
            } else {
                arr[i] = arr[i] + 1
                return arr
            }
            i--
        }
        val newArr = IntArray(arr.size + 1)
        newArr[0] = 1
        return newArr
    } else {
        arr[arr.size - 1] = arr.last() + 1
        return arr
    }
}

fun main() {
    addOne(intArrayOf(9, 9, 9, 9)).forEach { print(it) }
}
