package NC;

/**
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 数据范围:0<n< 1000，-1000< 节点值< 1000
 * 要求:空间复杂度 O(1)，时间复杂度 O(n)
 */
public class Bm4 {

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
         * @param pHead1 ListNode类
         * @param pHead2 ListNode类
         * @return ListNode类
         */
        public ListNode Merge (ListNode pHead1, ListNode pHead2) {
            // write code here
            if(pHead1 == null) {
                return pHead2;
            }
            if(pHead2 == null) {
                return pHead1;
            }
            if(pHead1.val > pHead2.val) {
                ListNode tmpNode1 = pHead1;
                pHead1 = pHead2;
                pHead2 = tmpNode1;
            }
            ListNode cur1 = pHead1;
            ListNode cur2 = pHead2;
            ListNode pre = null;
            ListNode next = null;
            while(cur1 != null && cur2 != null) {
                if(cur1.val <= cur2.val) {
                    pre = cur1;
                    cur1 = cur1.next;
                }else {
                    next = cur2.next;
                    cur2.next = cur1;
                    pre.next = cur2;
                    pre = cur2;
                    cur2 = next;

                }
            }
            if(cur2 != null) {
                pre.next = cur2;
            }

            return pHead1;
        }
    }
}
