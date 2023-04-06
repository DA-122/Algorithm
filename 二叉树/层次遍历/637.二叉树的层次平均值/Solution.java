// ����637. ���������ƽ��ֵ
// ˼·���������α������㷵�����ƣ�ÿ�����ƽ��ֵ����Ҫע���ֹ�����
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
                // ��ֹ���
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