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
    var firstIndex = -1
    var lastIndex = 0
    var isFu = 0
    for (i in str.indices) {

        val c = str[i]
        if (c in '0'..'9') {
            if (firstIndex == -1) {
                if (i != 0 && str[i-1] == '-') {
                    isFu = -1
                }
                firstIndex = i
            }
            lastIndex = i
        } else if (c == '+' || c == '-') {
            if (firstIndex != -1) {
                break
            }
            if (i == str.length - 1) {
                return 0
            }
            if (i != str.length - 1 && (str[i + 1] < '0' || str[i +1] > '9')) {
                return 0
            }
        } else {
            if (firstIndex == -1 && (c != '+' ||  c != '-')) {
                return 0
            }
            if (firstIndex != -1) {
                break
            }
        }
    }
    var toLong = str.substring(firstIndex + isFu, lastIndex + 1).toBigInteger()
    if (toLong < Int.MIN_VALUE.toBigInteger()) {
       return Int.MIN_VALUE
    }
    if (toLong > Int.MAX_VALUE.toBigInteger()) {
        return Int.MAX_VALUE
    }
    return toLong.toInt()
}

fun main() {
    println(myAtoi("-5-"))
}
