// ����1110.ɾ�����
// ˼·������ DFS�ݹ�ɾ��
// ��⵱ǰnode�Ƿ��Ǵ�ɾ���ڵ�
// �ǣ�����Ƿ��Ѿ�������list�У����ȴ�listremove��Ȼ������Һ��ӷ��뵽list�У��ٵݹ����Һ���
// �񣺼�����Һ����Ƿ��Ǵ�ɾ����㣬�ǵĻ������ÿ�Ȼ��ݹ麢�ӽڵ�
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
        // �Ǵ�ɾ���ڵ㣬�ȿ��Լ��ǲ����Ѿ��Ǹ��ڵ��ˣ�������Ǹ����Ͱ����Һ����ͽ�ȥ���Ǹ��Ȱ��Լ��Ӹ��Ƴ���
        if(set.contains(node.val)){
            // node�Ǹ��ڵ�
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
            // ������Ǵ�ɾ���ڵ㣬�����Һ����ǲ��ǣ�����ǣ���ɾ�����Һ��ӣ�Ȼ�����Һ��ӷֱ���еݹ�
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