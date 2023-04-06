import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// ����94 �������-������
public class Solution {
    // �ݹ鷨
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(root,list);
        return list;
    }
    public void inorderTraversal(TreeNode node,List<Integer> list){
        if(node == null){
            return;
        }
        inorderTraversal(node.left,list);
        list.add(node.val);
        inorderTraversal(node.right,list);
    }
    // ������-ջ
    public List<Integer> inorderTraversalIteration(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();  
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode node = root;
        stack.push(node);
        while(!stack.isEmpty()){
            // �ж��Ƿ�Ϊnull�����ظ�����������
            if(node!=null){
                while(node.left!=null){
                    stack.push(node.left);
                    node = node.left;
                }
            }
            node  = stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
                node = node.right;
            }else{
                node = null;
            }
        }
        return list;
    }
    // ������ ��������¼��(ָ���ջ)
    public List<Integer> inorderTraversalIteration2(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode curNode = root;
        while(!stack.isEmpty()||curNode!=null){
            if(curNode!=null){
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                curNode = stack.pop();
                list.add(curNode.val);
                curNode = curNode.right;
            }
        }
        return list;
    }





}
