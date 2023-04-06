// ����392. �ж�������
// ˼·������ 1 ���ڴ����龰�򵥣�����ֱ��˫ָ��������
// 2 ��չ ʹ��dp
// dp����: dp[i][j]  0<i<t.length, 0<=j<26 dp[i][j]��ʾ���ַ���t�е�i���ַ�����ת���ַ�������һ��j+'a'�ַ���λ��
// ���ƹ�ʽ: t.charAt(i) -'a' == j  dp[i][j] = i; ����ַ�������Ҫ�������ַ�
//          t.charAt(i) -'a' != j  dp[i][j] = dp[i+1][j] ����Ҫ��������ĵ�һ���ַ������Ӧ�ôӺ���ǰ��������֤��һ
// ��ʼ��: dp�������һ�г�ʼ��Ϊn+1 ��ʾ�޷��ڱ������ҵ���һ���ַ�
public class Solution {
    // t���� s �̴�
    public static boolean isSubsequence(String s, String t) {
        int n = t.length();
        int [][] dp = new int[n+1][26];
        for(int i = 0; i <26; i++){
            dp[n][i] = n+1;
        }
        for(int i = n-1; i>=0; i--){
            for(int j =0; j<26; j++){
                if(t.charAt(i)-'a' == j){
                    dp[i][j] = i;
                }else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        int add = 0;
        for(int i = 0; i < s.length();i++){
            if(dp[add][s.charAt(i)-'a'] ==n+1)
                return false;
            add = dp[add][s.charAt(i)-'a'];
        }
        return true;
    }
    public static void main(String[] args){
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
