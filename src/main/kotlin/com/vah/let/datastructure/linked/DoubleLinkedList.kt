package com.vah.let.datastructure.linked

import java.util.Objects

/**
 *  双向链表
 *
 */

fun main() {
    val doubleLinkedList = DoubleLinkedList<Int>()
    doubleLinkedList.addLast(1)
    doubleLinkedList.addLast(2)
    doubleLinkedList.addLast(3)
    doubleLinkedList.addLast(4)

   doubleLinkedList.show()

    println(doubleLinkedList.delete(6))
    println(doubleLinkedList.delete(1))
}

class DoubleLinkedList<T> {
    private var data: DoubleNode<T>? = null
    private var last: DoubleNode<T>? = null

    fun addLast(value: T) {
        val newNode = DoubleNode(value)
        data?.let {
            var temp = data
            while (temp?.next != null) {
                temp = temp?.next
            }
            temp?.next = newNode
            newNode.pre = temp

        } ?: let {
            data = newNode
        }
        last = newNode
    }

    fun show() {
        var temp = data
        temp?.let {
            do {
                println(temp?.value)
                temp = temp?.next
            } while (temp != null)

        } ?: println("空链表")
    }

    fun delete(value: T): Boolean {
        var temp = data
        return temp?.let {
            do {
                if (temp?.value == value || value?.equals(temp?.value)!!)  return true
                temp = temp?.next
            } while (temp != null)
            return false
        } ?: false
    }
}

class DoubleNode<T> {
    var value: T? = null
    var pre: DoubleNode<T>? = null
    var next: DoubleNode<T>? = null

    constructor(value: T) {
        this.value = value
    }
}
