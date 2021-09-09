package com.vah.let.datastructure.stack;

import java.util.Stack

/**
 *@Description  前后缀表达式计算器   中缀转后缀表达式
 * 1 逆波兰表达式求值
 * 2 波兰表达式求值  大致与上面相同 只不过要从右至左扫描表达式
 *@Author HuangJiang
 * 手动转换
 * 第一步：按照运算符的优先级对所有的运算单位加括号~
    式子变成拉：((a+(b*c))-(d+e))
    第二步：转换前缀与后缀表达式
    前缀：把运算符号移动到对应的括号前面
    则变成拉：-( +(a *(bc)) +(de))
    把括号去掉：-+a*bc+de  前缀式子出现
    后缀：把运算符号移动到对应的括号后面
    则变成拉：((a(bc)* )- (de)+ )-
    把括号去掉：abc*-de+-  后缀式子出现
 **/
class ComplexCalculator {
}

fun main() {
    // (3+4)*5-6 -> 后缀 3 4 + 5 * 6 -
    val decompositionExpression = "3 4 + 5 * 6 -".split(" ")
    val transfer2After = transfer2After("(3+7)/5-6")
    println(afterCal(transfer2After))
}

/**
 * 逆波兰表达式求值:
 * 从左到右扫苗表达式  是数字就直接入栈  是运算符就弹出两个数字用当前运算符计算(次顶数字 运算符 栈顶数字) 并将结果入栈。重复以上步骤 最后运算的值就是结果
 */
fun afterCal(strList: List<String>): Int {
    val stack = Stack<Int>()
    var result = 0
    for (s in strList) {
        if (isOper(s)) {
            val num1 = stack.pop()
            val num2 = stack.pop()
            result = oper(num1, num2, s)
            stack.push(result)
        } else {
            stack.push(s.toInt())
        }
    }
    return result
}

/**
 * 输入中缀表达式 输出分隔好的后缀表达式
 * 转换思路：
 * 1 两个栈 运算符栈s1 中间结果栈s2
 * 2 从左至右扫描中缀表达式
 * 3 遇到数字 压入 s2、
 * 4 遇到运算符 比较其与s1栈顶运算符的优先级
 *      4.1 若果s1为空，或者栈顶符号为'('时，直接将此运算符入栈
 *      4.2 否则 若优先级比栈顶运算符优先级高，也入栈
 *      4.3 否则 s1栈顶符号压入s2中，然后循环 4.1
 * 5 遇到括号
 *      5.1 如果是'('，直接入s1
 *      5.2 是')'，则依次弹出s1元素,入栈s2，直到弹出')'，此时相当于消除了一对括号
 * 6 重复2~5
 * 7 将s1依次弹栈并入栈s2
 * 8 依次弹栈s2，结果的逆序就是对应的后缀表达式
 */
fun transfer2After(str: String) : List<String> {
    // 分割中缀表达式
    val expression = decompositionExpression(str)
    val s1 = Stack<String>()
    val s2 = Stack<String>()
    // 转换为后缀表达式
    for (s in expression) {
        when(s) {
            "+","-","*","/" -> { // 运算符
                while (true) {
                    if (s1.empty() || s1.peek() == "(") {
                        s1.push(s)
                        break
                    } else {
                        if (priority(s) > priority(s1.peek())) {
                            s1.push(s)
                        } else {
                            s2.push(s1.pop())
                        }
                    }
                }
            }
            "(" -> { // 左括号
                s1.push(s)
            }
            ")" -> { // 右括号
                while (true) {
                    val top = s1.pop()
                    if (top == "(") {
                        break
                    } else {
                        s2.push(top)
                    }
                }
            }
            else ->{ // 数字
                s2.push(s)
            }
        }
    }
    while (!s1.empty()) {
        s2.push(s1.pop())
    }
    return s2.toList()
}

fun isOper(str: String): Boolean {
    return str == "*" || str == "/" || str == "+" || str == "-"
}



fun oper(num1: Int, num2: Int, oper: String): Int {
    return when (oper) {
        "*" -> num1 * num2
        "/" -> num2 / num1
        "+" -> num1 + num2
        "-" -> num2 - num1
        else -> 0
    }
}

// 返回操作符优先级
fun priority(oper: String): Int {
    return when(oper) {
        "*","/" -> 1
        "+","-" -> 0
        else -> -1
    }
}


// 分解表达式 将数字运算符括号分开
fun decompositionExpression(str: String): List<String> {
    return str.split(Regex("((?<=\\+)|(?=\\+)|(?<=\\*)|(?=\\*)|(?<=\\/)|(?=\\/)|(?<=\\-)|(?=\\-)|(?<=[()])|(?=[()]))")).filter { it != "" }
}
