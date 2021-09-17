package com.vah.let.algorithm.sort;

/**
 *@Description 插入排序
 *
 *@Author HuangJiang
 **/
class InsertSort {
}

fun main() {
    sort(intArrayOf(9,3,4,2,0,6,5))

}

fun sort(arr: IntArray) {
    for (i in 1 until arr.size) {
        // 从第二个元素开始向前插入
        val insertV = arr[i]
        var insertIndex = i - 1
        while (insertIndex >= 0 && insertV < arr[insertIndex]) {
            // 将前面的元素依次往后面移动
            arr[insertIndex + 1] = arr[insertIndex]
            insertIndex--
        }
        arr[insertIndex + 1] = insertV
    }
    arr.forEach { print(it) }
}


