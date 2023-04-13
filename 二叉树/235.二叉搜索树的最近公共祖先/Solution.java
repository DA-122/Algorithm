// 力扣235 二叉搜索树的最近公共祖先
// 思路分析: 二叉搜索树的最近公共祖先
// 对于当前节点来说，如果val > p&q, p q节点在当前节点左子树
// val < p&q，p q节点在当前节点右子树
// 否则就到了分叉点，就是题目所求
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        while(true){
            if(res.val > p.val && res.val > q.val){
                res = res.left;
            }else if(res.val < p.val && res.val < q.val){
                res = res.right;
            }else{
                break;
            }
        }
        return res;
    }
}
