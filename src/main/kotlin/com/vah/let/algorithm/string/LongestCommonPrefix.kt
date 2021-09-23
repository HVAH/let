package com.vah.let.algorithm.string;

import com.sun.xml.internal.fastinfoset.util.StringArray

/**
 *@Description 字符串数组的最大公共前缀
 *@Author HuangJiang
 **/
class LongestCommonPrefix {
}

fun main() {
    println(longestCommonPrefix(arrayOf("flower","fl","flight")))
}

fun longestCommonPrefix(strs: Array<String>): String {
    var r = ""
    loop1@for (i in strs[0].indices) {
        val key = strs[0][i]
        for (j in 1 until strs.size) {
            if (i > strs[j].length - 1 ||  strs[j][i] != key) {
                break@loop1
            }
        }
        r += key
    }
    return r
}
