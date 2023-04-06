import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

// 力扣145 后序遍历-左右中
// 思路分析： 前序遍历 中左右，如果调换左右孩子入栈顺序变为中右左，再反转成左右中

public class Solution {
    // 递归
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
    // 迭代
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
