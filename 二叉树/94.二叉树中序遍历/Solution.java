import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 力扣94 中序遍历-左中右
public class Solution {
    // 递归法
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
    // 迭代法-栈
    public List<Integer> inorderTraversalIteration(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();  
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode node = root;
        stack.push(node);
        while(!stack.isEmpty()){
            // 判断是否为null避免重复遍历左子树
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
    // 迭代法 代码随想录版(指针加栈)
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
