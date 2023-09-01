// ���� 1448 ͳ�ƶ������еĺýڵ�
// �������ýڵ㣺 ������ڵ�X���Ӹ����ڵ��·�������ֵ������X����ô�ýڵ���Ǻýڵ�
// ˼·������ �ݹ鷨
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
