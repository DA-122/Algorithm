// 力扣148. 排序链表
// 思路分析：题目要求O(nlogn)的时间复杂度
// 思路1. 堆排序（需要额外空间）
// 思路2. 直插 冒泡等(O(n^2))
// 思路3. 递归归并

import java.util.PriorityQueue;

class Sort {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->(a.val - b.val));
        ListNode node = head;
        while(node!=null){
            heap.offer(node);
            node = node.next;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!heap.isEmpty()){
            cur.next = heap.poll();
            cur = cur.next;
        }
        return dummy.next;
    }
    public ListNode sortList2(ListNode head) {
        return mergeSort(head,null);
    }
    public ListNode mergeSort(ListNode head, ListNode tail){
        if(head == null){
            return head;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        
        // 快慢指针法，寻找中间的结点
        ListNode fast =head;
        ListNode slow = head;
        while(fast!=tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid= slow;
        ListNode list1 = mergeSort(head, mid);
        ListNode list2 = mergeSort(mid,tail);
        return merge(list1,list2);
    }
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode cur1 = list1, cur2 = list2;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        if(cur1!=null){
            cur.next = cur1;
        }
        if(cur2!=null){
            cur.next = cur2;
        }
        return dummy.next;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(){

    }
    public ListNode(int value){
        val = value;
    }
}

public class Solution{
    public static void main(String[] args){
        int nums[] = {4,2,1,3};
        ListNode head= new ListNode(nums[0]);
        ListNode cur = head;
        for(int i = 1; i < nums.length; i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        Sort s = new Sort();
        s.sortList2(head);
    }
}