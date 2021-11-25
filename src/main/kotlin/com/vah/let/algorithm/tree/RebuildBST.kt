package com.vah.let.algorithm.tree

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
val index = mutableMapOf<Int, Int>()

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    for (i in inorder.indices) {
        index[inorder[i]] = i
    }
    return build(preorder, inorder, 0, 0, preorder.size - 1)
}

/**
 * root 当前节点在前序中的位置
 * left 子树在中序中的左边界
 * right 子树在中序中的右边界
 */
fun build(preorder: IntArray, inorder: IntArray,root: Int, left: Int, right: Int): TreeNode?{
    if (left > right) {
        return null
    }
    val p = preorder[root]
    val node = TreeNode(p)
    // 该父节点在中序中的位置
    val pIndex = index[p]!!
    // 创建左子树
    // 左子树的根位于前序中当前节点的后面一个 (父->左)  也就是root + 1
    // 左子树的在中序中的左边界就是当前的左边界
    // 左子树的右边界在中序遍历中为当前节点位置的前面一个 为pIndex - 1
    node.left = build(preorder, inorder, root + 1, left, pIndex - 1)

    // 创建右子树
    // 右子树的跟的位置 =  当前节点位置 + 左子节点的数量 + 1 = root + (pIndex - left) + 1
    // (pIndex - left) = 当前节点的位置-当前树的左边界 就是左节点的数量
    // 右子树的左边界就是当前节点在中序中位置的后面一个
    // 右子树的右边界就是当前的又边界
    node.right = build(preorder, inorder, root + (pIndex - left) + 1, pIndex + 1, right)
    return node
}
