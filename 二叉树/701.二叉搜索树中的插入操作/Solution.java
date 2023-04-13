// 力扣701 二叉搜索树中的插入操作
// 思路分析：利用二叉搜索树的性质
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        TreeNode curNode =root;
        TreeNode lastNode =curNode;
        while(curNode!=null){
            lastNode = curNode;
            if(val > curNode.val){
                curNode = curNode.right;
            }else{
                curNode = curNode.left;
            }
        }
        if(val > lastNode.val){
            lastNode.right = new TreeNode(val);
        }else{
            lastNode.left = new TreeNode(val);
        }
        return root;
    }
}
