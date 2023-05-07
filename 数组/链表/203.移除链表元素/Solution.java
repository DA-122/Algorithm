// 力扣 208 移除链表元素
// 思路分析：注意头部元素移除
// node.next.val = val      node.next = node.next.next

public class Solution{
    public ListNode removeElements(ListNode head, int val) {
        //先删除头
        while(head!=null&&head.val == val){
            head = head.next;
        }
        ListNode node = head;
        if(node == null)
            return null;
        while(node.next!=null){
            if(node.next.val == val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
        return head;
    }
}

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { 
        val = x; 
    }
}