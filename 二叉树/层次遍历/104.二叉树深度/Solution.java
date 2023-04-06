// ����104 ���������
// ˼·���������ѻ���ѣ�
// ���� ʱ��O(N) �ռ�O(LogN) ����ʱ�� O(N) �ռ�O(N)
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // dfs�ݹ�д��
    public int maxDepthDFS(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode node){
        if(node==null)
            return 0;
        return Math.max(dfs(node.left)+1,dfs(node.right)+1);
    }
    // bfsд��
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