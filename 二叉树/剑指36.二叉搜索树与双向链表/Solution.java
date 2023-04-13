// 剑指36 二叉搜索树与双向链表
// 将二叉搜索树转化为排序的循环双向链表，链表头为最小元素
// 思路分析：二叉搜索树的中序遍历就是升序，中序遍历，每次将pop元素与 lastNode连接。
// 需要一个空头辅助
public class Solution{
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        Node head = new Node();
        Node lastNode = head;
        //中序遍历
        Deque<Node> stack = new ArrayDeque<>();
        Node curNode = root;
        while(!stack.isEmpty()||curNode!=null){
            if(curNode!=null){
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                curNode = stack.pop();
                lastNode.right = curNode;
                curNode.left = lastNode;
                lastNode =curNode;
                curNode = curNode.right;
            }
        }
        lastNode.right = head.right;
        head.right.left = lastNode;
        return head.right;
    }
}