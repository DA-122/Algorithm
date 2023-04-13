// 力扣538.把二叉搜索树转换为累加树
// 题目分析： 累加树：每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
// 思路分析： 1.递归
// 2. 使用一个公共变量，反向中序遍历递归  时间O(N)  空间O(N)
// 3. 反向Morris中序遍历 时间O(N) 空间O(1);
public class Solution{
    public TreeNode convertBST(TreeNode root) {
        dfs(root,0);
        return root;
    }
    // 递归法(自底向下)
    public int dfs(TreeNode node,int parentSum){
        if(node == null){
            return 0;
        }
        // 先右边,后左边
        int rightSum = dfs(node.right,parentSum);
        int leftSum = dfs(node.left,node.val+rightSum+parentSum);
        // sum子树和
        int sum = rightSum+leftSum+node.val;
        node.val = rightSum+node.val+parentSum;
        return sum;
    }

    // 反序中序遍历（用一个全局变量解决问题）
    int sum = 0;
    public TreeNode convertBST2(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
    // Mirros遍历 反序遍历，实现O(N)复杂度
    public TreeNode convertBSTMorris(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null){
            if(cur.right==null){
                sum+=cur.val;
                cur.val = sum;
                cur = cur.left;
                continue;
            }
            pre = cur.right;
            while(pre.left!=null&&pre.left!=cur){
                pre = pre.left;
            }
            if(pre.left == null){
                pre.left = cur;
                cur = cur.right;
            }
            // 后继已经遍历过了
            if(pre.left == cur){
                pre.left = null;
                sum+=cur.val;
                cur.val = sum;
                cur = cur.left;
            }
        }
        return root;
    }
}