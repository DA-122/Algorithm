/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// 力扣534 递归
// 思路分析：
// 其实是求每个节点左右孩子的最大深度
// 然后这两个深度和的最大值
public class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        res = Math.max(res,left + right);

        return Math.max(left,right) + 1;
    }
}