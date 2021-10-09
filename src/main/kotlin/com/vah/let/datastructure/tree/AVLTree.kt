package com.vah.let.datastructure.tree;

import com.vah.let.isNotNull
import kotlin.math.max

/**
 *@Description 平衡二叉树
 *@Author HuangJiang
 **/
class AVLTree {
    var root: AVLNode? = null

    fun add(value: Int) {
        val addNode = AVLNode(value)
        root?.let {
            it.add(addNode)

        } ?: let {
            root = addNode
        }
    }

    fun middleErgodic() {
        root?.middleErgodic()
    }
}

fun main() {
    val arr = intArrayOf(10, 11, 7, 6, 8, 9)
    val avlTree = AVLTree()
    for (i in arr) {
        avlTree.add(i)
    }

    avlTree.middleErgodic()

    println("树的高度=== ${avlTree.root?.height()}")
    println("左子树的高度=== ${avlTree.root?.leftHeight()}")
    println("右子树的高度=== ${avlTree.root?.rightHeight()}")
}

class AVLNode(
    var value: Int,
    var l: AVLNode? = null,
    var r: AVLNode? = null
) {

    fun add(addNode: AVLNode) {
        if (addNode.value >= this.value) {
            if (this.r.isNotNull()) {
                this.r?.add(addNode)
            } else {
                this.r = addNode
            }
        } else {
            if (this.l.isNotNull()) {
                this.l?.add(addNode)
            } else {
                this.l = addNode
            }
        }

        if (this.rightHeight() - this.leftHeight() > 1) { // 需要将树进行旋转 左旋
            if (this.r != null && this.r!!.leftHeight() > this.r!!.rightHeight()) { //
                this.r?.rightRotate()
            }
            this.leftRotate()
        } else if (this.rightHeight() - this.leftHeight() < -1) {// 需要将树进行右旋  右旋跟左旋是对称的操作
            // 注意  当符合右旋转的条件
            // 如果当前节点的左子树的右子树的高度大于它的左子树的高度
            // 先对当前节点的左节点进行左旋
            // 再对当前节点进行右旋
            if (this.l != null && this.l?.rightHeight()!! > this.l?.leftHeight()!!) {
                this.l?.leftRotate()
            }
            this.rightRotate()
        }
    }

     fun rightRotate() {
        val newNode = AVLNode(this.value)
        newNode.r = this.r
        newNode.l = this.l?.r
        this.r = newNode
        this.value = this.l?.value!!
        this.l = this.l?.l
    }

     fun leftRotate() {
        val newNode = AVLNode(this.value)
        newNode.l = this.l
        newNode.r = this.r?.l
        this.l = newNode
        this.value = this.r?.value!!
        this.r = this.r?.r
    }

    fun leftHeight(): Int {
        return this.l?.height() ?: 0
    }

    fun rightHeight(): Int {
        return this.r?.height() ?: 0
    }

    /**
     * 返回当前节点的高度
     */
    fun height(): Int {
        return max(this?.l?.height() ?: 0, this?.r?.height() ?: 0) + 1
    }

    fun middleErgodic() {
        l?.middleErgodic()
        println(value)
        r?.middleErgodic()
    }
}
