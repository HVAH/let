package com.vah.let.datastructure.linked;


/**
 *@Description 单链表
 *@Author HuangJiang
 **/

fun main() {
    val heroNode1 = HeroNode(1, "a", "A", null)
    val heroNode2 = HeroNode(2, "b", "B", null)
    val heroNode3 = HeroNode(3, "c", "C", null)
    val heroNode4 = HeroNode(4, "d", "D", null)
    val linkedList = LinkedList()
    linkedList.sortAdd2(heroNode2)
    linkedList.sortAdd2(heroNode3)
    linkedList.sortAdd2(heroNode1)
    linkedList.sortAdd2(heroNode4)
    linkedList.show()

    println("findK============")
    val findK = findK(4, linkedList)
    println(findK)

    println("reverse============")
    reverse(linkedList).show()


    println("reverseprint=========")
    linkedList.head.next?.let { reversePrint1(it) }
}


// test 1  查找单链表的倒数第k个节点
fun findK(k: Int, linkedList: LinkedList): HeroNode? {
    if (k <= 0) return null
    if (linkedList.head == null) return null
    var temp = linkedList.head
    var size = 1
    while (temp.next != null) {
        size ++
        temp = temp.next!!
    }
    if (k > size) return null
    val index = size - k + 1
    temp = linkedList.head
    var count = 1
    while(index != count) {
        temp = temp.next!!
        count++
    }
    return temp


}
// test2 单向链表反转  头插入法  依次将下一个元素插入到头部
fun reverse(linkedList: LinkedList): LinkedList {
    var temp = linkedList.head.next
    while (temp?.next != null) {
        val next = temp.next
        temp.next = temp.next?.next
        next?.next = linkedList.head.next
        linkedList.head.next = next
    }
    return linkedList
}

// test3 从尾到头打印单链表
// 1 先反转再打印 结合以上的reverse和show方法就可实现
// 2 放入数组 反向遍历
// 3 栈

// 4 使用递归 只要还有next就继续递归  这样就会从最后一个开始打印
fun reversePrint1(heroNode: HeroNode) {
    if (heroNode.next != null) {
        reversePrint1(heroNode.next!!)
    }
    println(heroNode.toString())
}

class LinkedList {
     val head = HeroNode(0, "", "", null)

    /**
     * 插入节点
     */
    fun add(heroNode: HeroNode) {
        var temp = head
        while (true) {
            temp = temp.next ?: break
        }
        temp.next = heroNode
    }

    /**
     * 有序的插入节点  按 num 排序
     */
    fun sortAdd(heroNode: HeroNode) {
        var temp = head
        while (true) {
            if (temp.next == null) {
                break
            } else {
                temp = temp.next!!
                if (temp.num == heroNode.num) {
                    // 重复了不给添加
                    throw RuntimeException("重复了")
                } else if (heroNode.num < temp.num) {
                    // 如果小于第一个节点  直接置为第一个节点  相当于是首部插入
                    head.next = heroNode
                    heroNode.next = temp
                    return
                } else if (temp.num < heroNode.num && temp.next != null && heroNode.num < temp.next!!.num) {
                    // 处在两者之间 跳出循环  相当于从中间插入
                    break
                } else {
                    // 其他情况 则是从尾部插入
                    continue
                }
            }
        }
        val next = temp.next
        heroNode.next = next
        temp.next = heroNode
    }

    fun sortAdd2(heroNode: HeroNode) {
        var temp: HeroNode? = head
        var duplicate = false

        while (true) {
            if (temp?.next == null) break

            if (temp.next!!.num == heroNode.num) {
                duplicate = true
                break
            } else if (temp.next!!.num > heroNode.num) {
                // 下一个比插入的大  那就是当前的位置插入了
                break
            }
            temp = temp.next
        }
        if (duplicate) {
            println("有重复了")
        } else {
            heroNode.next = temp?.next
            temp?.next = heroNode
        }
    }

    fun show() {
        var temp = head
        while (true) {
            temp = temp.next ?: break
            println(temp)
        }
    }
}

data class HeroNode(
    val num: Int,
    val name: String,
    val nickName: String,
    var next: HeroNode?

) {
    override fun toString(): String {
        return "HeroNode(num=$num, name='$name', nickName='$nickName')"
    }
}
