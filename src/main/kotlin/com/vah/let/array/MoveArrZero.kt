package com.vah.let.array

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * */
// 1,2,0,4,0,6
// 1 2 4 6 0 0
fun moveZero(arr: IntArray) {
    var i = 0
    val size = arr.size
    var count = arr.count { it == 0 }
    while(i < size) {
        if (arr[i] == 0) {
            if ( count >0) {
                for (j in i until arr.size - 1) {
                    val temp = arr[j]

                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
                i--
                count --
            }
        }
        i++
    }
    arr.forEach { print(it) }
}
fun main() {
    moveZero(intArrayOf(1,2,0,4,0,6))
}

// 双指针 非零的往前移动  最后补零
fun move2(arr: IntArray) {
    var index = 0
    for(i in arr.indices) {
        if (arr[i] != 0) {
            arr[index++] = arr[i]
        }
    }
    for (i in index until arr.size) {
        arr[i] = 0
    }
}
