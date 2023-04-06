// 力扣653.最大二叉树
// 思路分析：1.递归构建
// 2.单调栈
public class Solution {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        int max = findMax(nums,0,nums.length-1);
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructChild(nums,0,max-1);
        root.right = constructChild(nums,max+1,nums.length-1);
        return root;
    }
    public static TreeNode constructChild(int[] nums,int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return new TreeNode(nums[start]);
        }
        int max = findMax(nums,start,end);
        TreeNode node = new TreeNode(nums[max]);
        node.left = constructChild(nums,start,max-1);
        node.right = constructChild(nums,max+1,end);
        return node;
    }
    public static int findMax(int [] nums,int start, int end){
        int max = start;
        for(int i = start; i <= end; i++){
            if(nums[i]>nums[max]){
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums = {3,2,1,6,0,5};
        constructMaximumBinaryTree(nums);
    }
}
