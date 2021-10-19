package com.vah.let.datastructure.tree;

import java.lang.StringBuilder

/**
 *@Description 红黑树的实现
 *@Author HuangJiang
 **/
class RedBlackTree<K: Comparable<K>, V> {
    private val red = true
    private val black = false
    private var root: RBNOde<K, V>? = null

    fun leftRotate(p: RBNOde<K, V>?) {
        p?.let {

            val r = p.right
            p.right = r?.left
            if (r?.left != null) {
                r.left?.parent = p
            }
            r?.parent = p.parent
            if (p.parent == null) {
                root = r
            } else if (p == p.parent?.left) {
                p.parent?.left = r
            } else {
                p.parent?.right = r
            }
            r?.left = p
            p.parent = r
        }
    }

    fun rightRotate(p: RBNOde<K, V>?) {
        p?.let {
            val l = p.left
            p.left = l?.right
            if (l?.right != null) {
                l.right?.parent = p
            }
            l?.parent = p.parent
            if (null == p.parent) {
                root = l
            } else if (l == p.parent?.left) {
                p.parent?.left = l
            } else {
                p.parent?.right = l
            }
            l?.right = p
            p.parent = l
        }
    }

    fun put(key: K, value: V) {
        root?.let {
            var t = root
            var p: RBNOde<K, V>?
            var cmp: Int
            do {
                p = t
                cmp = key.compareTo(t?.key!!)
                if (cmp < 0) {
                    t = t.left
                } else if (cmp > 0) {
                    t = t.right
                } else {
                    t.value = value
                    return
                }
            } while (t != null)
            val rbnOde = RBNOde(key, value, p)
            if (cmp > 0) {
                p?.right = rbnOde
            } else {
                p?.left = rbnOde
            }
            fixAlterPut(rbnOde)
        } ?: let {
            root = RBNOde(key, value, null)
            root?.color = black
        }
    }

    fun fixAlterPut(x: RBNOde<K, V>) {
        var x: RBNOde<K, V>? = x
        while (x != null && x!= root && colorOf(x.parent) == red) {
            if (x.parent == x.parent?.parent?.left) { // x的父节点是爷爷节点的左孩子
                // 叔叔节点
                val uncle = x.parent?.parent?.right
                if (colorOf(uncle) == red) { // 叔叔节点存在且为红
                    x.parent?.color = black
                    uncle?.color = black
                    x.parent?.parent?.color = red

                    // 爷爷节点继续调整
                    x = x.parent?.parent!!
                } else { // 没有叔叔节点 左三
                    // x是右子节点
                    if (x == x.parent?.right) { // 调整成左三
                        x = x.parent!!
                        leftRotate(x)
                    }
                    x.parent?.color = black
                    x.parent?.parent?.color = red
                    rightRotate(x.parent?.parent)
                }
            } else {
                // 叔叔节点
                val uncle = x.parent?.parent?.left
                if (colorOf(uncle) == red) { // 叔叔节点存在且为红
                    x.parent?.color = black
                    uncle?.color = black
                    x.parent?.parent?.color = red

                    x = x.parent?.parent!!
                } else { // 没有叔叔节点 右三
                    // x是左子节点
                    if (x == x.parent?.left) { // 调整成右三
                        x = x.parent!!
                        rightRotate(x)
                    }
                    x.parent?.color = black
                    x.parent?.parent?.color = red
                    leftRotate(x.parent?.parent)
                }
            }
        }
        root?.color = black
    }

    fun getTreeDepth(root: RBNOde<K,V>?): Int {
        return if (root == null) 0 else 1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right))
    }

    private fun writeArray(
        currNode: RBNOde<K,V>?,
        rowIndex: Int,
        columnIndex: Int,
        res: Array<Array<String?>>,
        treeDepth: Int
    ) {
        // 保证输入的树不为空
        if (currNode == null) {
            return
        }

        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] =
            (currNode.key.toString() + (if (currNode.color == red) "R" else "B") + "")

        // 计算当前位于树的第几层
        val currLevel = (rowIndex + 1) / 2

        // 若到了最后一层，则返回
        if (currLevel == treeDepth) {
            return
        }

        // 计算当前行到下一行，每个元素之间的间隔(下一行的列索引与当前元素的列索引之间的间隔)
        val gap = treeDepth - currLevel - 1

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/"
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth)
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\"
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth)
        }
    }

    fun show() {
        if (root == null) {
            println("EMPTY!")
        }

        // 得到树的深度
        val treeDepth: Int = getTreeDepth(root)
        // 最后一行的宽度为2的(n - 1)次方乘3，再加1
        // 作为整个二维数组的宽度
        val arrayHeight = treeDepth * 2 - 1
        val arrayWidth = (2 shl treeDepth - 2) * 3 + 1
        // 用一个字符串数组来存储每个位置应显示的元素
        val res = Array(arrayHeight) {
            arrayOfNulls<String>(
                arrayWidth
            )
        }
        // 对数组进行初始化，默认为一个空格
        for (i in 0 until arrayHeight) {
            for (j in 0 until arrayWidth) {
                res[i][j] = " "
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth)
        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即
        for (line in res) {
            val sb = StringBuilder()
            var i = 0
            while (i < line.size) {
                sb.append(line[i])
                if (line[i]!!.length > 1 && i <= line.size - 1) {
                    i += if (line[i]!!.length > 4) 2 else line[i]!!.length - 1
                }
                i++
            }
            println(sb.toString())
        }
    }


    fun colorOf(x: RBNOde<K, V>?): Boolean {
        return x?.color ?: black
    }

    inner class RBNOde<K : Comparable<K>, V>(
        var key: K,
        var value: V,
        var parent: RBNOde<K, V>?
    ) {
        var left: RBNOde<K, V>? = null
        var right: RBNOde<K, V>? = null
        var color: Boolean = red
    }
}
