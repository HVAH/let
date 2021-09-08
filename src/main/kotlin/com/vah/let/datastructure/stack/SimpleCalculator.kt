package com.vah.let.datastructure.stack;

/**
 *@Description 简单计算器 不带括号  输入一个表达式字符串  实现加减乘除运算 如"3+2*3-2" 输出6
 * 思路：使用两个stack
 *@Author HuangJiang
 **/
class SimpleCalculator {
    var numStack: ArrStack<Int> = ArrStack(0)
    var operStack: ArrStack<String> = ArrStack(0)

    fun oper(num1: Int, num2: Int, oper: String): Int {
        return when (oper) {
            "*" -> num1 * num2
            "/" -> num2 / num1
            "+" -> num1 + num2
            "-" -> num2 - num1
            else -> 0
        }
    }

    fun priority(oper: String): Int {
        return if (oper == "*" || oper == "/") {
            2
        } else if (oper == "-") {
            1
        } else if (oper == "+") {
            0
        } else {
            -1
        }
    }

    fun isOper(str: String): Boolean {
        return str == "*" || str == "/" || str == "+" || str == "-"
    }

    fun calculate(str: String): Int {
        val list = str.split(Regex("((?<=\\+)|(?=\\+)|(?<=\\*)|(?=\\*)|(?<=\\/)|(?=\\/)|(?<=\\-)|(?=\\-))"))
        numStack = ArrStack(list.size)
        operStack = ArrStack(list.size)
        var lastOper = ""
        for (i in list.indices) {
            var s = list[i]
            if (isOper(s)) {
                lastOper = s
                // 需要将减法运算改成加法运算
                if (s == "-") {
                    s = "+"
                }
                if (operStack.isEmpty()) {
                    // 操作符栈为空  直接入栈
                    operStack.push(s)
                } else {
                    if (priority(s) <= priority(operStack.getLast())) {
                        // 如果当前操作符的优先级小于等于栈中的操作符
                        // 就需要从数字栈中pop两个数字和从符号栈中pop一个运算符进行运算
                        // 将结果入数栈，当前的操作符入符号栈
                        val num1 = numStack.pop()
                        val num2 = numStack.pop()
                        val oper = operStack.pop()
                        val temp = oper(num1, num2, oper)
                        numStack.push(temp)
                        operStack.push(s)
                    } else {
                        // 直接入栈
                        operStack.push(s)
                    }
                }

            } else {
                // 数字直接入栈
                var num = s.toInt()
                // 需要将减法运算改成加法运算
                if (lastOper == "-") {
                    num = -num
                }
                numStack.push(num)
            }
        }
        // 表达式扫描完成后 顺序的从数字栈中pop两个数字和从符号栈中pop一个运算符进行运算 最后数栈中剩一个数字就是结果
        while (true) {
            if (numStack.size <= 1) {
                return numStack.getLast()
            }
            val num1 = numStack.pop()
            val num2 = numStack.pop()
            val oper = operStack.pop()
            val temp = oper(num1, num2, oper)
            numStack.push(temp)
        }
    }
}

fun main() {
    val simpleCalculator = SimpleCalculator()
    val result = simpleCalculator.calculate("5*4*4+3")
    println(result)
}
