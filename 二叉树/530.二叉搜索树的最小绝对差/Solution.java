// 力扣530. 二叉搜索树的最小绝对差
// 思路分析：二叉搜索树，左孩子比根小，右孩子比根大，中序遍历顺序为升序
// 中序遍历解题
public class Solution{
    public static  int getMinimumDifference(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        int lastVal = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;        
        while(!stack.isEmpty()||curNode!=null){
            if(curNode!=null){
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                curNode = stack.pop();
                ans = Math.min(ans,Math.abs(lastVal-curNode.val));
                lastVal = curNode.val;
                curNode = curNode.right;
            }
        }
        return ans;
    }
}