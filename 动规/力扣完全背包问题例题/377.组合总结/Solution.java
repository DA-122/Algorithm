// 力扣377 组合总结
// 思路分析，乍一看是完全背包问题，但是此题要求不同序列被视为不同组合，也就涉及了排列问题
// 一般的组合问题是物品遍历在外层，容量遍历在里层  //不考虑每个容量下谁先谁后
// 排列问题相反，外层遍历容量，内层遍历物品 // 每个容量都从小到大排列一遍
public class Solution {
    public static int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        dp[0] = 1;
        for(int i = 0; i <= target ;i++){
            for(int j = 0; j < nums.length; j++){
                if(i >= nums[j]){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        int target=4;
        System.out.println(combinationSum4(nums,target));
    }
}
