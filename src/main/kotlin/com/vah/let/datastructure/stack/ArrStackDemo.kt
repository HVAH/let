package com.vah.let.datastructure.stack

import java.lang.RuntimeException

/**
 *@Description 数组模拟栈
 * 思路分析
 *@Author HuangJiang
 **/
class ArrStackDemo {
}

class ArrStack<T> {
    var capcity: Int
    var size: Int
    var data: Array<T?>

    constructor(capcity: Int) {
        this.capcity = capcity
        size = 0
        data = Array<Any?>(capcity) { null } as Array<T?>
    }

    fun isFull(): Boolean {
        return size == capcity
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun push(t: T) {
        if (isFull()) {
            println("栈已满")
            return
        }
        data[size] = t
        size++
    }

    fun pop(): T {
        if (isEmpty()) {
            throw RuntimeException("栈为空")
        }
        val t = data[size - 1]
        data[size - 1] = null
        size--
        return t!!
    }

    fun getLast(): T {
        if (isEmpty()) {
            throw RuntimeException("栈为空")
        }
        return data[size - 1]!!
    }
}

fun main() {
    val arrStack = ArrStack<Int>(10)
    arrStack.push(1)
    arrStack.push(2)
    arrStack.push(3)
    arrStack.push(4)
    arrStack.push(5)

    val last = arrStack.getLast()

    while (true) {
        println(arrStack.pop())
    }
}
