// ����116.
// ˼·��������Ŀ��˵��������Ϊ����������������ÿ�����ڵ㶼�����Һ��ӽڵ�
// 1. ��α���������poll���������һ�����ӵ�next��ָ���ͷ�����һ������ָ��null
// 2. ����left��right������next
//  (1) ����һ�ڵ����ӣ�node.left.next = node.right;
//  (2) �Һ��� ���ڵ㲻�Ǳ������һ���ڵ�:node.right.next = queue.peek().left
//             ���ڵ��Ǳ������һ���ڵ�: node.right.next = null;
// 3. �ⷨ3����ÿһ�㶼������һ������ʹ��һ�������Node���������²����
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // �ⷨ1
    public Node connect(Node root) {
        if(root==null)
            return root;
        Deque<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0;  i < n; i++){
                Node node = queue.poll();
                if(i!=n-1)
                    node.next = queue.peek();
                else
                    node.next = null;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
        }
        return root;
    }
    // �ⷨ2
    public Node connect��(Node root) {
        if(root==null)
            return root;
        Deque<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        root.next = null;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0;  i < n; i++){
                Node node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                    node.left.next = node.right;
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    if(i!=n-1)
                        node.right.next = queue.peek().left;
                    else
                        node.right.next = null;
                }
            }
        }
        return root;
    }
    public Node connect��(Node root) {
        if(root==null)
            return root;
        Node cur = root; 
        // ����ѭ�����ж��Ƿ�����������
        while(cur!=null){
            Node dummy = new Node(0);
            Node pre = dummy;
            // ѭ����ǰ��(����һ����dummyΪ�״�����)
            while(cur!=null){
                if(cur.left!=null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right!=null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            // 
            cur = dummy.next;
        }
        return root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}