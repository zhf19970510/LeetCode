package myStudy;

/**
 * @author: 曾鸿发
 * @create: 2022-01-06 23:47
 * @description：两个链表依次按照数字累加方式进行链表合并
 **/
public class AddTwoNumberByLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2){
        int len1 = listLength(head1);
        int len2 = listLength(head2);

        ListNode l = len1 >= len2 ? head1 : head2;
        ListNode s = head1 == l ? head2 : head1;

        ListNode curL = l;
        ListNode curS = s;
        ListNode last = curL;
        int carry = 0;
        int curNum = 0;
        while (curS != null){
            curNum = curL.val + curS.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }

        while (curS != null){
            curNum = curL.val + carry;
            curL.val = curNum % 10;
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }

        if(carry != 0){
            last.next = new ListNode(1);
        }

        return l;
    }

    /**
     * 求链表长度
     * @param head
     * @return
     */
    public static int listLength(ListNode head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }

}



class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
