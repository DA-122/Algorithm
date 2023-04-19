public class Solution{
    public static int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        int left = 0;
        int right = nums.length-1;
        // 找第一个位置
        while(left <=  right){
            int mid = left+(right-left)/2;
            if(nums[mid] >= target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(left < 0 ||left>nums.length-1|| nums[left]!=target){
            ans[0] = -1;
        }else{
            ans[0] = left;
        }
        left = 0;
        right = nums.length-1;
        // 找第二个位置
        while(left <=  right){
            int mid = left+(right-left)/2;
            if(nums[mid] <= target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(right > nums.length-1 || right < 0|| nums[right]!=target){
            ans[1] = -1;
        }else{
            ans[1] = right;
        }

        return ans;
    }
    public static void main(String[] args){
        int [] nums = {5,7,7,8,8,10};
        int target = 8;
        searchRange(nums, target);
    }
}