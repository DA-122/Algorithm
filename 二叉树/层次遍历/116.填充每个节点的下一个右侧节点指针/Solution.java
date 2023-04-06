// 力扣116.
// 思路分析：题目中说所给树均为完美二叉树，所以每个父节点都有左右孩子节点
// 1. 层次遍历，按层poll，不是最后一个孩子的next都指向队头，最后一个孩子指向null
// 2. 利用left，right来连接next
//  (1) 对于一节点左孩子，node.left.next = node.right;
//  (2) 右孩子 本节点不是本层最后一个节点:node.right.next = queue.peek().left
//             本节点是本层最后一个节点: node.right.next = null;
// 3. 解法3，将每一层都看作是一个链表，使用一个额外的Node来进行上下层更替
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // 解法1
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
    // 解法2
    public Node connectⅡ(Node root) {
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
    public Node connectⅢ(Node root) {
        if(root==null)
            return root;
        Node cur = root; 
        // 总体循环，判断是否遍历完二叉树
        while(cur!=null){
            Node dummy = new Node(0);
            Node pre = dummy;
            // 循环当前层(将下一层以dummy为首串起来)
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