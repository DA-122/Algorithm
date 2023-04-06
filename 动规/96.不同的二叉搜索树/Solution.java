// 力扣96 不同的二叉搜索树

public class Solution {
    public static int numTrees(int n) {
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n +1; i++){
            dp[i] = 0;
            for(int j = 1; j <= i; j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }   
    public static void main(String[] args){
        System.out.println("Iteration:"+numTrees(4));
    }
}
