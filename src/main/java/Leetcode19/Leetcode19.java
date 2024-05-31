package Leetcode19;

import leetcode02.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {


        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            map.put(i++, cur);
            cur =cur.next;
        }

        int index = map.size() - n;

        if(index == 0) {
            return head.next;
        }
        ListNode preNode = map.get(index - 1);
        preNode.next = preNode.next.next;
        return head;
    }
}
