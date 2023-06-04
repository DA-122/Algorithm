// ��ָOffer19. ������ʽƥ��

// dp�����ʾS�ַ���ǰi���ַ���p����ǰj���ַ�����ƥ�����
// ���ڷ�"*"�ַ���
// dp[i][j] = dp[i-1][j-1] s[i] = p[j]
//          = false       s[i] != p[j]
// ����"*"�ַ�,��0�λ���
// dp[i][j] = dp[i][j-2](��0��) s[i] = p[j]
//          = dp[i-1][j](�ö��) 

//          = dp[i][j-2] ��0��  s[i] != p[j]
public class Solution {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        // ���ַ���һ������ƥ��
        dp[0][0] = true;
        for(int i  = 0; i <=m; i++){
            for(int j = 1; j <= n; j++){
                if(p.charAt(j - 1) == '*'){
                    // 0 ��ƥ��
                    dp[i][j] = dp[i][j-2];
                    if(match(s,p,i,j-1)){
                        // ƥ��0�λ���ƥ��
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
        // s��
        if(i == 0){
            return false;
        }
        // .����ƥ������
        if(p.charAt(j-1) == '.'){
            return true;
        }
        // �ж��Ƿ��
        return s.charAt(i-1) == p.charAt(j-1);
    }
    public static void main(String[] args){
        String s = "aaa";
        String p = "a*a";
        isMatch(s, p);
    }
}
