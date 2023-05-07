 // 力扣19.删除链表的倒数第N个节点
 // 思路分析：快慢指针
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode cur = head;
        for(int i = 0;node!=null&&i < n; i++){
            node = node.next;
        }
        if(node == null){
            return head.next;
        }
        while(node.next!=null){
            node = node.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }   
}
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}