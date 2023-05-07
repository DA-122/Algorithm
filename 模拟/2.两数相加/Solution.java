/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 力扣2. 两数相加（链表模拟）
// 模拟
// 使用Long会超出long

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curNode1 = l1;
        ListNode curNode2 = l2;
        ListNode head = new ListNode();
        ListNode cur = head;
        int div = 0;
        while(curNode1 != null&&curNode2 != null){
            ListNode node = new ListNode((curNode1.val+curNode2.val+div)%10);
            div = (curNode2.val+curNode1.val+div) / 10;
            cur.next = node;
            cur = node;
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }
        while(curNode1!=null){
            ListNode node = new ListNode((curNode1.val+div)%10);
            div = (curNode1.val + div)/10;
            cur.next = node;
            cur =node;
            curNode1 = curNode1.next;
        }
        while(curNode2!=null){
            ListNode node = new ListNode((curNode2.val+div)%10);
            div = (curNode2.val + div)/10;
            cur.next = node;
            cur =node;
            curNode2 = curNode2.next;
        }
        if(div!=0){
            cur.next = new ListNode(div);
        }
        return head.next;
    }
}