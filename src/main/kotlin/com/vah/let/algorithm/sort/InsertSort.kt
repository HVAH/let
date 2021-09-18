package com.vah.let.algorithm.sort;

/**
 *@Description 插入排序
 *
 *@Author HuangJiang
 **/
class InsertSort {
}

fun main() {
    sort(intArrayOf(8, 9, 1, 7, 2, 3, 5, 4, 6, 0))

}

private fun sort(arr: IntArray) {
    var count = 0
    for (i in 1 until arr.size) {
        // 从第二个元素开始向前插入
        val insertV = arr[i]
        var insertIndex = i
        while (insertIndex - 1 >= 0 && insertV < arr[insertIndex - 1]) {
            // 将前面的元素依次往后面移动
            arr[insertIndex] = arr[insertIndex - 1]
            insertIndex--
            count++
        }
        arr[insertIndex] = insertV
    }
    arr.forEach { print(it) }
    println()
    println(count)
}


