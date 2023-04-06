public class Solution {
    public static int countVowelStrings(int n) {
        int dp[][] = new int[n][5];
        for(int i = 0; i< 5; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i< n; i++){
            for(int j = 0; j < 5; j++){
                for(int k = 0; k< j+1; k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        return dp[n-1][0]+dp[n-1][1]+dp[n-1][2]+dp[n-1][3]+dp[n-1][4];
    }
    public static void main(String [] args){
        int n = 2;
        System.out.println(countVowelStrings(n));
    }
}