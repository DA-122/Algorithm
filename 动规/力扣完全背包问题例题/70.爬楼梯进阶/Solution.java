// 力扣70 爬楼梯
// 思路分析，可以转化为完全背包问题
public class Solution {
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int [] steps = {1,2};
        for(int i = 0; i <=n; i++){
            for(int j = 0; j<steps.length;j++){
                if(i >= steps[j]){
                    dp[i]+=dp[i-steps[j]];
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println("CompletePack:"+climbStairs(4));
    }
}
