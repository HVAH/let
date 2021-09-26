package com.vah.let.algorithm.linked;

/**
 *@Description
 *@Author HuangJiang
 **/
class RevertNode {
}

fun main() {
    val nod1 = ListNode(1)
    val nod2 = ListNode(2)
    val nod3 = ListNode(3)
    val nod4 = ListNode(4)
    val nod5 = ListNode(5)
    nod1.next = nod2
    nod2.next = nod3
    nod3.next = nod4
    nod4.next = nod5
    reverseList(nod1)
}

fun reverseList(head: ListNode?): ListNode? {
    var head = head
    var t = head
    while (t?.next != null) {
        val next = t?.next
        t?.next = t?.next?.next
        next?.next = head
        head = next
    }
    return head
}
