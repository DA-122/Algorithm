// ����199. ������������ͼ
// ˼·������ Ҫ��Ӷ����·���ÿ�����һ������
// 1. BFS��ÿ�����һ��
// 2. DFS��ÿ����ȷ��ʵĵ�һ��
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    // ��α�����
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
    // ���������(������������������ÿ����ȵ�һ�����������ӽڵ�)
    // ��������Ҫһ����ϣ������¼���ӽڵ㣬��֤��һ������
    // Ȼ����Ҫ��¼ÿ���ڵ����ȣ���ջ����¼(ArrayDeque�������null�����Ҫ��LinkedList)
    // ��Ҫ��¼�����ȣ�������һ����ϣ�����б�ת��
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
    // �ݹ����ѣ����������Զ����·��ʣ�ͨ��ans.size��depth�Ĺ�ϵ���ж��Ƿ����ұߵ�һ���ڵ㣬������
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