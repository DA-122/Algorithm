// 力扣24 两两交换链表中的节点
// 思路：三指针
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null||head.next==null){
            return head;
        }
        ListNode newHead = head.next;
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            ListNode node = cur.next;
            cur.next = node.next;
            node.next = cur;
            if(pre!=null){
                pre.next = node;
            }
            pre = cur;
            cur = cur.next;
        }
        return newHead;
    }
}
class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { 
        val = x; 
    }
}