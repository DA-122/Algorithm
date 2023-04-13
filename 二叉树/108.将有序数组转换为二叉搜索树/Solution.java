public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums,0, mid-1);
        root.right = buildTree(nums,mid+1,nums.length-1);
        return root;
    }
    public TreeNode buildTree(int[]nums, int start, int end){
        if(start == end){
            return new TreeNode(nums[start]);
        }
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums,start, mid-1);
        node.right = buildTree(nums,mid+1,end);
        return node;
    }
}