public class Main {
    public static void main(String args[]){

    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
// ·­×ªÁ´±í
class Solution{
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;

        while(cur.next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;
        return cur;
    }
}
// ¶ÁÐ´Ëø
class Lock{
    int r = 0;
    int mutex = 0;
    int w = 0;
    public void rLock(){
        P(mutex);
            if(r == 0)
                P(w)
            
            r++;
        V(mutex)
        // ¶Á

        P(mutex)
            if(p == 1)
                V(w)
            
            r--
        V(mutex)
    }   
    public void wLock(){
        P(w)
            // write
        V(w)
    }
}