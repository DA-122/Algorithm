// 力扣27 移除元素
// 思路分析：要求空间复杂度O(1)，原地修改数组，因此双指针

public class Solution{
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int right = n-1;
        int left = 0;
        while(left <= right){
            if(nums[left] != val){
                left++;
            }else{
                for(int i = left; i < right; i++){
                    nums[i] = nums[i+1];
                }
                right--;
            }
        }
        return right+1;
    }
    public static void main(String[] args){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        removeElement(nums, val);
    }
}