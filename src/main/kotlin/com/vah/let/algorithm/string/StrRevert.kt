package com.vah.let.algorithm.string;

/**
 *@Description 反转字符串
 *@Author HuangJiang
 **/
class StrRevert {
}

// 对称交换（双指针）
fun revert(string: String): String {
    val length = string.length
    val count = length / 2
    val charArray = string.toCharArray()
    for (i in 0 until count) {
        val c = charArray[i]
        charArray[i] = charArray[length - i - 1]
        charArray[length - i - 1] = c
    }
    return String(charArray)
}

fun main() {
    println(revert("abc"))
}
