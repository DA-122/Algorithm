/* Definition for a binary tree node.
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
// 力扣1026 节点与祖先之间的最大差值
// 思路分析：递归

public class Solution {
    int difference = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root.left,root.val,root.val);
        dfs(root.right,root.val,root.val);
        return difference;
    }
    public void dfs(TreeNode node, int max, int min){
        if(node == null){
            return;
        }
        max = Math.max(max,node.val);
        min = Math.min(min,node.val);
        difference = Math.max(max-min,difference);
        dfs(node.left,max,min);
        dfs(node.right,max,min);
    }
}