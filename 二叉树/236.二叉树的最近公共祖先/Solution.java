// 236. 二叉树的最近公共祖先
// 题目分析：最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
// 思路分析：p和q的最近公共祖先有以下两种情况:
// 1. p和q分别在node的左右子树
// 2. node就是p或q，q或p是其子树
// 递归解决问题，递归函数返回是否含有p或q
// 
// 哈希表存储父节点也能实现： 从根节点开始遍历整棵树，用哈希表存储每个节点的父节点
// 然后从p开始不断往上跳，记录访问到的节点，再从q不断往上跳,遇到的第一个p访问过的节点就是公共父节点
public class Solution{
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }
    public boolean dfs(TreeNode node,TreeNode p, TreeNode q){
        if(node == null){
            return false;
        }
        boolean l = dfs(node.left,p,q);
        boolean r = dfs(node.right,p,q);
        if((l&&r)|| (node.val == p.val || node.val == q.val) && (l || r)){
            ans = node;
        }
        return l||r||(node.val == p.val || node.val == q.val);
    }

}