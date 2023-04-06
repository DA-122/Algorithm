//����139 ���ʲ��
//˼·����:���ʿ��ظ�ʹ�ã��ɵ�����ɴ��飬���Թ�Ϊ��ȫ��������
//���ƹ�ʽ dp[i] = dp[i-s[j].length]&check(i-s[j].length)
import java.util.Arrays;
import java.util.List;

class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i < dp.length; i++){
            dp[i] = false;
        }
        for(int i = 1 ; i < dp.length; i++){
            for(int j = 0; j  < wordDict.size(); j++){
                int len = wordDict.get(j).length(); 
                if(len <= i){
                    dp[i] = dp[i-len]&check(s,i,len,wordDict.get(j));
                    if(dp[i])
                        break;
                }
            }
        }
        return dp[s.length()];
    }
    public static boolean check(String s, int i, int len, String word){
        if(s.substring(i-len,i).equals(word))
            return true;
        else
            return false;
    }
    public static void main(String [] args){
        String s ="leetcode";
        String[] list = {"leet","code"};
        List<String> str = Arrays.asList(list);
        System.out.println(wordBreak(s, str));
    }
}