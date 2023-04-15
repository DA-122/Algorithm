// ��ָOffer34. �������к�Ϊĳһֵ��·��
// ˼·�� dfs�ݹ飬ע���֦�����鿽��
// bfs+��ϣ��洢���ڵ�+���д洢����ǰ�ڵ��·����

import java.util.List;
import java.util.ArrayList;

public class Solution {
    int target = 0;
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.target = target;
        dfs(root,0,new ArrayList<Integer>());
        return ans;
    }

    public void dfs(TreeNode node,int sum, List<Integer> list){
        if(node == null){
            return;
        }
        sum+=node.val;
        list.add(node.val);
        if(node.left!=null){
            dfs(node.left,sum,list);
            list.remove(list.size()-1);
        }
        if(node.right!=null){
            dfs(node.right,sum,list);
            list.remove(list.size()-1);
        }

        // Ҷ�ӽڵ�
        if(node.left ==null&&node.right==null){
            if(sum == target){
                List<Integer> temp = new ArrayList<>();
                for(int i: list){
                    temp.add(i);
                }
                ans.add(temp);
            }
        }
    }
}