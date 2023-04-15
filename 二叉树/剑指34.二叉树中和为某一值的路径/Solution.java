// 剑指Offer34. 二叉树中和为某一值的路径
// 思路： dfs递归，注意剪枝和数组拷贝
// bfs+哈希表存储父节点+队列存储到当前节点的路径和

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

        // 叶子节点
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