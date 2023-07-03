// 437.路径总和Ⅲ
// 思路分析: 枚举所有的路径，然后选择满足条件的路径
// 1. 递归，
// 2. 前缀和

// 递归解决
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

    // 以root为根节点 满足条件的结果数
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