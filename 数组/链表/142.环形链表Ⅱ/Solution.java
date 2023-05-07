// 力扣142. 环形链表Ⅱ 经典
// 快慢指针

public class Solution{   
    // 快慢指针 
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 快指针一次走两步,慢指针走一步
        // 假设当前位置是c >=a 则快指针走 f = 2s = c +nb, 慢指针走 s= c+mb
        // 快指针比慢指针多走 s = (n-m)b
        // 快慢指针分别走了 2(n-m) 和 (n-m)个b周长
        // 此时，如果让快慢指针分别走a长度，则找到环形入口，但是a未知
        // 将快指针指向head，快慢指针分别每次走一步，再次重逢时
        // 则 f = a , s = a + (n-m)b；
        // 得解
        while(fast!=null&&fast.next!=null&&fast!=slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null||fast.next ==null){
            return null;
        }
        fast = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    
    // 哈希表解法 
    public ListNode detectCycle1(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        ListNode node = head;
        int pos = -1;
        while(!map.containsKey(node)&&node!=null){
            pos++;
            map.put(node,pos);
            node = node.next;
        }
        if(pos == -1){
            return null;
        }else{
            return node;
        }
    }
}