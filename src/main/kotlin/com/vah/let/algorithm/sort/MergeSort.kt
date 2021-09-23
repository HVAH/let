package com.vah.let.algorithm.sort;

/**
 *@Description  归并排序
 *@Author HuangJiang
 **/
class MergeSort {

}

fun main() {
    val arr = intArrayOf(8, 9, 1, 7, 2, 3, 5, 4, 6, 0)

    mergeSort(arr, 0 ,arr.size - 1, IntArray(arr.size))
    println()
}

fun mergeSort(arr: IntArray, left: Int, right: Int, tempArr: IntArray) {
    if( left < right) {
        val m = (left + right) / 2
        mergeSort(arr, left, m, tempArr)
        mergeSort(arr, m + 1, right, tempArr)

        var j = m + 1
        var i = left
        var index = 0
        while (i <= m && j <= right) {
            if (arr[i] < arr[j]) {
                tempArr[index++] = arr[i++]
            } else {
                tempArr[index++] = arr[j++]
            }
        }
        while (i <= m) {
            tempArr[index++] = arr[i++]
        }
        while (j <= right) {
            tempArr[index++] = arr[j++]
        }

        var tLeft = left
        var t = 0
        while (tLeft <= right) {
            arr[tLeft++] = tempArr[t++]
        }
    }
}
