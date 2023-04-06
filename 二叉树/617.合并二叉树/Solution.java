// 力扣617. 合并二叉树
// 思路分析： 递归
public class Solution {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = merge(root1,root2);
        return root;
    }
    public static TreeNode merge(TreeNode node1, TreeNode node2){
        if(node1==null ){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        TreeNode node = new TreeNode(node1.val + node2.val);
        node.left = merge(node1.left,node2.left);
        node.right = merge(node1.right,node2.right);
        return node;
    }
}
