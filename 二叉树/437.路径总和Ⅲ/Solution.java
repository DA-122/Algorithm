// 437.·���ܺ͢�
// ˼·����: ö�����е�·����Ȼ��ѡ������������·��
// 1. �ݹ飬
// 2. ǰ׺��

// �ݹ���
public class Solution {
    // 
    public int pathSum(TreeNode root, int targetSum) {
        long target = targetSum;
        if(root == null)
            return 0;
        long res = dfs(root,target);
        res+= pathSum(root.left,targetSum);
        res+= pathSum(root.right, targetSum);
        return (int)res;
    }   

    // ��rootΪ���ڵ� ���������Ľ����
    public long dfs(TreeNode root, long targetSum){
        int res = 0;

        if(root == null){
            return 0;
        }
        long val = root.val;
        if(val == targetSum){
            res++;
        }
        res += dfs(root.left, targetSum - val);
        res += dfs(root.right, targetSum - val);    
        
        return res;
    }
}