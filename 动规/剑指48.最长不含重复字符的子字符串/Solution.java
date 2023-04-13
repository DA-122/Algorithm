// 剑指 Offer 48. 最长不含重复字符的子字符串
// 思路分析:dp + 哈希表
// dp[i] 以第i个字符结尾的最大子字符串长度
// dp[i] = dp[i-1]+1                   字符i没出现过
// dp[i] = min(dp[i-1]+1,i-map.get(i)) 字符i出现了
// 初始化: dp[0] = 0;
// 迭代顺序:从前往后
import java.util.HashMap;
import java.util.Map;

public class Solution{
    public static int lengthOfLongestSubstring(String s) {
        int[] dp  = new int[s.length()+1];
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 1 ; i < dp.length; i++){
            char c = s.charAt(i-1);
            if(map.containsKey(c)){
                dp[i] = Math.min(i - map.get(c),dp[i-1]+1);
            }else{
                dp[i] = dp[i-1] + 1;
            }
            map.put(c,i);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    // 滑动窗口+哈希(其实与dp思路一致)
    public static int lengthOfLongestSubstring2(String s) {
        int left = 0; int right = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            // c出现
            if(map.containsKey(c)){
                //对比left和上次c出现的位置
                if(left <= map.get(c)){
                    left = map.get(c)+1;
                }
            }
            map.put(c,right);
            max = Math.max(max,right-left+1);
        }
        return max;
    }
    public static void main(String[] args){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}