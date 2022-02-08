package com.vah.let.algorithm.tree;

import java.util.LinkedList

/**
 *@Description 简单树
 *@Author HuangJiang
 **/
class SimpleTree {
}

/**
 * 树的最大深度
 */
fun maxDepth(root: TreeNode?): Int {
    return root?.let { Math.max(root?.left?.let { maxDepth(it) } ?: 0, root?.right?.let { maxDepth(it) } ?: 0) + 1 }
        ?: 0
}

var pre: TreeNode? = null

/**
 * 验证二叉搜索树 中序遍历
 */
fun isValidBST(root: TreeNode?): Boolean {
    if (root == null) return true
    if (!isValidBST(root.left)) {
        return false
    }
    if (pre != null && pre?.`val`!! >= root.`val`) {
        return false
    }
    pre = root
    if (!isValidBST(root.right)) {
        return false
    }
    return true
}

/**
 * 验证是否是对称二叉树
 * 对于一个节点，左子节点等于右子节点  左节点的左子节点 == 右子节点的右子节点  左节点的右子节点== 右子节点的左子节点
 */
fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    return isSymmetricHelper(root.left, root.right)

}

fun isSymmetricHelper(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) {
        return true
    }
    if (left?.`val` != right?.`val`) {
        return false
    }
    return isSymmetricHelper(left?.left, right?.right) && isSymmetricHelper(left?.right, right?.left)
}


/**
 * 二叉树的层序遍历 即逐层地，从左到右访问所有节点
 */
fun levelOrder(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    return root?.let {
        levelOrder(listOf(it), res)
        res
    } ?: listOf()
}

/**
 * 这也是一种BFS
 */
fun levelOrder(leveNodes: List<TreeNode>, res: MutableList<List<Int>>){
    if (leveNodes.isEmpty()) {
        return
    }
    val values = mutableListOf<Int>()
    val nextLevel = mutableListOf<TreeNode>()
    leveNodes.forEach {
        values.add(it.`val`)
        it.left?.let { nextLevel.add(it) }
        it.right?.let { nextLevel.add(it) }
    }
    res.add(values)
    levelOrder(nextLevel, res)
}

/**
 * 二叉树的层序遍历 即逐层地，从左到右访问所有节点
 */
fun levelOrderBFS(root: TreeNode?): List<List<Int>> {
    if (root == null) return listOf()
    val queen = LinkedList<TreeNode>()
    val res = mutableListOf<List<Int>>()
    queen.addLast(root)
    while (!queen.isEmpty()) {
        val clSize = queen.size // 当前层的节点个数
        val values = mutableListOf<Int>() // 当前层节点的值
        for (i in 0 until clSize) {
            val node = queen.poll()
            values.add(node.`val`)
            node.left?.let { queen.addLast(it) }
            node.right?.let { queen.addLast(it) }
        }
        res.add(values)
    }
    return res
}

/**
 * 将有序数组转为BST
 */
fun sortedArrayToBST(nums: IntArray): TreeNode? {
    val root = TreeNode(nums[0])
    for (i in 1 until nums.size) {
        var t = root
        while (true) {
            if (nums[i] > t.`val`) {
                if (t.right != null) {
                    t = t.right!!
                } else {
                    t.right = TreeNode(nums[i])
                    break
                }
            } else {
                if (t.left != null) {
                    t = t.left!!
                } else {
                    t.left = TreeNode(nums[i])
                    break
                }
            }
        }
    }
    return root
}


fun levelOrder2(root: TreeNode?): List<List<Int>> {
    return root?.let {
        val list = LinkedList<TreeNode>()
        list.add(it)
        val res = mutableListOf<List<Int>>()

        while (!list.isEmpty()) {
            val of = mutableListOf<Int>()
            val chil = mutableListOf<TreeNode>();
            for (i in list.indices) {
                val pop = list.pop()
                pop.left?.let { it1 -> chil.add(it1) }
                pop.right?.let { it1 -> chil.add(it1) }
                of.add(pop.`val`)
            }
            res.add(of)
            list.addAll(chil)
        }
        res

    } ?: listOf()
}


fun levelOrder3(root: TreeNode?): List<List<Int>> {
    return root?.let {
        val res = mutableListOf<List<Int>>()
        levelOderBfs(listOf(it), res)
        res
    } ?: listOf()
}

/**
 * 功能描述:
 * @Param: list 当前层的节点  res  结果
 * @Return:
 */
fun levelOderBfs(clevel: List<TreeNode>, res: MutableList<List<Int>>) {
    if (clevel.isEmpty()) return
    val thisRes = mutableListOf<Int>()
    val nextLevel = mutableListOf<TreeNode>()
    for (treeNode in clevel) {
        thisRes.add(treeNode.`val`)
        treeNode.left?.let { nextLevel.add(it) }
        treeNode.right?.let { nextLevel.add(it) }
    }
    res.add(thisRes)
    levelOderBfs(nextLevel, res)
}




