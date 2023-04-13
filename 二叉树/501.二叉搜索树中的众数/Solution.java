// 力扣501 二叉搜索树中的众数（进阶：优化到O(1)的空间复杂度）
// 思路分析：这里的二叉搜索树与一般的不同，左子树可以小于等于根，右子树可以大于等于根。
// 
import java.util.ArrayList;

public class Solution{
    int maxCount;
    int base;
    int count;
    ArrayList<Integer> answer = new ArrayList<>();
    // 第一种方法 递归中序遍历二叉搜索树，计算众数
    // 时间复杂度：O(n) 空间复杂度O(N)
    public int[] findMode(TreeNode root) {
        maxCount = 0;
        count = 0;
        base = 1000001;
        dfs(root);
        int[] ans = new int[answer.size()];
        for(int i = 0; i< ans.length;i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if(node.val == base){
            count++;
        }else{
            count = 1;
            base = node.val;      
        }
        if(count > maxCount){
            maxCount = count;
            answer.clear();
            answer.add(base);
        }else if (count == maxCount){
            answer.add(base);            
        }      
        dfs(node.right);
    }
    // 进阶：Morris中序,将空间复杂度由O(N)降到O(1)
    ArrayList<Integer> ans = new ArrayList<>();
    public int[] findMode2(TreeNode root) {

        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null){
            if(cur.left ==null){
                update(cur);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            // pre.right不是cur.val就是null
            while(pre.right!=cur && pre.right!=null){
                pre = pre.right;
            }
            if(pre.right == null){
                pre.right = cur;
                // 继续寻找前驱
                cur = cur.left;
            }
            // 遍历过前驱节点了,直接update当前节点，然后走right节点
            if(pre.right ==cur){
                update(cur);
                cur = cur.right;
            }
        }
        int [] res =new int [ans.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = ans.get(i);
        }
        return res;
        
    }
    void update(TreeNode cur){
        if(cur.val == base){
            count++;
        }else{
            count =1;
            base = cur.val;
        }
        if(count > maxCount){
            maxCount = count;
            ans.clear();
            ans.add(base);
        }else if(count == maxCount){
            ans.add(base);
        }
    }
}