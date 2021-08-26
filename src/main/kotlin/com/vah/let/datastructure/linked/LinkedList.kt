package com.vah.let.datastructure.linked;

/**
 *@Description 单项链表
 *@Author HuangJiang
 **/

fun main() {
    val heroNode1 = HeroNode(1, "a", "A", null)
    val heroNode2 = HeroNode(2, "b", "B", null)
    val heroNode3 = HeroNode(3, "c", "C", null)
    val linkedList = LinkedList()
    linkedList.sortAdd2(heroNode2)
    linkedList.sortAdd2(heroNode3)
    linkedList.sortAdd2(heroNode1)
    linkedList.show()
}

class LinkedList {
    private val head = HeroNode(0, "", "", null)

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
