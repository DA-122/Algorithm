// ����102 ��α���
// ˼·������ ����ͨBFS��ͬ������Ҫ�󰴲㷵�ؽڵ�ֵ�������Ҫÿ�δ���һ������нڵ�
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            ans.add(list);
        }
        return ans;

    }
}