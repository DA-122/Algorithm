import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    // 递归 左左比右右， 左右比右左
    public boolean isSymmetricRecursion(TreeNode root) {
        return isChildSymmetric(root.left,root.right);
    }
    public boolean isChildSymmetric(TreeNode left, TreeNode right){
        if(left == null&& right==null)
            return true;
        if(left == null || right == null)
            return false;
        boolean isCild = isChildSymmetric(left.left,right.right)&&isChildSymmetric(left.right,right.left);
        return left.val== right.val && isCild;
    }
    // 迭代 队列，队头两个元素是对称的两个元素
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode first= queue.poll();
            TreeNode second = queue.poll();
            if(first==null && second ==null){
                continue;
            }
            if(first ==null || second ==null){
                return false;
            }
            if(first.val!=second.val){
                return false;
            }
            queue.offer(first.left);
            queue.offer(second.right);
            queue.offer(first.right);
            queue.offer(second.left);
        }
        return true;
    }
}
