package NC;

/**
 * 将一个节点数为 size 链表 m 位置到n 位置之间的区间反转，要求时间复杂度 O(n)，空间复杂度 O(1)。例如:
 * 给出的链表为1→2→3→4→5→NULL,m=2,n=4,返回1→4→3→>2→>5>NUL.
 * 数据范围: 链表长度0< size < 1000,0 < m <n< size，链表中每个节点的值满足 val < 1000要求:时间复杂度 O(n)，空间复杂度 O(n)进阶:时间复杂度 O(n)，空间复杂度 O(1)
 * 链表反转
 */
public class Nc21 {

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
         * @param head ListNode类
         * @param m    int整型
         * @param n    int整型
         * @return ListNode类
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;

            ListNode pre = dummyNode;
            for (int i = 0; i < m - 1; i++) {
                pre = pre.next;
            }

            ListNode rightNode = pre;
            for (int i = 0; i < n - m + 1; i++) {
                rightNode = rightNode.next;
            }

            ListNode cur = rightNode.next;
            ListNode leftNode = pre.next;

            pre.next = null;
            rightNode.next = null;

            reverseLinkedList(leftNode);

            pre.next = rightNode;
            leftNode.next = cur;

            return dummyNode.next;
        }

        public void reverseLinkedList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode nextNode = null;
            while (cur != null) {
                nextNode = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nextNode;
            }
        }
    }


}
