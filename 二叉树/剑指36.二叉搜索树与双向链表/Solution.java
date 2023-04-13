// ��ָ36 ������������˫������
// ������������ת��Ϊ�����ѭ��˫����������ͷΪ��СԪ��
// ˼·������������������������������������������ÿ�ν�popԪ���� lastNode���ӡ�
// ��Ҫһ����ͷ����
public class Solution{
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        Node head = new Node();
        Node lastNode = head;
        //�������
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