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
// 力扣230.二叉搜索树中第k小的元素
// 二叉搜索树中序遍历是升序排列的，因此可以中序遍历+计数
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur  = root;
        int cnt = 0;
        int res = 0;
        while(!stack.isEmpty()|| cur!=null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                cnt++;
                if(cnt == k){
                    res = cur.val;
                    break;
                }
                cur = cur.right;
            }
        }
        return res;

    }
}