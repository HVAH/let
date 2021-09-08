package com.vah.let.datastructure.linked;

/**
 *@Description 单向环形链表
 *@Author HuangJiang
 **/
class CycleLinkedList<T> {
    var first: SingleCycleNode<T>? = null
    var last: SingleCycleNode<T>? = null


    fun add(t: T) {
        first?.let {
            val node = SingleCycleNode(t, null)
            last?.next = node
            node?.next = first
            last = node
        } ?: let {
            first = SingleCycleNode(t, null)
            first?.next = first
            last = first
        }
    }

    fun show() {
        var temp = first
        temp?.let {
            do {
                println(temp?.value)
                temp = temp?.next
            } while (temp != first)

        }
    }

    fun delete(t: T) {

    }

    // 约瑟夫环 输出
    fun josepfuShow(size: Int, from: Int) {
        var count = 0 + from
        var temp = first
        while (true) {
            if (temp?.next == temp) {
                // 只剩一个元素了
                println(temp?.value)
                first  = null
                last = null
                break
            }
            if ( count % size == 0) {
                println(temp?.next?.value)
                temp?.next = temp?.next?.next
            } else {
                temp = temp?.next
            }
            count++
        }
    }
}

fun main() {
    val cycleLinkedList = CycleLinkedList<Int>()
    cycleLinkedList.add(1)
    cycleLinkedList.add(2)
    cycleLinkedList.add(3)
    cycleLinkedList.add(4)
    cycleLinkedList.add(5)
    cycleLinkedList.show()

    cycleLinkedList.josepfuShow(2,1)
}


class SingleCycleNode<T>(
    var value: T,
    var next: SingleCycleNode<T>?
)
