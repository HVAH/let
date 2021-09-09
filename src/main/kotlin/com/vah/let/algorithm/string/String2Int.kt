package com.vah.let.algorithm.string;

/**
 *@Description 字符串转整数
 *@Author HuangJiang
 **/
class String2Int {
}

fun myAtoi(s: String): Int {
    if (s.isBlank()) return 0
    val str = s.trim()
    var firstIndex = 0
    var lastIndex = 0
    var isFu = 0
    val c1 = str[0]
    if (c1 == '-') {
        isFu = -1
        firstIndex = 1
    } else if (c1 == '+') {
        firstIndex = 1
    } else if ( c1 > '9' || c1 < '0') {
        return 0
    }
    var firstNumIndex = 0
    for (i in str.indices) {

        val c = str[i]
        if (c in '0'..'9') {
            if (firstIndex == 0) {
                firstIndex = i
            }
        } else if (c == '+' || c == '-') {

        }
        lastIndex = i
    }
    var toLong = str.substring(firstIndex + isFu, lastIndex + 1).toLong()
    if (toLong < Int.MIN_VALUE) {
       return Int.MIN_VALUE
    }
    if (toLong > Int.MAX_VALUE) {
        return Int.MAX_VALUE
    }
    return toLong.toInt()
}

fun main() {
    println(myAtoi("+-12"))
}
