// 力扣 1448 统计二叉树中的好节点
// 描述：好节点： 如果树节点X，从根到节点的路径上最大值不超过X，那么该节点就是好节点
// 思路分析： 递归法
class Solution {
    public int goodNodes(TreeNode root) {
        int res = dfs(root, Integer.MIN_VALUE);
        return res;
    }
    public int dfs(TreeNode root, int PathMax){
        if(root == null){
            return 0;
        }
        int res = 0;
        if(root.val >= PathMax){
            res++;
            PathMax = root.val;
        }
        res+= dfs(root.left,PathMax) + dfs(root.right, PathMax);
        return res;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }
}
