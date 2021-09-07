package com.vah.let.algorithm.math;

/**
 *@Description
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0
 *@Author HuangJiang
 **/
class IntRevert {

}

fun main() {
    println(reverse(-1000))
}

// 转成字符串反转
fun reverse(x: Int): Int {
    var a = x >= 0
    var s = x.toString()
    if (!a)
        s = s.removeRange(0, 1)
    val reversed = s.reversed()
    val long = reversed.toLong()
    if (long > Int.MAX_VALUE || long < Int.MIN_VALUE)
        return 0
    return if (a) {
        long.toInt()
    } else {
        -long.toInt()
    }
}

// 直接数字反转
fun revers2(x: Int): Int {
    var x = x
    var res = 0L
    while (x != 0) {
        res = res * 10 + x % 10
        x /= 10
    }
    return if (res > res.toInt() || res < res.toInt()) 0 else res.toInt()
}
