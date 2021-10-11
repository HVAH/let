package com.vah.let.algorithm.string;

/**
 *@Description 实现string的indexOf()
 *@Author HuangJiang
 **/
class IndexOf {
}

/**
 * 暴力匹配
 */
fun indexOf(haystack: String, needle: String): Int {
    val length = needle.length
    val length1 = haystack.length
    if (length > length1)
        return -1

    if (needle == haystack)
        return 0

    if (needle.isEmpty()) {
        return 0
    }

    if (length == length1 && needle != haystack) {
        return -1
    }

    val c = needle[0]
    var contain = true
    for (i in haystack.indices) {
        if (c == haystack[i]) { // 第一个字母相同则开始比较 后面的
            if (length1 - i < length) {
                return -1
            }
            for (j in 0 until length / 2) {
                if (needle[j] != haystack[j + i] || needle[length - j - 1] != haystack[(length - j - 1) + i]) {
                    contain = false
                    break
                }
            }
            if (!contain) {
                contain = true
                continue
            }
            return i
        }
    }
    return -1
}

fun kmpIndexOf(haystack: String, needle: String): Int {
    if (haystack == needle || needle.isEmpty()) {
        return 0
    }
    var j = 0
    val next = getNext(needle)
    for (i in haystack.indices) {
        while (j > 0 && haystack[i] != needle[j]) {
            j = next[j - 1]
        }
        if (haystack[i] == needle[j]) {
            j++
        }
        if (j == needle.length) {
            return i - j + 1
        }
    }
    return -1
}

// 获取一个字符串的部分匹配值
fun getNext(str: String): IntArray {
    val r = IntArray(str.length)
    r[0] = 0

    var j = 0
    for (i in 1 until str.length) {
        while (j > 0 && str[i] != str[j]) {
            j = r[j - 1]
        }
        if (str[i] == str[j]) {
            j++
        }
        r[i] = j
    }
    return r
}

fun next(str: String): IntArray {
    var i = 0
    var j = -1
    val next = IntArray(str.length)
    next[0] = -1
    while (i < str.length - 1) {
        if (j == -1 || str[i] == str[j]) {
            next[++i] = ++j
        } else {
            j = next[j]
        }
    }
    return next
}

fun strStr(haystack: String, needle: String): Int {
    if (needle.length == 0) return 0
    var i = 0
    var j = 0
    val next = next(needle)
    while (i < haystack.length && j < needle.length) {
        if (j == -1 || haystack[i] == needle[j]) {
            i++
            j++
        } else {
            j = next[j]
        }
        if (j == needle.length) {
            return i - j
        }
    }
    return -1
}

fun main() {
//    val next = getNext("abcdabd")
//    next.forEach { print(it) }
//    val next2 = getNext2("abcdabd")
//    println()
//    next2.forEach { print(it) }

//    println(kmpIndexOf("abc abcd abcdabcdabdcf", "abcdabd"))

    next("abac").forEach { print(it) }
}
