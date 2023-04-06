// 123.买卖股票的最佳时机Ⅲ
// 思路分析：动态规划算法
// dp[n][2][2] 表示第n天处于不同状态的利润
// dp[i][0][0] = Math.min(prices[i],dp[i-1][0][0])*(-1)
// dp[i][1][0] = Math.max(prices[i]+dp[i-1][0][0],dp[i-1][1][0]) 
// dp[i][0][1] = Math.max(dp[i-1][0][1],dp[i-1][1][0]-prices[i]),;
// dp[i][1][1] = Math.max(dp[i-1][0][1]+prices[i],dp[i-1][1][1]);
class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        dp[0][0][0] = -prices[0];
        dp[0][1][0] = 0;
        // 这里要初始化为-prices[0];
        dp[0][0][1] = -prices[0];
        dp[0][1][1] = 0;
        for(int i = 1; i < dp.length; i++){
            dp[i][0][0] = Math.max(prices[i]*(-1),dp[i-1][0][0]);
            dp[i][1][0] = Math.max(prices[i]+dp[i-1][0][0],dp[i-1][1][0]) ;
            dp[i][0][1] = Math.max(dp[i-1][0][1],dp[i-1][1][0]-prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][0][1]+prices[i],dp[i-1][1][1]);
        }
        return dp[prices.length-1][1][1];
    }
}