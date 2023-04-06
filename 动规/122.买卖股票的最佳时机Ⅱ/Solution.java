// 122 买卖股票的最佳时机Ⅱ
// 思路分析：1 贪心 时间O(N) 空间O(1)
// 2 动态规划 时间O(N) 空间O(N)
// 3 回溯暴搜 时间O(2^N) 空间O(N)
public class Solution {
    // 贪心算法 每次只有股票涨价就获得收益
    public static int maxProfitGreedy(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length;i++){
            if(prices[i] > prices[i-1]){
                max+=prices[i] -prices[i-1];
            }
        }
        return max;
    }
    // 动态规划
    public static int maxProfitDp(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // 0代表持股所有金额，1代表不持股所有金额，i代表第i天
        dp[0][0] = prices[0]*(-1);
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i++){
            // 今日持股最大金额 = 昨日持股 或 昨日不持股 今日持股
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            // 今日不持股最大金额 = 昨日不持股 或 昨日持股，今日不持股
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]) ;
        }
        return dp[prices.length-1][1];
    } 
    // 回溯暴搜 status-0 代表不持股, status-1代表持股
    public static int res = 0;
    public static int maxProfitBackTracing(int[] prices){
        dfs(prices,0,prices.length,0,0);
        return res;
    } 
    public static void dfs(int[] prices, int index, int len, int ans, int status){
        if(index == len){
            res = Math.max(res,ans);
            return;
        }
        // 不操作
        dfs(prices,index+1,len,ans,status);
        // 卖出股票
        if(status == 1){
            dfs(prices, index+1, len, ans+prices[index], 1-status);
        }else{
            dfs(prices, index+1, len, ans-prices[index], 1-status);
        }

    }
}
