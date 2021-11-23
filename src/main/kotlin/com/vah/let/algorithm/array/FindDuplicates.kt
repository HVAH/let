package com.vah.let.algorithm.array;

/**
 *@Description 找出数组中任何一个重复的值 每个元素满足 0<= arr[i] <arr.length
 *@Author HuangJiang
 **/
class FindDuplicates {
}

/**
 * 下标跟值是一对多关系，建立下标与值的索引，即 i = arr[i]，
 * 当arr[i] == arr[arr[i]]时 即有重复
 */
fun ad(arr: IntArray): Int {
    var i = 0
    while (i < arr.size) {
        if (i == arr[i]) {
            i++
            continue
        }
        if (arr[i] == arr[arr[i]]) {
            return arr[i]
        } else {
            val t = arr[i]
            arr[i] = arr[t]
            arr[t] = t
        }
    }
    return -1
}
