package com.vah.let.algorithm.string;

import java.util.Arrays
import java.util.TreeSet

/**
 *@Description 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *@Author HuangJiang
 **/
class LettersOfEctopic {
}

// 利用API排序比较
fun isAnagram(s: String, t: String): Boolean {
    val length = s.length
    if (length != t.length) return false
    val l1 = s.toList().sorted()
    val l2 = t.toList().sorted()
    for (i in s.indices) {
        if (l1[i] != l2[i] || l1[length - i -1] != l2[length - i -1])
            return false
    }
    return true
}

// 利用两个map计数然后比较
fun isAnagram2(s: String, t: String): Boolean {
    return true
}

// 先统计 s 的数量 再减去 t 的字符的数量 如果全为0 就是字母异位词
fun isAnagram3(s: String, t: String): Boolean {
    // 26 字母
    val charCount = IntArray(26)
    for (i in s.indices) {
        charCount[s[i] - 'a']++
    }
    for (i in t.indices) {
        if (charCount[t[i] - 'a'] == 0)
            return false
        charCount[t[i] - 'a']--
    }

    return charCount.sum() == 0
}

//
fun isAnagram4(s: String, t: String): Boolean {
    val length = s.length
    if (length != t.length) return false
    val charCount = IntArray(26)
    var count = 0
    for (i in 0 until length) {
        // 出现新的字母 +1
        if (++charCount[s[i] - 'a'] == 1)
            count++
        // 消失一个字母 -1
        if (--charCount[t[i] - 'a'] == 0)
            count--
    }
    return count == 0
}

fun main() {
    isAnagram4("aabbcc", "ccaabb")
}
