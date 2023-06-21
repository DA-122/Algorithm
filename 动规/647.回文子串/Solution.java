// ����647.�����Ӵ�
// ˼·������ͬ5.������Ӵ�
// 1. ������չ��
// 2. ��̬�滮

// ������չ������Ҫ����ÿ��λ�ã���ÿ��λ��Ϊ���ģ�����ż��

public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        // ż�� l r �غ�
        // ���� r = l+1
        // �ܹ� n + n - 1��λ��
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
    public int countSubstrings��(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        // ��Ҫ��ʼ���Խ��ߣ��������ǶԽ���
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