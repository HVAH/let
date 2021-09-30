package com.vah.let.algorithm.string;

import java.util.Stack

/**
 *@Description 验证有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合
 *@Author HuangJiang
 **/
class ValidParentheses {
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    val map = mapOf<Char, Char>(
        '(' to ')',
        '[' to ']',
        '{' to '}'
    )
    for (c in s) {
        if (stack.isEmpty()) {
            stack.push(c)
        } else {
            when (c) {
                '(', '{', '[' -> { // 是左括号
                    stack.push(c)
                }
                else -> {
                    val top = stack.peek()
                    if (c != map[top]) {
                        return false
                    }
                    stack.pop()
                }
            }
        }
    }
    return stack.isEmpty()
}
