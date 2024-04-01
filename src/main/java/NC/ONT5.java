package NC;

/**
 * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素例口:
 * 给出的链表为1→2→3→3→4→4→5,返回1→2-5.
 * 给出的链表为1→1→1 2 →>3,返回2-> 3.
 * 数据范围:链表长度 0 < n< 10000，链表中的值满足 |val< 1000
 * 要求:空间复杂度 O(n)，时间复杂度 O(n)
 * 进阶:空间复杂度 O(1)，时间复杂度 O(n)
 */
public class ONT5 {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param head ListNode类
         * @return ListNode类
         */
        public ListNode deleteDuplicates (ListNode head) {
            if(head == null) {
                return null;
            }

            ListNode res = new ListNode(-1001);
            res.next = head;

            ListNode cur = res;
            while(cur.next != null && cur.next.next != null) {
                if(cur.next.val == cur.next.next.val) {
                    int temp = cur.next.val;
                    while (cur.next != null && cur.next.val == temp) {
                        cur.next = cur.next.next;
                    }
                }else {
                    cur = cur.next;
                }
            }
            return res.next;
        }
    }
}
