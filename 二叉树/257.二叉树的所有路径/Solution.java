import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
// 257.二叉树的所有路径
// 思路分析： 1. dfs遍历 时间O(N^2)，空间O（N^2）
// 2. bfs遍历
public class Solution {
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePathsDFS(TreeNode root) {
        String ans = "";
        dfs(root,ans);
        return list;
    }
    public void dfs(TreeNode node, String str){
        if(node.left == null && node.right ==null){
            str = str+String.valueOf(node.val);
            list.add(str);
            return;
        }
        str = str+String.valueOf(node.val)+"->";
        if(node.left!=null)
            dfs(node.left,str);
        if(node.right!=null)
            dfs(node.right,str);
        return;
    }
    public List<String> binaryTreePathsBFS(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<String> ans = new ArrayList<>();
        Deque<String> pathQueue = new ArrayDeque<String>();
        queue.offer(root);
        pathQueue.push("");
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            String str = pathQueue.poll();
            if(node.left!=null){
                queue.push(node.left);
                pathQueue.push(str+node.val+"->");
            }
            if(node.right!=null){
                queue.push(node.right);
                pathQueue.push(str+node.val+"->");
            }
            if(node.right==null&&node.left==null){
                str = str + node.val;
                ans.add(str);
            }
        }
        return ans;
    }
}
