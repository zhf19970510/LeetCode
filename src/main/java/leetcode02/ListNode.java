package leetcode02;

/**
 * leetcode:
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题思路：
 * 1. 同时对两个链表依次遍历，对当前每一位的累加和和上一次进位相加
 *        对10取模就是当前位的结果，对10做除法的结果就是作为下一次的进位结果
 * 2. 如果遍历到有一个链表为空，那么结束两个链表的遍历，只对其中一个还没有遍历完的链表继续遍历，
 *        取出当前位和上一次进位的和，同上，对10取模就是当前位的结果，对10做除法的结果就是作为下一次的进位结果
 * 3. 遍历到结尾，如果还有进位，那么也要将该进位添加到结果链表之中
 * 4. 每次得到的当前位结果依次加入到结果链表末位
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode rootResult = null;
        int carry = 0;
        while (l1  != null && l2 != null){
            int tempTotal = l1.val + l2.val;

            if(rootResult == null){
                rootResult = new ListNode((tempTotal + carry) % 10);
            }
            else{
                ListNode newNode = new ListNode((tempTotal + carry) % 10);
                ListNode resultTmp = rootResult;
                while (resultTmp.next != null){
                    resultTmp = resultTmp.next;
                }
                resultTmp.next = newNode;
            }
            carry = (tempTotal + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            ListNode newNode = new ListNode((l1.val + carry) % 10);
            ListNode resultTmp = rootResult;
            while (resultTmp.next != null){
                resultTmp = resultTmp.next;
            }
            resultTmp.next = newNode;
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
        }
        while (l2 != null){
            ListNode newNode = new ListNode((l2.val + carry) % 10);
            ListNode resultTmp = rootResult;
            while (resultTmp.next != null){
                resultTmp = resultTmp.next;
            }
            resultTmp.next = newNode;
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            ListNode resultTmp = rootResult;
            while (resultTmp.next != null){
                resultTmp = resultTmp.next;
            }
            resultTmp.next = newNode;
        }
        return rootResult;
    }
}
