package com.vah.let.algorithm.linked;

/**
 *@Description 合并两个有序链表
 *@Author HuangJiang
 **/
class MergeTwoLinked {
}

fun main() {
    val l1 = ListNode(5)
    val nod3 = ListNode(3)
    val nod5 = ListNode(5)
    // l1.next = nod3
    // nod3.next = nod5
    val l2 = ListNode(1)
    val nod2 = ListNode(2)
    val nod4 = ListNode(4)
    //val nod6 = ListNode(6)
    l2.next = nod2
    nod2.next = nod4
   // nod4.next = nod6
    val node = mergeTwoLists(l1, l2)
    println()
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) {
        return l2
    }
    if (l2 == null) {
        return l1
    }
    var t1 = l1
    var t2 = l2
    var head = l1
    var t1pre = t1
    while (t1 != null && t2 != null) {
        if (t1?.`val`!! > t2?.`val`!!) {  // 可以插入到t1前面
            // 新的 t2
            val newt2 = t2?.next
            if (head == t1) { // t2变成t1的头结点
                t2?.next = t1
                head = t2
                t1 = head
            } else { // t2插入到t1前面
                t2?.next = t1
                t1pre?.next = t2
                t1pre = t1pre?.next // t1pre也要往后移动
            }
            t2 = newt2
        } else { // t1到下一个 继续与t2对比
            t1pre = t1
            t1 = t1?.next
        }
    }
    // 讲t2多的直接加到t1尾部
    while (t2!=null) {  // 因为t1此时==null 所以用t1pre
        t1pre?.next = t2
        t1pre = t2
        t2 = t2?.next
    }
    return head
}

