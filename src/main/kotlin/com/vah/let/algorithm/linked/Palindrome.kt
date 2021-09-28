package com.vah.let.algorithm.linked;

/**
 *@Description 验证回文链表
 * 要求 O(n) 时间复杂度和 O(1) 空间复杂度
 *@Author HuangJiang
 **/
class Palindrome {
}

fun main() {
    val l1 = ListNode(1)
    val nod2 = ListNode(3)
    val nod3 = ListNode(2)
    val nod4 = ListNode(4)
    val nod5 = ListNode(3)
    val nod6 = ListNode(2)
    val nod7 = ListNode(1)


    l1.next = nod2
    nod2.next = nod3
    nod3.next = nod4
    nod4.next = nod5
    nod5.next = nod6
    nod6.next = nod7

    isPalindrome(l1)
}

/**
 * 思路  反正后面一半的链表 再进行对比
 * 时间复杂度为O(4n) -> O(n)
 */
fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) {
        return false
    }
    if (head.next == null) {
        return true
    } else {
        var t = head
        // 统计个数
        var count = 1
        while (t?.next != null) {
            count++
            t = t?.next
        }
        t = head
        for (i in 1..count / 2) {
            t = t?.next
        }
        // 反转t
        var th = t
        while (t?.next != null) {
            val next = t?.next
            t?.next = t?.next?.next
            next?.next = th
            th = next
        }

        var headt = head
        while (th != null) {
            if (headt?.`val` != th.`val`) {
                return false
            }
            th = th?.next
            headt = headt?.next
        }
        return true
    }
}


fun isPalindrome2(head: ListNode?): Boolean {
    if (head == null) {
        return false
    }
    if (head.next == null) {
        return true
    } else {
        var fast = head
        var t = head
        // 用快慢指针找到后半部分
        while (fast != null && fast.next != null) {
            fast = fast?.next?.next
            t = t?.next
        }
        if (fast != null) {
            t = t?.next
        }

        // 反转t
        var th = t
        while (t?.next != null) {
            val next = t?.next
            t?.next = t?.next?.next
            next?.next = th
            th = next
        }

        var headt = head
        while (th != null) {
            if (headt?.`val` != th.`val`) {
                return false
            }
            th = th?.next
            headt = headt?.next
        }
        return true
    }
}
