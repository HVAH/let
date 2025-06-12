package com.vah.let.algorithm.stack;

import java.util.LinkedList

/**
 *@Description
 *  设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop()—— 删除栈顶的元素。
top()—— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。


 *@Author HuangJiang
 **/
class MinStack {

    private var min: Int? = null
    private var values = LinkedList<Int>()

    fun push(`val`: Int) {
        min = min?.let { Math.min(it, `val`) } ?: `val`
        values.addLast(`val`)
    }

    fun pop() {
        values.removeLast()
        min = values.min()
    }

    fun top(): Int {
        return values.peekLast()
    }

    fun getMin(): Int {
        return min!!
    }
}
