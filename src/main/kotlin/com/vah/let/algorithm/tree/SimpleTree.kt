package com.vah.let.algorithm.tree;

import kotlin.math.max

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
    return root?.let { Math.max(root?.left?.let { maxDepth(it) }?: 0, root?.right?.let { maxDepth(it) }?: 0) + 1} ?: 0
}

