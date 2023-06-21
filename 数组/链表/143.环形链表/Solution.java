// 力扣141.环形链表
// 思路分析： 快慢指针
// 或者哈希表
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode node1 = head.next;
        ListNode node2 = head;
        while(node1!=null && node1!=node2){
            if(node1.next !=null){
                node1 = node1.next.next;
            }else{
                node1 = node1.next;
                break;
            }
            node2 = node2.next;
        }
        return node1 != null;
    }
}