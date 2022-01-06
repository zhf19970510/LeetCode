package leetcode25;

public class Main {

    public static void main(String[] args) {

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

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }

    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null){
            start = start.next;
        }
        return start;
    }
}
