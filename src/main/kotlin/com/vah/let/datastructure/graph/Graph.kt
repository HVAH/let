package com.vah.let.datastructure.graph;

import java.util.LinkedList

/**
 *@Description 图
 *@Author HuangJiang
 **/
class Graph {
    private var topList: MutableList<String>? = null
    private var edges: Array<IntArray>? = null
    var countOfEdges: Int = 0

    constructor(n: Int) {
        topList = ArrayList(n)
        edges = Array(n) { IntArray(n) }
    }

    /**
     * 添加顶点
     */
    fun insertTop(topStr: String) {
        topList?.add(topStr)
    }

    /**
     * 插入边
     */
    fun insertEdge(v1: Int, v2: Int, weight: Int) {
        edges!![v1][v2] = 1
        edges!![v2][v1] = 1
        countOfEdges++
    }

    fun getCount(): Int {
        return countOfEdges
    }

    fun getByIndex(i: Int): String {
        return topList!![i]
    }

    fun getWeight(v1: Int, v2: Int): Int {
        return edges!![v1][v2]
    }

    fun show() {
        for (arr in edges!!) {
            arr.forEach { print("  $it") }
            println()
        }
    }

    // 得到第一个邻接节点的下标
    fun getFirstNeighbor(i: Int): Int {
        for (j in topList!!.indices) {
            if (edges!![i][j] > 0) {
                return j
            }
        }
        return -1
    }

    // 根据前一个邻接节点的下标来获取下一个邻接节点
    fun getNextNeighbor(v1: Int, v2: Int): Int {
        for (j in v2 + 1 until topList!!.size) {
            if (edges!![v1][j] > 0) {
                return j
            }
        }
        return -1
    }

    private fun dfs(set: MutableSet<Int>, i: Int) {
        print("${getByIndex(i)} -> ")
        set.add(i)
        var w = getFirstNeighbor(i)
        while (w != -1) {
            if (set.contains(w)) {
                w = getNextNeighbor(i, w)
            } else {
                dfs(set, w)
            }
        }
    }

    /**
     * 深度优先搜索遍历
     */
    fun dfs(set: MutableSet<Int>) {
        for (i in topList!!.indices) {
            if (!set.contains(i)) {
                dfs(set, i)
            }
        }
    }

    private fun bfs(set: MutableSet<Int>, i: Int) {
        var u: Int
        var w: Int
        print("${getByIndex(i)} ->")
        set.add(i)
        val q = LinkedList<Int>()
        q.addLast(i)
        while (q.isNotEmpty()) {
            u = q.removeFirst()
            w = getFirstNeighbor(u)
            while (w != -1) {
                if (!set.contains(w)) {
                    print("${getByIndex(w)} ->")
                    set.add(w)
                    q.addLast(w)
                }
                w = getNextNeighbor(u, w)
            }

        }
    }

    /**
     * 广度优先遍历
     */
    fun bfs() {
        val set = mutableSetOf<Int>()
        for (i in topList!!.indices) {
            if (!set.contains(i)) {
                bfs(set, i)
            }
        }
    }
}

fun main() {
    val n = 5
    val ver = arrayOf("A", "B", "C", "D", "E")
    val graph = Graph(n)
    ver.forEach { graph.insertTop(it) }

    graph.insertEdge(0, 1, 1)
    graph.insertEdge(0, 2, 1)
    graph.insertEdge(1, 2, 1)
    graph.insertEdge(1, 3, 1)
    graph.insertEdge(1, 4, 1)


    graph.show()


    println("深度优先遍历")

    graph.dfs(mutableSetOf())


    println("广度优先")
    graph.bfs()
}


