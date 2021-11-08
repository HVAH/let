package com.vah.let.algorithm.linked;

/**
 *@Description 判断链表是否有环
 *@Author HuangJiang
 **/
class HasCycle {
}

/**
 * 1 用set判断  当set里面存在时  表示是存在环
 * 时间复杂度O(n) 空间复杂度O(n)
 */
fun hasCycle(head: ListNode?): Boolean {
    var t= head
    val set = mutableSetOf<ListNode>()
    while (t != null) {
        if (!set.add(t)) {
            return true
        }
        t = t.next
    }
    return false
}

/**
 * 快慢指针  如果任何一个等于null 则不为环  如果fast==slow了 则有环
 * 时间复杂度O(n) 空间复杂度O(1)
 */
fun hasCycle2(head: ListNode?): Boolean {
    var fast = head
    var slow = head
    while (fast?.next != null && slow!=null) {
        fast = fast.next?.next
        slow = slow.next
        if (fast == slow) {
            return true
        }
    }
    return false
}

/**
 * 逐个删除头结点 如果head=head.next则有环   出现head.next = null没有环
 */
fun hasCycle3(head: ListNode?): Boolean {
    var t = head
    while (t?.next != null) {
        if (t.next == t) {
            return true
        }
        var tt = t.next
        // 让每个next指向自身
        t.next = t
        t = tt
    }
    return false
}
