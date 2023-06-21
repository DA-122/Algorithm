import java.util.PriorityQueue;

public class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for(int i = 0; i < lists.length; i++){
            if(lists[i] !=  null)
                heap.add(lists[i]);
        }
        if(heap.isEmpty()){
            return null;
        }

        ListNode head = heap.poll();
        ListNode curNode = head;
        if(curNode.next != null){
            heap.add(curNode.next);
        }
        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            curNode.next = node;
            curNode = curNode.next;
            if(node.next != null){
                heap.add(node.next);
            }
        }
        return head;
    }
    public static void main(String args[]){
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1,new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1,new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2,new ListNode(6));
        ListNode head = mergeKLists(lists);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}