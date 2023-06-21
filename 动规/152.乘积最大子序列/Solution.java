// 力扣152.乘积最大子序列
// 思路分析：动态规划
// 因为有负数，会使最大变最小，最小变最大
// 因此需要维护一个二维数组

public class Solution {
    public int maxProduct(int[] nums) {
        int dp[][] = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0]*nums[i],Math.max(nums[i],dp[i-1][1] * nums[i]));
            dp[i][1] = Math.min(dp[i-1][1]*nums[i],Math.min(nums[i],dp[i-1][0] * nums[i]));
        }
        int ans =  dp[0][0];
        for(int i = 1; i < nums.length; i++){
            ans = Math.max(ans,dp[i][0]);
        }
        return ans;
    }
    // 滚动数组优化
    public int maxProduct2(int[] nums) {
        int maxVal = nums[0], minVal = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            int mx = maxVal, mn = minVal;
            maxVal = Math.max(mx*nums[i], Math.max(mn*nums[i],nums[i]));
            minVal = Math.min(mn*nums[i], Math.min(mx*nums[i],nums[i]));
            ans = Math.max(maxVal,ans);
        }
        return ans;
    }

}