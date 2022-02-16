package com.vah.let.algorithm.math;

/**
 *@Description 模拟除法 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *@Author HuangJiang
 * https://leetcode-cn.com/problems/xoh6Oh/submissions/
 **/
object Divide {

    /**
     *纯粹的利用减法
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

    /**
     * 优化 如果当除数是1 或者-1时 ，减法运算效率不高，这时可以将除数扩大一倍 直到除数不超过被除数且与被除数的差值
     * 最小
     *
     * 步骤
     * 初始化res = 0
     *
     *
     */
    fun divide2(a: Int, b: Int): Int {
        // flag == 0 || flag == 2 表示ab同符号 结果为正数
        var flag = 0
        var a = a
        var b = b
        if (a >0) {
            a = -a
            flag += 1
        }
        if (b > 0) {
            b = -b
            flag += 1
        }

        var res = 0
        while (a <= b) {
            var tb = b
            var c = 1

            // tb >= Int.MIN_VALUE shr 1 防止 tb shl 1 溢出，若大于最小的一半  则左移一位时会溢出
            while (tb >= Int.MIN_VALUE shr 1 && a <= tb shl 1) {
                tb += tb
                c += c
            }
            res -= c
            a -= tb
        }

        if (flag != -1 && res == Int.MIN_VALUE) {
            // 最终结果为正 但是溢出 +1 防止转成正数的时候溢出
            res++
        }

        return if (flag == -1) res else - res

    }

}

fun main() {
    println(Divide.divide(-2147483648,- 1))
}
