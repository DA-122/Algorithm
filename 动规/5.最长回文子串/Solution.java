// 力扣5 最长回文子串
// 思路分析：dp，中心拓展

public class Solution{
    public static String longestPalindrome(String s) {
        int n = s.length();
        int max = 1;
        int left = 0, right = 0;
        boolean dp[][] = new boolean[n][n];
        for(int i = 0; i < n; i++){
           dp[i][i] = true;
        }
        for(int i = 1; i < n; i++){
            if(s.charAt(i-1) == s.charAt(i)){
                dp[i-1][i] = true;
                if(max < 2){
                    max = 2;
                    left = i-1;
                    right = i;
                }
            }
        }
        // 行减小向上，列增大向右，向右上
        for(int i = 2; i < n; i++){
            for(int j = i; j < n; j++)
                if(s.charAt(j-i) == s.charAt(j)&& dp[j-i+1][j-1]){
                    dp[j-i][j] = true;
                    if(max < i+1){
                        max = j-i+1;
                        left = j-i;
                        right = j;
                    }
                }
        }
        return s.substring(left,right+1);
    }
    public static void main(String[] args){
        String s = "ccc";
        longestPalindrome(s);
    }
}
