package com.vah.let.algorithm.math;

/**
 *@Description 模拟除法 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *@Author HuangJiang
 * https://leetcode-cn.com/problems/xoh6Oh/submissions/
 **/
object Divide {

    /**
     *
     */
    fun divide(a: Int, b: Int): Int {
        if (a == 0) {
            return 0
        }
        var r = 0L
        var  a = a
        var b = b
        var f = false
        if((a >=0 && b > 0) || (a < 0 && b < 0)) {
            f = true
        }
        if(a > 0) {
            a = -a
        }
        if(b >0) {
            b = -b
        }
        while(a <= b) {
            a = a - b
            r++
        }

        if(!f) {
            r = -r
        }
        if (r > Int.MAX_VALUE) {
            return Int.MAX_VALUE
        }
        return r.toInt()
    }
}

fun main() {
    println(Divide.divide(-2147483648,- 1))
}
