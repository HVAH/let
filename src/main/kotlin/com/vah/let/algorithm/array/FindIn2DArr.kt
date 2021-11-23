package com.vah.let.algorithm.array;

/**
 *@Description 从一个 大小为m x n的，值遵循行递增和列递增的矩阵中查找目标值
 *@Author HuangJiang
 **/
class FindIn2DArr {

}

/**
 * 行列排除法 O(m+n)
 */
fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
    // 判空
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return false;
    }
    // 行数和列数
    val l = matrix[0].size
    val r = matrix.size
    // 从最后一行第一列开始  该值上方的值都小于它  该值右边的元素都大于它
    // 该方式每次每次可以排除一行或者一列 所以时间复杂度为O(m+n)
    var i = r - 1
    var j = 0
    while (i >= 0 && j < l) {
        if (target == matrix[i][j]) {
            return true
        }
        if (target > matrix[i][j]) {
            // 该值上方的值都小于它 所以目标值不可能在这一列 j++
            j++
        } else { // target < matrix[i][j]
            // 该值右边的都大于它 说明目标值不可能在这一行 i--
            i--
        }
    }
    return false;
}
