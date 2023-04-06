import java.util.ArrayDeque;
import java.util.Deque;

// 力扣111 二叉树的最小深度
// 思路分析：递归DFS，迭代BFS
public class Solution {
    // dfs递归写法
    public int minDepth(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode node){
        if(node == null)
            return 0;
        if(node.left==null||node.right==null)
            return Math.max(dfs(node.left),dfs(node.right))+1;
        return Math.min(dfs(node.left),dfs(node.right))+1;
    }
    // BFS 找叶子节点
    public int minDepthⅡ(TreeNode root) {
        int depth = 0;
        if(root == null)
            return depth;
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i< n; i++){
                TreeNode node = queue.poll();
                // 如果发现叶子节点，直接返回深度
                if(node.left==null&&node.right==null){
                    return depth+1;
                }
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}