// 力扣121.买卖股票的最大时刻
// 思路分析：1 一次遍历即可，每天记录当天卖出所能获得的最大收益即可，每天比较利润，来获得当天之前的最小利润
// 2. 动规 dp[i][0]， 第i天持有股票的最小代价， dp[i][1]，当天卖出股票的最大收益
// dp[i][0] = min(dp[i-1][0],prices[i])  dp[i][1] = max(dp[i-1][1],prices[i]-dp[i-1][0])
// 初始化 dp[0][0] = prices[0], dp[0][1] = 0;
public class Solution {
    public static int maxProfit(int[] prices) {
        int max = 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = prices[0]*(-1);
        dp[0][1] = 0;
        for(int j =1 ; j<prices.length;j++){
            if(prices[j]+dp[j-1][0] > dp[j-1][1]){
                dp[j][1] = prices[j]+dp[j-1][0];
                max = Math.max(dp[j][1],max);
            }
            dp[j][0] = Math.max(dp[j-1][0],prices[j]*(-1));
        }
        return max;
    }
    public static int maxProfit2(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            max = Math.max(prices[i] - minPrice,max);
        }
        return max;
    }
    public static void main(String[] args){
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }
}