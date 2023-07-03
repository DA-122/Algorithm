import java.util.ArrayDeque;
import java.util.Deque;
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
// 445.两数相加Ⅱ
// 思路分析：1. 翻转链表，然后两数相加，
// 2. 不可翻转怎么办，使用栈
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseLinkedList(l1);
        l2 = reverseLinkedList(l2);
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        int pre = 0;
        while(l1 !=null && l2!=null){
            int val = l1.val + l2.val + pre;
            pre = val / 10;
            val = val % 10;
            node.next = new ListNode(val);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int val = pre + l1.val;
            pre = (val) / 10;
            val = (val) % 10;
            node.next = new ListNode(val);
            node = node.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int val = pre + l2.val;
            pre = (val) / 10;
            val = (val) % 10;
            node.next = new ListNode(val);
            node = node.next;
            l2 = l2.next;
        }
        if(pre != 0){
            node.next = new ListNode(pre);
        }


        return reverseLinkedList(dummy.next);

    }

    public ListNode reverseLinkedList(ListNode root){
        ListNode pre = root, node = root.next;
        pre.next = null;
        while(node !=null){
            ListNode cur = node.next;
            node.next = pre;
            pre = node;
            node = cur;            
        }
        return pre;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        
        while(l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }        
        while(l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode();
        ListNode node = dummy;
        int pre  = 0;

        while(!stack1.isEmpty()&& !stack2.isEmpty()){
            l1 = stack1.pop();
            l2 = stack2.pop();
            int val = l1.val + l2.val + pre;
            pre = val / 10;
            val = val % 10;
            node.next = new ListNode(val); 
            node = node.next;
        }
        while(!stack1.isEmpty()){
            l1 = stack1.pop();
            int val = l1.val + pre;
            pre = val / 10;
            val = val % 10;
            node.next = new ListNode(val); 
            node = node.next;
            
        }
        while(!stack2.isEmpty()){
            l2 = stack2.pop();
            int val = l2.val + pre;
            pre = val / 10;
            val = val % 10;
            node.next = new ListNode(val); 
            node = node.next;
        }
        if(pre != 0){
            node.next = new ListNode(pre);
            node = node.next;
        }
        
        node = dummy.next;
        while(node != null){
            stack1.push(node);
            node = node.next;
        }
        node = dummy;
        while(!stack1.isEmpty()){
            node.next = stack1.pop();
            node = node.next;
        }
        node.next = null;
        return dummy.next;
    }
}