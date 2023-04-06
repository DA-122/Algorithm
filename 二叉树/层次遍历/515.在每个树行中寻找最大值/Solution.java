// ����515.��ÿ��������Ѱ�����ֵ
// ˼·���������α������㷵�����ƣ����ÿ�����ֵ
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
                // ��ֹ���
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