package com.vah.let.algorithm.greed;

/**
 *@Description 电台覆盖问题 每个电台可以覆盖不同的区域 要求用最少的电台覆盖所有的地区
 *@Author HuangJiang
 **/
class BroadcastingStation {
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
