// 力扣104 二叉树深度
// 思路分析：深搜或广搜，
// 深搜 时间O(N) 空间O(LogN) 广搜时间 O(N) 空间O(N)
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // dfs递归写法
    public int maxDepthDFS(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode node){
        if(node==null)
            return 0;
        return Math.max(dfs(node.left)+1,dfs(node.right)+1);
    }
    // bfs写法
    public int maxDepthBFS(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        if(root == null)
            return 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
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