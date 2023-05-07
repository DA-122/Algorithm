// 力扣160.链表相交
// 思路分析： 1.哈希表
// 2.双指针（nodeA->headB nodeB->HeadA 两次遍历终将相遇）

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA !=null || nodeB!=null){
            if(nodeA == null){
                nodeA = headB;
            }
            if(nodeB == null){
                nodeB = headA;
            }
            if(nodeA == nodeB){
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
}