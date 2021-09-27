package com.vah.let.algorithm.linked


/**
 *@Description 删除链表中的节点
 *@Author HuangJiang
 **/


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun deleteNode(node: ListNode?) {
    node?.`val` = node?.next?.`val`!!
    node?.next = node.next!!.next
}

/**
 * 功能描述: 删除链表的倒数第N个节点  两次遍历
 * @Param:
 * @Return:
 */
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var temp: ListNode? = head
    var size = 0
    while (temp != null) {
        size++
        temp = temp?.next
    }
    val index = size - n + 1
    temp = head
    if (index == 1) {
        return temp?.next
    }
    var count = 1
    while (count != index - 1) {
        temp = temp?.next
        count++
    }
    temp?.next = temp?.next?.next
    return head
}

/**
 * 功能描述: 删除链表的倒数第N个节点  一次遍历
 * @Param:
 * @Return:
 */
fun removeNthFromEnd2(head: ListNode?, n: Int): ListNode? {
    // 用一个list存储每一个节点 一次遍历完成后即可知道
    val list = mutableListOf<ListNode?>()
    var temp: ListNode? = head!!
    list.add(temp)
    while (temp?.next != null) {
        temp = temp?.next
        list.add(temp)
    }
    val index = list.size - n
    if (index == 0) {
        return head?.next
    }
    val listNode = list[index - 1]
    listNode?.next = listNode?.next?.next
    return head
}
