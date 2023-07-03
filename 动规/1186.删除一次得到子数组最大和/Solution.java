// 力扣1186 删除一次得到子数组最大和
// 思路分析：1 动态规划
// dp[i][k] 以k几位的非空子数组，删除k次的最大和
// dp[i][0] = max(0,dp[i-1][0]) + arr[i])
// dp[i][1] = max(dp[i-1][0],dp[i-1][1]+arr[i])
// 2，前后缀分解



class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][2];
        dp[0][0] = arr[0];
        dp[0][1] = 0;
        int res = dp[0][0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(0,dp[i-1][0]) + arr[i];
            dp[i][1] = Math.max(dp[i-1][1]+arr[i],dp[i-1][0]);
            res = Math.max(Math.max(dp[i][0],dp[i][1]),res);
        }
        return res;
    }
}
