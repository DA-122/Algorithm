// 力扣669. 修剪二叉搜索树
// 题目分析：给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
// 修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
// 思路分析： 递归裁剪左右孩子
public class Solution {
    int low = 0;
    int high = 0;
    public TreeNode trimBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high =high;
        TreeNode cur = root;
        // 先寻找到一个根节点处于low和high之间
        while(cur!=null && (cur.val < low || cur.val > high)){
            if(cur.val < low){
                cur = cur.right;
            }
            if(cur.val > high){
                cur = cur.left;
            }
        }
        // 如果cur = null 说明找不到合适的根，返回null
        if(cur == null){
            return null;
        }
        
        // 找到合适的根节点后，分别裁剪左右孩子
        // 此时 low <= cur <= high 但仍有以下情况
        // 对于cur.left来说，一定满足 cur.left < high 但无法满足cur.left > low
        // 对于cur.right来说，一定满足cur.right > low 但无法满足cur.right < high
        cur.left = trimLeft(cur.left);
        cur.right = trimRight(cur.right);
        return cur;

    }
    // 裁剪右子树
    public TreeNode trimRight(TreeNode cur){
        if(cur == null){
            return null;
        }
        // 比high大，要看左子树
        if(cur.val > high){
            return trimRight(cur.left);
        }else{
            cur.right = trimRight(cur.right);
            return cur;
        }
    }
    // 裁剪左子树
    public TreeNode trimLeft(TreeNode cur){
        if(cur == null){
            return null;
        }
        // 比low小,要看右子树
        if(cur.val < low){
            return trimLeft(cur.right);
        }else{
            cur.left = trimLeft(cur.left);
            return cur;
        }
    }

    // 精简版递归
    public TreeNode trimBSTSimple(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
    


}