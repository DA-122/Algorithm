//力扣309 买卖股票的最佳时机（含冰冻期）
public class Solution {
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i = 1; i < dp.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        int n = prices.length-1;
        return Math.max(dp[n][1],dp[n][2]);
    }
    public static void main(String[] args){
        
    }
}