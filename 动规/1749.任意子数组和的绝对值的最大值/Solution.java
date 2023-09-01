// 力扣1749. 任意子数组和的绝对值的最大值
// 题目描述：给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
// 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空）
// 思路分析： 动态规划， 即找出子数组，最大(正数)或者最小(负数)
public class Solution{
    public static void main(String[] args){
        int nums[] = {-3,-5,-3,-2,-6,3,10,-10,-8,-3,0,10,3,-5,8,7,-9,-9,5,-8};
        maxAbsoluteSum(nums);
    }
    public static int maxAbsoluteSum(int[] nums) {
        int res = 0;
        int [] max = new int[nums.length];
        int [] min = new int[nums.length];
        max[0] = Math.max(nums[0],0);
        min[0] = Math.min(nums[0],0);
        res = Math.max(res, max[0]);
        res = Math.max(res, -min[0]);
        for(int i = 1; i < nums.length; i++){
            if(max[i - 1] > 0){
                max[i] = max[i-1]+ nums[i];
            }else{
                max[i] = nums[i];
            }
            if(min[i - 1] < 0){
                min[i] = min[i-1]+ nums[i];
            }else{
                min[i] = nums[i];
            }
            res = Math.max(max[i],res);
            res = Math.max(res,-min[i]);
        }
        return res;
    }
}