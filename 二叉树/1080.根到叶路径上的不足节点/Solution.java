// 1080. ����Ҷ·���ϵĲ���ڵ�
// ����ڵ�: ͨ���ڵ� node ��ÿ�ֿ��ܵ� ����-Ҷ�� ·����ֵ���ܺ�ȫ��С�ڸ����� limit����ýڵ㱻��֮Ϊ ����ڵ� ����Ҫ��ɾ����
// ˼·���������ղ���ڵ�Ķ��壬dfs����·����
// ��������ӣ����жϵ������Ƿ��и�Ҷ·��������Ŷ������������ֱ��node��null
// ˫����,�ж��Ƿ���ڸ�-Ҷ·������������ڸ�nodeΪnull���������һ��������һ������Ϊnull

public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        int val = dfs(root,limit,0);
        return val < limit? null:root;
    }
    public int dfs(TreeNode node, int limit,int cur){
        // Ҷ�ӽڵ�ֱ�ӷ���
        if(node.left  == null&& node.right == null){
            return cur + node.val;
        }
        // ��Ҷ�ӽڵ�ֺ����������д���
        if(node.left == null){
            int right = dfs(node.right,limit,cur+node.val);
            if(right < limit){
                node = null;
            }
            return right;
        }
        if(node.right == null){
            int left = dfs(node.left,limit,cur+node.val);
            if(left < limit){
                node = null;
            }
            return left;
        }
        cur+=node.val;
        int left = dfs(node.left,limit,cur);
        int right = dfs(node.right,limit,cur);
        // ˵����·��ͨ����һ����
        if(left < limit && right < limit){
            node = null;
        }else{ 
            if(left < limit){
                node.left = null;
            }
            if(right < limit){
                node.right = null;
            }   
        }
        return Math.max(left,right);
    }
}
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