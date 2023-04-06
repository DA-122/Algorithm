// ����322 ��Ǯ�һ�
// ˼·�����������׿���������ȫ�������⣬�������ʵĲ�������ֵ�����Ǵճ�amount������Ӳ������
// ��˵��ƹ�ʽ dp[i] = min(dp[i],dp[i-coins[j]]+1)
// ����ĳ�ʼ���Ƚ��鷳������dp[0]�϶�Ϊ0, ������dp����Ϊ0������min��Զȡ0������Ӧ����ʼ��ΪINF����Amount+1
// ����˳������Ʒ������amount�����ԣ������ظ����룬��˴�С�������
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
