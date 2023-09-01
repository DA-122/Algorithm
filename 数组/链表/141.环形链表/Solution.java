// ���� 141 ��������
// ˼·������ 1. ��ϣ��
// 2.����ָ��
public class Solution{
    public static void main(String[] args){
        S s = new S();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.print(s.hasCycle(head));
    }
}

// ����ָ�뷨
class S {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null && fast.next!=null && fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        return (fast == null || fast.next == null)? false:true;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int val){
        this.val = val;
    }
}