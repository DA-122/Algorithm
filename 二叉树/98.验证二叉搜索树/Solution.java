// 力扣94 验证二叉搜索树
// 思路分析：二叉搜索树左孩子都小于根节点，右孩子都大于根节点
// 1.递归算法： 对于左孩子来说，左孩子的左孩子一定小于左孩子，左孩子的右孩子一定大于左孩子，但要小于根节点
// 因此可以设置上界和下界，对于左孩子的左孩子，下届为左孩子的下界，上界为左孩子
// 对于左孩子的右孩子，下届为左孩子，上界为根节点
// 2.中序遍历： 左中右顺序遍历，只需要判断是否当前节点大于中序遍历前一个节点，如果大于，则说明满足，否则返回false
// 结论：二叉搜索树的中序遍历一定是升序
public class Solution {
    // 递归算法
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    // 
    public boolean isValidBST(TreeNode node, long lower, long upper){
        if(node == null)
            return true;
        if(node.val <= lower || node.val >= upper)
            return false;
        return isValidBST(node.left,lower,node.val)&&isValidBST(node.right,node.val,upper);
    }
}