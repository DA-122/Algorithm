public class Solution{

    // 双指针 时间O（M+N）  空间O(1)
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int a = 0;
        int b = 0;
        while(nodeA!=null){
            a++;
            nodeA = nodeA.next;
        }
        while(nodeB!=null){
            b++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        while(a > b){
            nodeA = nodeA.next;
            a--;
        }
        while(b > a){
            nodeB = nodeB.next;
            b--;
        }
        while(nodeA!=null&&nodeB!=null){
            if(nodeA == nodeB) 
                return nodeA;
            else{
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
        }
        return null;

    }
    // 双指针
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA != nodeB){
            nodeA = (nodeA==null? headB: nodeA.next);
            nodeB = (nodeB==null? headA: nodeB.next); 
        }
        return nodeA;
    }
    // 哈希表
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB){
        Set<ListNode> set = new HashSet<>();
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA!=null){
            set.add(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB!=null){
            if(set.add(nodeB))
                nodeB = nodeB.next;
            else
                break;
        }
        return nodeB;
    }
    public static void main(String[] args){
    
    }
}