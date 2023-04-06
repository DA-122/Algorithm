import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// ����144 �������-������

public class Solution {
    // �ݹ鷨
    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorderTraversal(root,list);
        return list;
    }
    public void preorderTraversal(TreeNode node,List<Integer> list){
        if(node == null)
            return;
        list.add(node.val);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
    }
    // ������-ջ
    public List<Integer> preorderTraversalIteration(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            // ��push�ң���push��
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
        return list;
    }
}
