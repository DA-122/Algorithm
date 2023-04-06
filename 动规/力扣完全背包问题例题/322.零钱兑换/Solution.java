// 力扣322 零钱兑换
// 思路分析，很容易看出来是完全背包问题，但这里问的不是最大价值，而是凑出amount的最少硬币数，
// 因此递推公式 dp[i] = min(dp[i],dp[i-coins[j]]+1)
// 这里的初始化比较麻烦，首先dp[0]肯定为0, 其他的dp不能为0，否则min永远取0，所以应当初始化为INF或者Amount+1
// 迭代顺序：先物品还是先amount都可以，可以重复加入，因此从小到大遍历
public class Solution {
    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        dp[0] = 0;
        for(int i = 1 ; i < dp.length; i++){
            dp[i] = amount+1;
        }
        for(int i = 0; i <= amount; i++){
            for(int j = 0; j <coins.length;j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount];
    }
    public static void main(String[] args){
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }
}
