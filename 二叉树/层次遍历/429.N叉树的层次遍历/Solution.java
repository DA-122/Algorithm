// 力扣429，N叉树层次遍历
// 思路分析： N叉树且要求按层返回节点值，与二叉树类似
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }
        Deque<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < n; i++){
                Node node = queue.poll();
                level.add(node.val);
                for(Node child: node.children){
                    queue.offer(child);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}