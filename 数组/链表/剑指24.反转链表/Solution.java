// ��ָ24.��ת����
// ˼·������1.�������� ��cur,curhead,curnext����ָ����������ת
// 2.�ݹ鷨��
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