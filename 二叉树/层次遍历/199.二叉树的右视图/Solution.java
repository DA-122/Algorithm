// 力扣199. 二叉树的右视图
// 思路分析： 要求从顶向下返回每层最后一个孩子
// 1. BFS，每层最后一个
// 2. DFS，每个深度访问的第一个
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    // 层次遍历法
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null)
            return ans;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0 ; i < n; i++){
                TreeNode node = queue.poll();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                if(i == n -1){
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }
    // 深度搜索法(深搜先搜右子树，找每个深度第一次遇到的右子节点)
    // 首先是需要一个哈希表来记录右子节点，保证第一次遇到
    // 然后需要记录每个节点的深度，用栈来记录(ArrayDeque不允许插null，因此要用LinkedList)
    // 需要记录最大深度，来进行一个哈希表向列表转化
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null)
            return ans;
        int maxDepth = -1;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Deque<Integer> depthStack = new LinkedList<Integer>(); 
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        depthStack.push(0);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int depth = depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);
            if(node != null){
                if(!map.containsKey(depth)){
                    map.put(depth,node.val);
                }
                stack.push(node.left);
                stack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }
        for(int i = 0; i < maxDepth; i++){
            ans.add(map.get(i));
        }
        return ans;
    }
    // 递归深搜，由于深搜自顶而下访问，通过ans.size和depth的关系来判断是否是右边第一个节点，很巧妙
    public List<Integer> rightSideViewDFSRecursion(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        dfs(root,ans,0);
        return ans;
    }
    public void dfs(TreeNode node,List<Integer> list, int depth){
        if(node == null)
            return;
        if(depth == list.size()){
            list.add(node.val);
        }
        dfs(node.right,list,depth+1);
        dfs(node.left,list,depth+1);
    }
    
}