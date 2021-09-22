package com.vah.let.algorithm.sort;

import com.vah.let.algorithm.recursion.countQ

/**
 *@Description 希尔排序
 *@Author HuangJiang
 **/
class ShellSort {
}

fun main() {
    shellSort(intArrayOf(8, 9, 1, 7, 2, 3, 5, 4, 6, 0))
    shellSort2(intArrayOf(8, 9, 1, 7, 2, 3, 5, 4, 6, 0))
    s3(intArrayOf(8, 9, 1, 7, 2, 3, 5, 4, 6, 0))
    println()
    println(nQ(9))
}

fun shellSort(arr: IntArray) {
    var count = 0
    var g = arr.size / 2
    while (g > 0) {
        for (i in 0 until g) { // 这里g 表是分了多少组
            for (j in i + g until arr.size step g) {  // 这里g 表示步长  j表示这个分组里的每个元素  i+g表示从改组的第二个元素开始
                // 将每组元素进行插入排序
                val insertV = arr[j]
                var insertIndex = j - g
                while (insertIndex >= 0 && insertV < arr[insertIndex]) {
                    // 将前面的元素依次往后面移动
                    arr[insertIndex + g] = arr[insertIndex]
                    insertIndex -= g
                    count++
                }
                arr[insertIndex + g] = insertV
            }
        }
        arr.forEach { print(it) }
        println()
        g /= 2
    }
    println(count)
}
// 优化
fun shellSort2(arr: IntArray) {
    var count = 0
    var g = arr.size / 2
    while (g > 0) {
        for (i in g until arr.size) {
            var j = i
            val t = arr[j]
            while (j - g >= 0 && t < arr[j - g]) {
                arr[j] = arr[j - g]
                j -= g
                count++
            }
            arr[j] = t
        }

        g /= 2
    }
    arr.forEach { print(it) }
    println()
    println(count)
}


fun s3(arr: IntArray) {
    var g = arr.size /2
    while (g > 0) {
        for (i in g until arr.size) {
            var j = i
            val t = arr[j]
            while (j - g >= 0 && t < arr[j- g]) {
                arr[j] = arr[j - g]
                j -= g
            }
            arr[j] = t
        }
        g /= 2
    }
    arr.forEach { print(it) }
}


fun nQ(n: Int): Int {
    return nQ(n, 0, mutableListOf(), mutableListOf(), mutableListOf())
}

fun nQ(n: Int, row:Int, lineList: MutableList<Int>, xie1List: MutableList<Int>, xie2List: MutableList<Int>): Int{
    if (n == row) {
        // 完成一种解法
        return 1
    }
        var count = 0
    for (i in 0 until n) {
        if (lineList.contains(i)) {
            continue
        }
        val xie1 = row - i
        if (xie1List.contains(xie1)) {
            continue
        }
        val xie2 = row + i
        if (xie2List.contains(xie2)) {
            continue
        }
        lineList.add(i)
        xie1List.add(xie1)
        xie2List.add(xie2)
        count += nQ(n, row + 1, lineList, xie1List, xie2List)
        lineList.remove(i)
        xie1List.remove(xie1)
        xie2List.remove(xie2)
    }
    return count
}
