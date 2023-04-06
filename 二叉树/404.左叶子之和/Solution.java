public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left == null && root.right ==null){
            return 0;
        }
        int ans = dfs(root);
        return ans;
    }
    public int dfs(TreeNode node){
        // Ҷ�ӽڵ�ŷ���ֵ
        if(node.left ==null && node.right==null){
            return node.val;
        }
        int l = 0, r =0;
        if(node.left!=null)
            l = dfs(node.left);
        if(node.right!=null){
            // �������Ҷ�ӽڵ�
            if(node.right.left==null&&node.right.right==null){
                r = 0;
            }else{
                r = dfs(node.right);
            }
        }
        return l+r;
    }
}