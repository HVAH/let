package com.vah.let.algorithm.queen

import java.util.Stack

class CQueue() {
    var s1 = Stack<Int>()
    var s2 = Stack<Int>()

    fun appendTail(value: Int) {
        s1.push(value)
    }

    fun deleteHead(): Int {
        if (s2.isEmpty()) {
            while (!s1.empty()) {
                s2.push(s1.pop())
            }
        }
        if (s2.isEmpty()) {
            return -1
        }
        return s2.pop()
    }

}
