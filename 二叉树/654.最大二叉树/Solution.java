import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 力扣653.最大二叉树
// 题目: 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
// 1.二叉树的根是数组中的最大元素。
// 2.左子树是通过数组中最大值左边部分构造出的最大二叉树。
// 3.右子树是通过数组中最大值右边部分构造出的最大二叉树。
// 思路分析：1.递归构建
// 2.单调栈

// 1. 递归构建，每次找数组最大值作为根节点，数组左侧子数组为左子树，右侧子数组为右子树 时间复杂度O(n^2),空间复杂度O(n)
// 2. 单调栈: 由此题描述可以得知，对于一个节点的左孩子和右孩子，该节点是左孩子右侧第一个大于左孩子的节点，是右孩子左侧第一个大于右孩子的节点
// 因此对于二叉树中的一颗子树来说，其在数组中的左边界和右边界都大于该子树的根节点，并且左右边界中较小的为其父节点
// 因此就转化成了单调栈问题，寻找数组中每个元素左侧和右侧第一个大的元素位置，较小的一个就是父节点

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

    public static TreeNode constructMaximumBinaryTreeStack(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        TreeNode[] tree = new TreeNode[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        tree[0] = new TreeNode(nums[0]);
        stack.push(0);
        for(int i = 1; i < nums.length; i++){
            tree[i] = new TreeNode(nums[i]);
            while(!stack.isEmpty()&& nums[i] > nums[stack.peek()]){
                right[stack.peek()] = i;
                stack.pop();
            }         
            if(!stack.isEmpty()){
                left[i] = stack.peek();
            }       
            stack.push(i);
        }

        TreeNode root = null;
        for(int i = 0; i < left.length; i++){
            if(left[i] == -1 && right[i] ==-1){
                root = tree[i];
                continue;
            }
            if(left[i] == -1){  
                tree[right[i]].left = tree[i];
                continue;
            }
            if(right[i] ==-1 ){
                tree[left[i]].right = tree[i];
                continue;
            }
            if(nums[left[i]] > nums[right[i]]){
                tree[right[i]].left = tree[i];
            }else{
                tree[left[i]].right = tree[i];
            }
        }
        return root;
    }





    public static void main(String[] args){
        int[] nums = {3,2,1,6,0,5};
        constructMaximumBinaryTree(nums);
    }
}
