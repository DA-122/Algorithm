// ����10.������ʽƥ��
// ˼·������dp


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
        // ��ʼ��
        dp[0][0] = true;
        for(int i = 1; i < n+1; i++){
            if(p.charAt(i-1) == '.'){
                dp[0][i] = dp[0][i-1];
            }else if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2] || dp[0][i-1];
            }else{
                dp[0][i] = false;
            }
        }
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    if(p.charAt(j-1) == '.'){
                        // ƥ�䵱ǰ�ַ�����ƥ����ַ�
                        dp[i][j] = dp[i-1][j-1] || dp[i][j-1];
                    }else if(p.charAt(j-1) == '*'){
                        //����ƥ��0�λ�n��
                        if(i == 1){
                            dp[i][j] = dp[i][j-1] || dp[i][j-2];
                        }else if(s.charAt(i-1) == s.charAt(i-2)|| p.charAt(j-2) == '.'){
                            // ƥ����,0�Σ�1��
                            dp[i][j] = dp[i-1][j-1]|| dp[i][j-2]|| dp[i-1][j];
                        }else{
                            dp[i][j] = dp[i][j-2] || dp[i][j-1];
                        }
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[m][n];
    }
}