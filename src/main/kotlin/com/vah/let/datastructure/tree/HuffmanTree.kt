package com.vah.let.datastructure.tree;

/**
 *@Description 哈夫曼树
 *@Author HuangJiang
 **/
class HuffmanTree {
}

fun main() {
    val tree = createTree(intArrayOf(13, 7, 8, 3, 29, 6, 1))
    tree.beforeErgodic()
    println()
}

fun createTree(arr: IntArray): Node {
    val nodes = arr.sortedBy { it }.map { Node(it) }.toMutableList()

    while (nodes.size > 1) {

        val left = nodes[0]
        val right = nodes[1]
        val parent = Node(left.value + right.value)
        parent.l = left
        parent.r = right

        nodes.remove(left)
        nodes.remove(right)
        nodes.add(parent)

        nodes.sortBy { it.value }
    }

    println(nodes)

    return nodes[0]
}



