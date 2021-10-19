package com.vah.let.datastructure.tree;

import java.util.Scanner

/**
 *@Description
 *@Author HuangJiang
 **/
class RedBlackTreeTest {

}

fun main() {
    val tree = RedBlackTree<String, Any>()

    val scanner = Scanner(System.`in`)
    while (true) {
        println("请输入要插入的节点:")
        val next = scanner.next()
        println()
        tree.put(if (next.length == 1) "0$next" else next, next)
        tree.show()
    }
}


