package com.vah.let.algorithm.string;

/**
 *@Description
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1
 *@Author HuangJiang
 **/
class FirstUniqueStr {
}

// 利用API  第一个位置和最后一个位置 要是相同就是该位置
fun firstUniqChar(s: String): Int {
    for (i in s.indices) {
        if (s.indexOf(s[i]) == s.lastIndexOf(s[i]))
            return i
    }
    return -1
}

// 利用map计数 第一个为1的
