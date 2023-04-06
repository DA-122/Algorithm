// 力扣110 平衡二叉树
// 思路分析 自底而上 记录状态
// 2 自顶而下
// 3 自底而上
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        Map<Boolean,Integer> map = new HashMap<Boolean,Integer>();
        getDepth(root,map);
        return !map.containsKey(false);
    }
    public int getDepth(TreeNode node, Map<Boolean,Integer> map){
        if(node == null)
            return 0;
        int leftDepth = getDepth(node.left,map);
        int rightDepth = getDepth(node.right,map);
        if(Math.abs(leftDepth-rightDepth) > 1){
            map.put(false,node.val);
        }
        return Math.max(leftDepth,rightDepth)+1;
    }
    // 自顶而下，从root开始判断自己是否平衡，左子树右子树是否平衡
    public boolean isBalanced2(TreeNode root){
        int lLength = dfs(root.left);
        int rLength = dfs(root.right);
        return Math.abs(lLength - rLength) <=1 && isBalanced2(root.left)&&isBalanced2(root.right);
    }
    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(dfs(node.left),dfs(node.right))+1;
    }
    // 自底而上 到每个节点先判断左右子树是否平衡，再判断自己是否平衡，只要有一个不平衡 返回-1
    public boolean isBalanced3(TreeNode root) {
        return balanced(root) != -1;
    }

    private int balanced(TreeNode node) {
        if (node == null) return 0;
        int leftHeight, rightHeight;
        if ((leftHeight = balanced(node.left)) == -1
                || (rightHeight = balanced(node.right)) == -1
                || Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}