package com.vah.let.datastructure.tree;

/**
 *@Description 线索化二叉树
 *@Author HuangJiang
 **/
class ThreadBinaryTree(
    val root: Node
) {

}

class TNode(
    val value: Int
) {
    var left: TNode? = null
    var right: TNode? = null

    var lt: Int? = null
    var rt: Int? = null
}


