// 力扣1019. 链表的下一个更大节点
// 思路分析:单调栈，由于此题数据结构是链表，因此需要用Pair来存储下标和值
public class Solution{
    public static int[] nextLargerNodes(ListNode head) {
        // 首先计算长度
        ListNode node = head;
        int length = 0;
        while(node!=null){
            length++;
            node = node.next;
        }
        node = head;
        
        // 使用Pair来存储位置和value
        int[] res = new int[length];
        Deque<Pair<Integer,Integer>> stack = new ArrayDeque<>();
        int pivot = 0;
        stack.push(new Pair(pivot,node.val));
        node = node.next;
        pivot++;
        while(node!=null){
            if(node.val <= stack.peek().getValue()){
                stack.push(new Pair(pivot,node.val));
            }else{
                while(!stack.isEmpty()&&node.val > stack.peek().getValue()){
                    res[stack.peek().getKey()] = node.val;
                    stack.pop();
                }
                stack.push(new Pair(pivot,node.val));
            }
            node = node.next;
            pivot++;
        }
        return res;
    }
    public static void main(String[] args){
    
    }
}