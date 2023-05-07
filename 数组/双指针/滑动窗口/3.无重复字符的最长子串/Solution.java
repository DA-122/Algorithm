// 力扣3. 无重复字符的最长子串
// 思路分析：滑动窗口，哈希表记录字符位置
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int left = 0;
        int right = 1;
        int max = 1;
        Map<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        while(right < s.length()){
            // 当前重复字符在map value大于left才算重复
            if(map.containsKey(s.charAt(right))&& map.get(s.charAt(right))>=left){
                max = Math.max(max,right - left);
                left = map.get(s.charAt(right))+1;            
            }                
            map.put(s.charAt(right),right);
            right++;
        }
        max = Math.max(max,right - left);
        return max;
    }
}