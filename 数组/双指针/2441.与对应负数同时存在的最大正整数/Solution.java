// 2441 与对应负数同时存在的最大正整数
// 思路分析：哈希表 | 排序+双指针

import java.util.Arrays;

public class Solution{
    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            if(nums[left] < -nums[right]){
                left++;
            }else if(nums[left] > -nums[right]){
                right--;
            }else{
                return nums[right];
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int nums[] = {-1,2,-3,3};
        findMaxK(nums);
    }
}