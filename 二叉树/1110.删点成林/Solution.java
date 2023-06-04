// 力扣1110.删点成林
// 思路分析： DFS递归删点
// 检测当前node是否是待删除节点
// 是：检测是否已经出现在list中，是先从listremove，然后把左右孩子放入到list中，再递归左右孩子
// 否：检测左右孩子是否是待删除结点，是的话就先置空然后递归孩子节点
//Definition for a binary tree node.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class Solution {
    Set<Integer> set = new HashSet<>();
    List<TreeNode> forest = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int num : to_delete){
            set.add(num);
        }
        forest.add(root);
        del(root);
        return forest;
    }
    public void del(TreeNode node){
        // 是待删除节点，先看自己是不是已经是根节点了，如果不是根，就把左右孩子送进去，是根先把自己从根移除。
        if(set.contains(node.val)){
            // node是根节点
            if(forest.contains(node)){
                forest.remove(node);
            }
            if(node.left!=null){
                forest.add(node.left);
                del(node.left);
            }
            if(node.right!=null){
                forest.add(node.right);
                del(node.right);    
            }
        }else{
            // 如果不是待删除节点，看左右孩子是不是，如果是，先删除左右孩子，然后将左右孩子分别进行递归
            TreeNode l = node.left;
            TreeNode r = node.right;
            if(l!=null){
                if(set.contains(l.val)){
                    node.left =null;
                }
                del(l);                
            }
            if(r!=null){
                if(set.contains(r.val)){
                    node.right = null;
                }
                del(r);
            }
        }
    }
}