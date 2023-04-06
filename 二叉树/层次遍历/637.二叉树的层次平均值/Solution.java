// 力扣637. 二叉树层次平均值
// 思路分析：与层次遍历按层返回类似，每层计算平均值（需要注意防止溢出）
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<Double>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            double average = 0;
            for(int i = 0; i < n ; i++){
                TreeNode node = queue.poll();
                // 防止溢出
                average = average +(node.val-average)/(i+1);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            ans.add(average);
        }
        return ans;

    }
}