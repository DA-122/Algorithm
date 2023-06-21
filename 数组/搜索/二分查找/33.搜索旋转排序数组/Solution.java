
// nums target
// 不完全升序：不能使用二分查找
// 也可以二分(加个递归)


public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        return binarySearch(nums,target,left,right);
    }
    public int binarySearch(int nums[], int target,int left, int right){
        if(left > right)
            return -1;
        int result = -1;
        // 有序
        if(nums[left] <= nums[right]){
            while(left <= right){
                int mid = (left + right)/2;
                if(target > nums[mid]){
                    left = mid + 1;
                }else if(target < nums[mid]){
                    right = mid-1;
                }else{
                    return mid;
                }
            }
            result = -1;
        }else{
            //无序
            int mid = (left + right) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] > nums[right]){
                if(target > nums[mid]){
                    result = binarySearch(nums,target,mid+1,right);
                }else{
                    int leftRes = binarySearch(nums,target,left,mid);
                    int rightRes = binarySearch(nums,target,mid+1,right);
                    result = Math.max(leftRes,rightRes);
                }
            }else{
               if(target < nums[mid]){
                    result = binarySearch(nums,target,left,mid);
                }else{
                    int leftRes = binarySearch(nums,target,left,mid);
                    int rightRes = binarySearch(nums,target,mid+1,right);
                    result = Math.max(leftRes,rightRes);
                }
            }
        }
        return result;
    }
}