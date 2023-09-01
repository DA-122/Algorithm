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
// ����230.�����������е�kС��Ԫ��
// ��������������������������еģ���˿����������+����
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