// 剑指24.反转链表
// 思路分析：1.迭代法： 用cur,curhead,curnext三个指针来迭代反转
// 2.递归法：
public class Solution{
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode curHead,curNext,cur;
        cur = null;
        curHead =head;
        curNext = curHead.next;
        while(curNext!=null){
            curHead.next = cur;
            cur = curHead;
            curHead = curNext;
            curNext = curHead.next; 
        }
        curHead.next = cur;
        return curHead;
    }
}