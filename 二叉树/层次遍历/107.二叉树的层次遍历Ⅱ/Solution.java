// 力扣107. 二叉树层次遍历Ⅱ
// 思路分析：要求二叉树从叶子结点开始自底向上从左向右按层返回节点值
// 可以用栈记录102中的列表，然后出栈进数组；或者直接反转数组；或者头插每层节点列表。
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null)
            return ans;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < n ; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            ans.add(0,list);
        }
        return ans;

    }
}