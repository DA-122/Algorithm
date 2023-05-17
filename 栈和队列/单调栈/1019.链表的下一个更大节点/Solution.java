// ����1019. �������һ������ڵ�
// ˼·����:����ջ�����ڴ������ݽṹ�����������Ҫ��Pair���洢�±��ֵ
public class Solution{
    public static int[] nextLargerNodes(ListNode head) {
        // ���ȼ��㳤��
        ListNode node = head;
        int length = 0;
        while(node!=null){
            length++;
            node = node.next;
        }
        node = head;
        
        // ʹ��Pair���洢λ�ú�value
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