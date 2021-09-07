package com.vah.let.algorithm.string;

/**
 *@Description  最长回文串 中心扩展法
 *@Author HuangJiang
 **/
fun expand(s: String): String {
    if (s.isBlank() || s.length == 1) return s
    var b = 0
    var end = 0
    for (i in s.indices) {
        val len1 = expandLength(s, i, i)
        val len2 = expandLength(s, i, i + 1)
        val len = len1.coerceAtLeast(len2)
        if (len > end - b) {
            b = i - (len - 1) / 2
            end = i + len / 2
        }
        println("i=$i len1=$len1 len2=$len2 b=$b end=$end")
    }
    return s.substring(b, end + 1)
}

/**
 * 扩展长度
 */
fun expandLength(s: String, l: Int, r: Int): Int {
    var ll = l
    var rr = r
    while (true) {
        if (ll >= 0 && rr < s.length && s[ll] == s[rr]) {
            ll--
            rr++
        } else {
            return rr - ll - 1
        }
    }
}

/**
 *@Description  验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串
 *@Author HuangJiang
 **/
fun isPalindrome(s: String): Boolean {
    val s = s.replace(Regex("[^a-zA-Z0-9]"), "").toLowerCase()
    if (s.length == 1 || s.isBlank()) {
        return true
    }
    for (i in 0 until s.length / 2) {
        if (s[i] != s[s.length - i -1])
            return false
    }
    return true
}

fun main() {
    println(expand("aaaaaa"))
}
