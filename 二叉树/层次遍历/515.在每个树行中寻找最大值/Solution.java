// 力扣515.在每个树行中寻找最大值
// 思路分析：与层次遍历按层返回类似，获得每层最大值
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root==null)
            return ans;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n ; i++){
                TreeNode node = queue.poll();
                // 防止溢出
                max = Math.max(node.val,max);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            ans.add(max);
        }
        return ans;

    }
}