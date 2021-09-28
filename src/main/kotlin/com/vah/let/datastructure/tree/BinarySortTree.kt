package com.vah.let.datastructure.tree;

import com.vah.let.algorithm.sort.t
import com.vah.let.isNotNull
import com.vah.let.isNull

/**
 *@Description 二叉排序树
 *@Author HuangJiang
 **/
class BinarySortTree {
    private var root: BSTNode? = null

    fun add(bstNode: BSTNode) {
        root?.let {
            it.add(bstNode)

        } ?: let {
            root = bstNode
        }
    }

    fun middleErgodic() {
        root?.middleErgodic()
    }

    fun searchParent(value: Int): BSTNode? {
        return root?.searchParent(value)
    }

    fun search(value: Int): BSTNode? {
        return root?.search(value)
    }

    fun delete(value: Int): Boolean {
        return root?.let {
            val target = search(value)
            target?.let { tar ->
                if (root?.l.isNull() && root?.r.isNull()) { // 当前树只有一个节点
                    root = null
                }
                val parent = searchParent(value)
                if (tar.l.isNull() && tar.r.isNull()) { // 要删除的节点是叶子节点
                    if (parent?.l?.value == value) {
                        parent.l = null
                    } else {
                        parent?.r = null
                    }
                } else if (tar.l.isNotNull() && tar.r.isNotNull()) { // 有双节点
                    // 找到右子树上最小的值
                    var t = tar.r?.getMinValue()!!
                    val tp = searchParent(t)
                    if (tp?.l?.value == t) {
                        tp.l = null
                    } else {
                        tp?.r = null
                    }
                    tar.value = t
                } else { // 要删除的节点只有一个子节点
                    if (tar.l.isNotNull()) { // 有左子节点
                        if (parent.isNull()) { // 但是要删的就是根节点 直接赋值给根节点
                            root = tar.l
                        } else if (tar == parent?.l) { // 是父节点的左子节点
                            parent.l = tar.l
                        } else { // 是父节点的右子节点
                            parent?.r = tar.l
                        }
                    } else { // 有右子节点
                        if (parent.isNull()) {
                            root = tar.r
                        } else if (tar == parent?.l) { // 是父节点的左子节点
                            parent.l = tar.r
                        } else { // 是父节点的右子节点
                            parent?.r = tar.r
                        }
                    }
                }

                true
            } ?: let {
                false
            }
        } ?: let {
            false
        }
    }
}

fun main() {
    val tree = BinarySortTree()
    tree.add(BSTNode(7))
    tree.add(BSTNode(3))
    tree.add(BSTNode(10))
    tree.add(BSTNode(12))
    tree.add(BSTNode(5))
    tree.add(BSTNode(1))
    tree.add(BSTNode(9))
    tree.middleErgodic()

    println(tree.searchParent(5))
    println(tree.search(5))

    tree.delete(2)
    tree.delete(5)
    tree.delete(9)
    tree.delete(12)
    tree.delete(7)
    tree.delete(3)
    tree.delete(10)
//    tree.delete(1)

    tree.middleErgodic()
}

class BSTNode(
    var value: Int,
    var l: BSTNode? = null,
    var r: BSTNode? = null
) {

    fun add(bstNode: BSTNode) {
        var t = this
        while (true) {
            if (bstNode.value >= t.value) {
                if (t.r.isNotNull()) {
                    t = t?.r!!
                } else {
                    t.r = bstNode
                    break
                }
            } else {
                if (t.l.isNotNull()) {
                    t = t.l!!
                } else {
                    t.l = bstNode
                    break
                }
            }
        }
    }

    fun beforeErgodic() {
        println(value)
        l?.beforeErgodic()
        r?.beforeErgodic()
    }

    fun middleErgodic() {
        l?.middleErgodic()
        println(value)
        r?.middleErgodic()
    }

    fun afterErgodic() {
        l?.afterErgodic()
        r?.afterErgodic()
        println(value)
    }

    fun getMinValue(): Int {
        l?.middleErgodic()
        return value
        r?.middleErgodic()
    }

    /**
     * 返回指定节点
     */
    fun search(value: Int): BSTNode? {
        var t: BSTNode? = this
        while (t.isNotNull()) {
            t = if (t?.value == value) {
                return t
            } else if (value >= t?.value!!) {
                t?.r
            } else {
                t?.l
            }
        }
        return null
    }

    /**
     * 返回指定节点的父节点
     */
    fun searchParent(value: Int): BSTNode? {
        var t: BSTNode? = this

        while (t.isNotNull()) {
            t = if (t?.l?.value == value || t?.r?.value == value) {
                return t
            } else {
                if (value < t?.value!!) {
                    t?.l
                } else {
                    t?.r
                }
            }
        }
        return null
    }

    override fun toString(): String {
        return "Node(value=$value)"
    }
}
