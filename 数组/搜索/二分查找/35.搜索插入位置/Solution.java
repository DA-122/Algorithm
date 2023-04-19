// 力扣35 搜索插入位置

// 思路分析：有序数组，查找位置，二分查找
public class Solution{
    public static int searchInsert(int[] nums, int target) {
        int ans = -1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
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
        if(ans ==-1){
            ans = left;
        }
        return ans;
    }
    public static void main(String[] args){
        int nums[] = {1,3,5,6};
        int target = 0;
        searchInsert(nums, target);
    }
}