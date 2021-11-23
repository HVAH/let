package com.vah.let.algorithm.array;

/**
 *@Description 找出数组中任何一个重复的值 每个元素满足 0<= arr[i] <arr.length
 *@Author HuangJiang
 **/
class FindDuplicates {
}

/**
 * 下标跟值是一对多关系，建立下标与值的索引，即 i = arr[i]，
 * 当arr[i] == arr[arr[i]]时 即有重复
 */
fun ad(nums: IntArray): Int {
    var i = 0
    while (i < nums.size) {
        if (i == nums[i]) {
            i++
            continue
        }
        if (nums[i] == nums[nums[i]]) {
            return nums[i]
        } else {
            val t = nums[i]
            nums[i] = nums[t]
            nums[t] = t
        }
    }
    return -1
}
