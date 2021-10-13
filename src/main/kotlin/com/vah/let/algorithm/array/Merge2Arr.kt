package com.vah.let.algorithm.array;

/**
 *@Description
 *  给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
    请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列
 *@Author HuangJiang
 **/
class Merge2Arr {
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    // 从后向前插入
    // nums2最后的比num1最后值比较，把大的值放到nums1的最后面（相对最后），然后把对应的索引向前移动
    var i = m -1
    var j = n -1
    var li = nums1.size - 1 // 插入的指针位置
    while (j >= 0) {
        if (i >= 0 && nums2[j] < nums1[i]) { //
            nums1[li] = nums1[i]
            li--
            i--
        } else {
            nums1[li] = nums2[j]
            j--
            li--
        }

    }
}
