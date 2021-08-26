package com.vah.let.algorithm.array;

/**
 *@Description 旋转数组
 *@Author HuangJiang
 **/
class MoveArr {
}

// 向右移动数组内的元素
/**
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
 */
fun moveArray(array: IntArray, step: Int) {
    var i = 0
    while (i < step) {
        var temp = array[0]
        for (j in 0..array.size - 2) {
            if (j == 0) {
                array[j] = array.last()
            }
            val temp2 = array[j + 1]
            array[j + 1] = temp
            temp = temp2
        }
        println(array.forEach { print(it) })
        i++
    }
}

// 临时数组copy
fun moveArray2(array: IntArray, step: Int) {
    val clone = array.clone()
    for (i in clone.indices) {
        array[(i + step) % clone.size] = clone[i]
    }
    array.forEach { print(it) }
}

// 反转  先全部反转  再局部反转
fun reverse(array: IntArray, step: Int) {
    reverse(array, 0, array.size - 1)
    reverse(array, 0, step - 1)
    reverse(array, step, array.size - 1)
    array.forEach { print(it) }
}

/**
 * 反转数组的元素
 */
fun reverse(array: IntArray, start: Int, end: Int) {
    var start = start
    var end = end
    while (start < end) {
        val temp = array[start]
        array[start++] = array[end]
        array[end--] = temp
    }
}

// 环形旋转
//
/**
 * 思路：从第1个元素开始 将其值赋值给第index = 1+step 的元素 原先的1+step值存起来  赋值给1+2step的位置 以此往复知道所有值被重新复制一遍
 * 注： 若 arr.size%step==0 index会回到原先已经被赋值的地方 就会原地打转  所以应当存储每个位置是否已经改变过 若改变过 index++ 并且循环次数增加一次
 */
fun annular(array: IntArray, step: Int) {
    var index = 0
    var hold = array[0]
    val size = array.size
    val isChange = BooleanArray(size)
    var i = 0
    while (i < size) {
        index = (index + step) % size
        if (isChange[index]) {
            index = (index + 1) % size
            hold = array[index]
            i--
        } else {
            isChange[index] = true
            val temp = array[index]
            array[index] = hold
            hold = temp
        }
        i++

    }
    array.forEach { print(it) }
}

fun main() {
    annular(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), 3)
}
