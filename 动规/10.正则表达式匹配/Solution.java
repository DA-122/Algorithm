// 力扣10.正则表达式匹配
// 思路分析：dp


// 
public class Solution{
    public static void main(String[] args){
        S solution = new S();
        String s = "aaa";
        String p = "ab*a";
        solution.isMatch(s, p);
    }
}

class S {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean dp[][] = new boolean[m+1][n+1];
        // 初始化
        dp[0][0] = true;
        for(int i = 1; i < n+1; i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    //可以匹配0次或n次
                    // if(i == 1){
                    //     dp[i][j] = dp[i][j-1] || dp[i][j-2] || dp[i-1][j-1];
                    if(s.charAt(i-1) == p.charAt(j-2)|| p.charAt(j-2) == '.'){
                        // 匹配0次 1次或多次
                        dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    }else{
                        // 只能匹配0次
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}