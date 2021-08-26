package com.vah.let.algorithm.array;

/**
 *@Description 判断数组是否有重复元素
 *@Author HuangJiang
 **/

// 1 利用set  使用add方法  返回false时即可停止
// 2 暴力对比 嵌套for循环
// 3 先排序再比较 相同的元素肯定相邻

// 3
fun judge(array: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    array.forEach {
        if (!set.add(it)) {
            return true
        }
    }
    return false
}

/**
 *@Description 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *@Author HuangJiang
 **/

// 1 先排序  相邻两个元素不一致的时候即为目标元素

fun judgeOne(arr: IntArray): Int {
    arr.sort()
    var index = 0
    while (index < arr.size - 2) {
        if (arr[index] != arr[index + 1]) {
            return arr[index]
        }
        index += 2
    }
    // 前面所有的元素不符合 必定为最后一个元素
    return arr[arr.size - 1]
}

// 2 使用两个set  元素交替加入这两个set  最后取两个集合的差集

// 异或运算  一个数与另外一个数异或两次等于自己

fun xor(arr: IntArray): Int {
    var r = arr[0]
    for(i in 1 until arr.size) {
        r = r.xor(arr[i])
    }
    return r
}

fun main() {
    var a = 3
    var b = 4
    println(a.xor(b).xor(b))
}
