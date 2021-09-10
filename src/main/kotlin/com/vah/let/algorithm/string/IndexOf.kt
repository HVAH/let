package com.vah.let.algorithm.string;

/**
 *@Description 实现string的indexOf()
 *@Author HuangJiang
 **/
class IndexOf {
}

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
                if (haystack[j + i] != needle[j] || needle[length - j - 1] != haystack[i + (length - j - 1)]) {
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

fun main() {
    println(
        indexOf(
            "mississippi",
            "issip"
        )
    )
}
