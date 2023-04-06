// 力扣392. 判断子序列
// 思路分析： 1 由于此题情景简单，可以直接双指针遍历求解
// 2 拓展 使用dp
// dp数组: dp[i][j]  0<i<t.length, 0<=j<26 dp[i][j]表示从字符串t中第i个字符，跳转到字符串中下一个j+'a'字符的位置
// 递推公式: t.charAt(i) -'a' == j  dp[i][j] = i; 这个字符就是所要跳到的字符
//          t.charAt(i) -'a' != j  dp[i][j] = dp[i+1][j] 由于要跳到后面的第一个字符，因此应该从后往前遍历，保证第一
// 初始化: dp数组最后一列初始化为n+1 表示无法在本串中找到下一个字符
public class Solution {
    // t长串 s 短串
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
