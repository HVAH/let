package com.vah.let.algorithm.greed;

/**
 *@Description 电台覆盖问题 每个电台可以覆盖不同的区域 要求用最少的电台覆盖所有的地区
 *@Author HuangJiang
 **/
class BroadcastingStation {

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

    fun indexOf(str: String, str2: String): Int {
        if (str2.length == 0) {
            return -0
        }
        var i = 0
        var j = 0
        val next = next(str2)
        while (i < str.length && j < str2.length) {
            if (j == -1 || str[i] == str2[j]) {
                i++
                j++
            } else {
                j = next[j]
            }
            if (j == str2.length) {
                return i - j
            }
        }
        return -1
    }
}

fun main() {
    val broadcasts = mutableMapOf<String, MutableSet<String>>()
    val set1 = mutableSetOf("北京", "上海", "天津")
    val set2 = mutableSetOf("广州", "北京", "深圳")
    val set3 = mutableSetOf("成都", "上海", "杭州")
    val set4 = mutableSetOf("天津", "上海")
    val set5 = mutableSetOf("杭州", "大连")
    broadcasts["k1"] = set1
    broadcasts["k2"] = set2
    broadcasts["k3"] = set3
    broadcasts["k4"] = set4
    broadcasts["k5"] = set5

    val allLocations = broadcasts.flatMap { it.value }.toSet().toMutableSet()
    val r = mutableSetOf<String>()
    while (allLocations.isNotEmpty()) {
        var maxK = ""
        var maxN = 0
        for ((key, value) in broadcasts) {
            val intersect = allLocations.intersect(value)
            if (intersect.size > maxN) {
                maxN = intersect.size
                maxK = key
            }
        }
        r.add(maxK)
        allLocations.removeAll(allLocations.intersect(broadcasts[maxK]!!))
    }

    println(r.toString())
}


