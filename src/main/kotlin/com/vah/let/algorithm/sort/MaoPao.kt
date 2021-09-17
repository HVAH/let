package com.vah.let.algorithm.sort;

/**
 *@Description 冒泡排序
 * 每完成一次外循环 最大的数在最后面
 *@Author HuangJiang
 **/
class MaoPao {
}

fun main() {
    maoPao(intArrayOf(9,3,4,2,0,6,5))
}

//
fun maoPao(array: IntArray) {
    var sort = false
    for (i in array.indices) {
        for (j in 1 until array.size - i) {
            if (array[j] < array[j - 1]) {
                sort =true
                val t = array[j]
                array[j] = array[j - 1]
                array[j -1] = t
            }
        }
        if (!sort) {  // 没有发生交换 已经完全有序直接结束
            break
        } else {
            sort = false
        }
        array.forEach { print(it) }
        println()
    }
}
