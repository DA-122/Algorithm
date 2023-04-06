// 122 ������Ʊ�����ʱ����
// ˼·������1 ̰�� ʱ��O(N) �ռ�O(1)
// 2 ��̬�滮 ʱ��O(N) �ռ�O(N)
// 3 ���ݱ��� ʱ��O(2^N) �ռ�O(N)
public class Solution {
    // ̰���㷨 ÿ��ֻ�й�Ʊ�Ǽ۾ͻ������
    public static int maxProfitGreedy(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length;i++){
            if(prices[i] > prices[i-1]){
                max+=prices[i] -prices[i-1];
            }
        }
        return max;
    }
    // ��̬�滮
    public static int maxProfitDp(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // 0����ֹ����н�1�����ֹ����н�i�����i��
        dp[0][0] = prices[0]*(-1);
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i++){
            // ���ճֹ������ = ���ճֹ� �� ���ղ��ֹ� ���ճֹ�
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            // ���ղ��ֹ������ = ���ղ��ֹ� �� ���ճֹɣ����ղ��ֹ�
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]) ;
        }
        return dp[prices.length-1][1];
    } 
    // ���ݱ��� status-0 �����ֹ�, status-1����ֹ�
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
        // ������
        dfs(prices,index+1,len,ans,status);
        // ������Ʊ
        if(status == 1){
            dfs(prices, index+1, len, ans+prices[index], 1-status);
        }else{
            dfs(prices, index+1, len, ans-prices[index], 1-status);
        }

    }
}
