// 力扣1143 最长公共子序列
// 思路分析：类似于718 最长重复子数组
// dp数组 dp[i][j] text1第i个字符和text2第j个字符前的最长公共序列数量
// 递推公式: text1[i] = text2[j] dp[i][j] = dp[i-1][j-1]
// text1[i] != text2[j] dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j])
// 遍历方向：显然前到后 
class Solution {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    public static void main(String[] args){
        String text1 = "abcedf";
        String text2 = "ace" ;
        System.out.println(longestCommonSubsequence(text1,text2));
    }
}