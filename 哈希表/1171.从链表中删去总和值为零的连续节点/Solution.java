// 力扣1171. 从链表中删去总和值为零的连续节点
// 思路分析：哈希记录前缀和，当有前缀和相同时，删除当前节点和哈希表中保留节点之间的节点，并维护哈希表
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static ListNode removeZeroSumSublists(ListNode head) {
        // ArrayList<ListNode> list = new ArrayList<>();
        Map<Integer,ListNode> map = new HashMap<>();
        // 使用一个虚头
        ListNode virtual = new ListNode();
        virtual.next = head;
        int sum = 0;
        map.put(sum,virtual);
        ListNode node = head;
        while(node !=null){
            sum+=node.val;
            if(map.containsKey(sum)){
                ListNode pre = map.get(sum).next;
                int curSum = sum;
                // 循环删除中间的哈希节点
                while(pre!=node){
                    curSum += pre.val;
                    map.remove(curSum);
                    pre = pre.next;
                }
                map.get(sum).next = node.next;
            }else{
                map.put(sum,node);
            }
            node = node.next;
        }
        return virtual.next;
    }
    public static void main(String[] args){
        int nums[] = {1,3,2,-3,-2,5,5,-5,1};
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(int i = 1; i < nums.length; i++){
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        removeZeroSumSublists(head);
    }
}
class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  
}