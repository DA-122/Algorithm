// 力扣647.回文子串
// 思路分析：同5.最长回文子串
// 1. 中心拓展法
// 2. 动态规划

// 中心拓展法：需要遍历每个位置（以每个位置为中心，分奇偶）

public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        // 偶数 l r 重合
        // 奇数 r = l+1
        // 总共 n + n - 1个位置
        for(int i = 0; i < 2 * n - 1; i++){
            int l = i/2, r = i/2+i%2;
            while(l >=0 && r < n && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                res++;
            }
        }
        return res;
    }
    public int countSubstringsⅡ(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        // 需要初始化对角线，和上三角对角线
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            res++;
        }
        for(int i = 0; i < n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                res++;
            }
        }
        for(int i = 2; i < n;i++){
            for(int j = 0; j < n-i; j++){
                if(s.charAt(j) == s.charAt(j+i) && dp[j+1][j+i-1]){
                    dp[j][j+i] = true;
                    res++;
                }
            }
        }
        return res;
    }

}