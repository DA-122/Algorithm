import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

// ����145 �������-������
// ˼·������ ǰ����� �����ң�����������Һ�����ջ˳���Ϊ�������ٷ�ת��������

public class Solution {
    // �ݹ�
    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> list =  new ArrayList<Integer>();
        postorderTraversal(root, list);
        return list;

    }
    public void postorderTraversal(TreeNode node,List<Integer> list){
        if(node == null)
            return;
        postorderTraversal(node.left, list);
        postorderTraversal(node.right, list);
        list.add(node.val);
    }
    // ����
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list =  new ArrayList<Integer>();
        if(root == null)
            return list;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left!=null)
                stack.push(node.left);
            if(node.right!=null)
                stack.push(node.right);
            list.add(node.val);
        }
        Collections.reverse(list);
        return list;
    }
}
