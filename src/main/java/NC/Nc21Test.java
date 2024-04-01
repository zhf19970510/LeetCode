package NC;

public class Nc21Test {
    public static void main(String[] args) {
        Nc21 nc21 = new Nc21();
        Nc21.ListNode head = nc21. new ListNode(1);
        Nc21.ListNode node2 = nc21. new ListNode(2);
        Nc21.ListNode node3 = nc21. new ListNode(3);
        Nc21.ListNode node4 = nc21. new ListNode(4);
        Nc21.ListNode node5 = nc21. new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Nc21.Solution solution = nc21. new Solution();
        Nc21.ListNode listNode = solution.reverseBetween(head, 2, 4);
        if(listNode != null) {
            while (listNode != null) {
                System.out.print(listNode.val + " ");
                listNode = listNode.next;
            }
        }
    }
}
