public class Solution{
    public static void main(String[] args){
        S s = new S();
        // ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4, new ListNode(5)))));
        ListNode head = new ListNode(1,new ListNode(2));
        s.reverseKGroup(head,2);
    }
}

class S {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        ListNode pre = null;
        
        if(check(head, k)){
            for(int i = 0; i < k && node!=null ; i++){
                ListNode next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            }
        }else{
            return head;
        }

        ListNode newHead = pre;
        ListNode tail = head;
        pre = null;
        // Ñ­»··´×ª
        while(node != null){
            if(check(node, k)){
                head = node;
                for(int i = 0; i < k  && node!=null; i++){
                    ListNode next = node.next;
                    node.next = pre;
                    pre = node;
                    node = next;
                }
                tail.next = pre;
                tail = head;
                pre = null;

            }else{
                tail.next = node;
                break;
            }

        }
        return newHead;
    }
    public boolean check(ListNode head, int k){
        int cnt = 0;
        while(cnt < k && head != null){
            head = head.next;
            cnt++;
        }   
        return cnt == k;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int v){
        val = v;
    }
    ListNode(int v, ListNode n){
        val = v;
        next = n;
    }
}