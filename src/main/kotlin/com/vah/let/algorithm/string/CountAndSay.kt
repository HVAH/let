package com.vah.let.algorithm.string;

/**
 *@Description 输出n的外观数列
 *@Author HuangJiang
 **/
class CountAndSay {
}

fun main() {
    val countAndSay = countAndSay(5)
    println(countAndSay)
}

fun countAndSay(n: Int): String {
    if (n == 1) {
        return "1"
    }
    val s = countAndSay(n - 1)
    var r = ""
    var key = s[0]
    var count = 0
    for (i in s.indices) {
        if (s[i] == key) {
            count++
        } else {
            r += count.toString() + key
            key = s[i]
            count = 1
        }
    }
    r += count.toString() + key
    println(s)
    return r
}
