import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 力扣144 先序遍历-中左右

public class Solution {
    // 递归法
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
    // 迭代法-栈
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
            // 先push右，再push左
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
        return list;
    }
}
