// 力扣704 二分查找
// 题目： 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

public class Solution{
    public static int search(int[] nums, int target) {
        int ans = -1;
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left+(right-left)/2;
            if(target < nums[mid]){
                right = mid-1;
            }else if (target > nums[mid]){
                left = mid+1;
            }else{
                ans = mid;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int []nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
}