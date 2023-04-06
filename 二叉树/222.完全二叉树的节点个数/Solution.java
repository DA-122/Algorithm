// 力扣222 完全二叉树的节点个数
// 解法1 BFS
// 解法2 DFS
// 解法3 探深度， 利用满二叉树性质,递归
// 完全二叉树左子树和右子树中一定有一个是满二叉树
// 完全二叉树的子树也是完全二叉树
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = 1;
        int rightDepth = 1;
        TreeNode left =root;
        TreeNode right = root;
        while(left.left!=null){
            leftDepth++;
            left = left.left;
        }
        while(right.right!=null){
            rightDepth++;
            right = right.right;
        }
        // 如果是满二叉树就返回节点个数
        if(leftDepth == rightDepth){
            return (int)Math.pow(2,leftDepth)-1;
        }
        // 不是满二叉树，则左子树和右子树+1
        return countNodes(root.left) + countNodes(root.right)+1;
    }
}