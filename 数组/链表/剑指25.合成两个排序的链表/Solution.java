public class Solution{    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // È¡¸ö¼ÙÍ·
        ListNode head = new ListNode();
        ListNode cur = head;
        while(l1!=null && l2!=null){
            if(l1.val >= l2.val){
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if(l1 ==null){
            cur.next = l2;
        }else{
            cur.next = l1;
        }
        return head.next;
    }
}
