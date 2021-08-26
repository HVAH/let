package com.vah.let.datastructure.queue;

/**
 *@Description  模拟数组队列
 *@Author HuangJiang
 **/

/**
 * 非环形数组队列
 */
class ArrQueue{

    private var maxSize: Int
    private var front: Int
    private var rear: Int
    private var arr: IntArray

    constructor(maxSize: Int) {
        this.maxSize = maxSize
        arr = IntArray(maxSize)
        front = -1
        rear = -1
    }

    // 判断是否是满队列
    fun isFull(): Boolean {
        return rear == maxSize - 1
    }
    // 是否是空队列
    fun isEmpty(): Boolean {
        return rear == front
    }

    fun addQueue(value: Int) {
        if(isFull()) {
            println("队列已满")
        } else {
            arr[++rear] = value
        }
    }

    fun getQueue(): Int {
        if (isEmpty()) {
            throw RuntimeException("队列为空")
        }
        return arr[++front]
    }

    fun showQueue() {
        if (isEmpty()) {
            println("队列为空")
        } else {
            for (i in arr) {
                println("arr[$i]=$i")
            }

        }
    }



}

/**
 * 环形数组队列
 */
class ArrCycleQueue {
    private var maxSize: Int
    private var front: Int = 0
    private var rear: Int = 0
    private var arr: IntArray

    constructor(maxSize: Int) {
        this.maxSize = maxSize
        arr = IntArray(maxSize)
    }

    // 判断是否是满队列
    fun isFull(): Boolean {
        return (rear + 1) % maxSize == front
    }
    // 是否是空队列
    fun isEmpty(): Boolean {
        return rear == front
    }

    fun addQueue(value: Int) {
        if(isFull()) {
            throw RuntimeException("队列已满")
        } else {
            arr[rear] = value
            rear = ++rear % maxSize
        }
    }

    fun getQueue(): Int {
        if (isEmpty()) {
            throw RuntimeException("队列为空")
        }
        val i = arr[front]
        arr[front] = 0
        front = ++front % maxSize
        return i
    }

    fun showQueue() {
        if (isEmpty()) {
            println("队列为空")
        } else {
            for (i in 0 until maxSize) {
                println("arr[$i]=${arr[i]}")
            }

        }
    }
}


fun main() {
    /*val queue = ArrQueue(10)
    queue.addQueue(1)
    queue.addQueue(2)
    queue.addQueue(3)

    while (true) {
        println(queue.getQueue())
    }*/

    val queue = ArrCycleQueue(9)
    while (true) {
        println("=============")
        queue.addQueue(1)
        queue.addQueue(2)
        queue.showQueue()
        queue.getQueue()
    }

}


