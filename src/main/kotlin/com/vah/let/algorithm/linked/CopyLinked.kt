package com.vah.let.algorithm.linked;


/**
 *@Description
 *@Author HuangJiang
 **/
class CopyLinked {



}
    fun copyRandomList(node: Node?): Node? {
        var t: Node? = node
        val map: MutableMap<Node, Node> = mutableMapOf()
        while (t != null) {
            map[t] = Node(t.`val`)
            t = t.next
        }
        t = node
        while (t != null) {
            val node1 = map[t]!!
            node1.next = map[t.next]
            node1.random = map[t.random]

            t = t.next
        }
        return map[node]
    }

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

fun main() {
    //[[7,null],[13,0],[11,4],[10,2],[1,0]]
    /*val head = Node(7)
    val node2 = Node(13)
    val node3 = Node(11)
    val node4 = Node(10)
    val node5 = Node(1)
    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node2.random = head
    node3.random = node5
    node4.random = node3
    node5.random = head

    copyRandomList(head)*/
    //(score.toLong().shl(50) + succTimes.toLong().shl(35) + userId).toDouble()
    println(40.shr(50))
    println(300L.shl(35))
    println(40.shl(50) + 300.shl(35) + 10001)
}
