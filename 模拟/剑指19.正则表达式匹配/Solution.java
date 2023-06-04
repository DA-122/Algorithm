// 剑指Offer19. 正则表达式匹配

// dp数组表示S字符串前i个字符和p数组前j个字符串的匹配情况
// 对于非"*"字符，
// dp[i][j] = dp[i-1][j-1] s[i] = p[j]
//          = false       s[i] != p[j]
// 对于"*"字符,用0次或多次
// dp[i][j] = dp[i][j-2](用0次) s[i] = p[j]
//          = dp[i-1][j](用多次) 

//          = dp[i][j-2] 用0次  s[i] != p[j]
public class Solution {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        // 空字符串一定可以匹配
        dp[0][0] = true;
        for(int i  = 0; i <=m; i++){
            for(int j = 1; j <= n; j++){
                if(p.charAt(j - 1) == '*'){
                    // 0 次匹配
                    dp[i][j] = dp[i][j-2];
                    if(match(s,p,i,j-1)){
                        // 匹配0次或者匹配
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
                else{
                    if(match(s,p,i,j)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }
    public static boolean match(String s, String p, int i, int j){
        // s空
        if(i == 0){
            return false;
        }
        // .可以匹配任意
        if(p.charAt(j-1) == '.'){
            return true;
        }
        // 判断是否等
        return s.charAt(i-1) == p.charAt(j-1);
    }
    public static void main(String[] args){
        String s = "aaa";
        String p = "a*a";
        isMatch(s, p);
    }
}
