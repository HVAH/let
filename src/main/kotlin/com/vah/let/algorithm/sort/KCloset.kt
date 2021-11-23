package com.vah.let.algorithm.sort

/**
 * 距离原点最近的点
 */
fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    if(k == 0 || points.size == 0) {
        return arrayOf()
    } else if (k == points.size) {
        return points
    }
    return qs(points, 0, points.size - 1, k)
}

fun qs(arr: Array<IntArray>, l:Int, r:Int, k:Int): Array<IntArray> {
    val p = getPartion2(arr, l, r)
    if(p == k) {
        return arr.copyOf(p) as Array<IntArray>
    }
    return if(p > k) qs(arr, l , p- 1, k) else qs(arr, p+1, r, k)
}

fun getPartion2(arr: Array<IntArray>, l: Int, r: Int): Int {
    val key = sqrt(arr[l])
    val keyl = arr[l]
    var l = l
    var r = r
    while(l < r) {
        while(l < r && sqrt(arr[r]) >= key) {
            r--
        }
        arr[l] = arr[r]
        while(l < r && sqrt(arr[l]) < key) {
            l++
        }
        arr[r]=arr[l]
    }
    arr[l] = keyl
    return l
}

fun sqrt(arr: IntArray):Double {
    val x = arr[0].toDouble()
    val y = arr[1].toDouble()
    return Math.sqrt(x * x + y * y)
}
