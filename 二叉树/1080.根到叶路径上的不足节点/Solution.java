// 1080. 根到叶路径上的不足节点
// 不足节点: 通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。
// 思路分析：按照不足节点的定义，dfs遍历路径，
// 如果单孩子，就判断单孩子是否有根叶路径满足体哦阿健，不满足直接node赋null
// 双孩子,判断是否存在根-叶路径，如果不存在赋node为null，如果存在一条，赋另一个孩子为null

public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        int val = dfs(root,limit,0);
        return val < limit? null:root;
    }
    public int dfs(TreeNode node, int limit,int cur){
        // 叶子节点直接返回
        if(node.left  == null&& node.right == null){
            return cur + node.val;
        }
        // 非叶子节点分孩子数量进行处理
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
        // 说明此路不通返回一个特
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