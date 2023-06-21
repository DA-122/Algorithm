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

 // 力扣114.二叉树展开为链表
 // 思路分析：
 // 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 // 且单链表应该与二叉树 先序遍历 顺序相同。先序遍历 中左右
 // 先序遍历，用一个变量存储中节点，不断更新即可
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode curNode = null;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(curNode!=null){
                // 更新左孩子和右孩子
                curNode.left = null;
                curNode.right = node;
            }
            // 拿到右子树
            if(node.right != null){
                stack.push(node.right); 
            }
            if(node.left != null){
                stack.push(node.left);
            }
            curNode = node;
        }
    }
}