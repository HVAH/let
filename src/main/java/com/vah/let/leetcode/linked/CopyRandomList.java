package com.vah.let.leetcode.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 剑指 Offer 35. 复杂链表的复制
 * @Author Jiang
 * @Date 2021/10/26 6:35 下午
 **/
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        Node t = head;
        Map<Integer, Node> map = new  HashMap<Integer,Node>();
        while (t != null) {
            map.put(t.val, new Node(t.val));
            t = t.next;
        }
        t = head;
        Node newHead = map.get(t.val);
        newHead.random = t.random == null ? null : map.get(t.random.val);
        Node tt = newHead;
        t = t.next;
        while (t!=null) {
            Node node = new Node(t.val);
            node.next = t.next == null ? null : map.get(t.next.val);
            node.random = t.random == null ? null : map.get(t.random.val);
            tt.next = node;
            tt = node;
            t = t.next;
        }
        return newHead;
    }

}
