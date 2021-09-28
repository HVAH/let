package com.vah.let;

/**
 *@Description 扩展方法
 *@Author HuangJiang
 **/
class Ex {
}

fun Any?.isNull(): Boolean {
    return this == null
}

fun Any?.isNotNull(): Boolean {
    return this != null
}
