package com.vah.let.datastructure.tree;

/**
 *@Description 哈夫曼编码
 *@Author HuangJiang
 **/
class HuffmanCode {

}

fun main() {
//    val hNode = createTree("i like like java do you like java")
    val str = "i like like like java do you like java"
    val allCode = encode(str)
    println(allCode.length)
    println("编码========  $allCode")
    val code = getAllCode(str)
    val decode = mutableMapOf<String, Char>()
    code.forEach {
        decode[it.value] = it.key
    }
    var s = ""
    var i = 0
    while (i < allCode.length) {
        for (j in i + 1 .. allCode.length) {
            val substring = allCode.substring(i, j)
            val c = decode[substring]
            if (c != null) {
                s += c
                i = j
                break
            }
        }
    }
    println("解码========== $s")
}

/**
 * 功能描述: 得到每个字符对应的哈夫曼编码
 * @Param:
 * @Return: 返回字符对应的哈夫曼编码 如  a->001 i->002
 */
fun getAllCode(str: String): Map<Char, String> {
    val tree = createTree(str)
    val codes = mutableMapOf<Char, String>()
    getAllCode(tree, codes, "")
    return codes
}

fun getAllCode(hNode: HNode, codes: MutableMap<Char, String>, str: String) {
    val str = str.toString()
    if (hNode.char == null) { // 不是叶子节点
        hNode?.l?.let {
            getAllCode(it, codes, str + "0")
        }
        hNode?.r?.let {
            getAllCode(it, codes, str + "1")
        }
    } else {
        codes[hNode.char] = str
    }
}

/**
 * 功能描述: 将字符串转换成对应的哈夫曼编码
 * @Param:
 * @Return:
 */
fun encode(str: String): String {
    val allCode = getAllCode(str)
    val r = StringBuilder()
    for (i in str.indices) {
        r.append(allCode[str[i]])
    }
    return r.toString()
}

// 创建对应的哈夫曼树
fun createTree(str: String): HNode {
    val codes = str.groupBy { it }.map { HNode(it.key, it.value.size) }.sortedBy { it.count }.toMutableList()

    while (codes.size > 1) {
        val l = codes[0]
        val r = codes[1]
        val p = HNode(null, l.count + r.count)
        p.l = l
        p.r = r

        codes.remove(l)
        codes.remove(r)
        codes.add(p)
        codes.sortBy { it.count }
    }
    return codes[0]
}

class HNode(
    val char: Char?,
    var count: Int
) {
    var l: HNode? = null
    var r: HNode? = null

    fun beforeErgodic() {
        println(toString())
        l?.beforeErgodic()
        r?.beforeErgodic()
    }

    override fun toString(): String {
        return "HNode(char=$char, count=$count)"
    }
}


