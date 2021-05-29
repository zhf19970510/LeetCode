package leetcode02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        ListNode l12 = new ListNode(4);
//        ListNode l13 = new ListNode(3);
//        l12.next = l13;
//        l1.next = l12;
//
//
//        ListNode l21 = new ListNode(5);
//        ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(4);
//        l22.next = l23;
//        l21.next = l22;

//        ListNode l11 = new ListNode(9);
//        ListNode l12 = new ListNode(9);
//        ListNode l13 = new ListNode(9);
//        ListNode l14 = new ListNode(9);
//        ListNode l15 = new ListNode(9);
//        ListNode l16 = new ListNode(9);
//        ListNode l17 = new ListNode(9);
//
//        l11.next = l12;
//        l12.next = l13;
//        l13.next = l14;
//        l14.next = l15;
//        l15.next = l16;
//        l16.next = l17;
//
//        ListNode l21 = new ListNode(9);
//        ListNode l22 = new ListNode(9);
//        ListNode l23 = new ListNode(9);
//        ListNode l24 = new ListNode(9);
//
//        l21.next = l22;
//        l22.next = l23;
//        l23.next = l24;

        ListNode l1 = new ListNode(0);
        ListNode l21 = new ListNode(0);
        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(l1, l21);
        while (listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }

    }
}
