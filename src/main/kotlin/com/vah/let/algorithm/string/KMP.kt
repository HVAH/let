package com.vah.let.algorithm.string;

/**
 *@Description kmp算法
 *@Author HuangJiang
 **/
class KMP {
}


fun snext(str:String): IntArray {
    var i = 0
    var j = -1
    val next = IntArray(str.length)
    next[0] = -1
    while (i < str.length - 1) {
        if (j == -1 || str[i] == str[j]) {
            next[++i] == ++j
        } else {
            j = next[j]
        }
    }
    return next
}

fun indexOfs(str1: String, str2: String): Int {
    var i = 0
    var j =0
    val next = snext(str2)
    while (i < str1.length && j < str2.length) {
        if (j == -1 || str1[i] == str2[j]) {
            i++
            j++
        } else {
            j = next[j]
        }
        if (j == str2.length) {
            return i - j
        }
    }
    return -1
}
