// 力扣1156.单字符重复子串的最大长度
// 思路分析：滑动窗口

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int maxRepOpt1(String text) {
        int n = text.length();
        Map<Character,Integer> map= new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(text.charAt(i),map.getOrDefault(text.charAt(i),0)+1);
        }
        int res = 0;
        for(int i  = 0; i < n;){
            int r = i;
            // 找单端连续
            while(r < n && text.charAt(r) == text.charAt(i)){
                r++;
            }
            int cur = r - i;
            if(cur  < map.getOrDefault(text.charAt(i),0) && (r < n || i > 0)){
                res = Math.max(res,cur+1);
            }
            // 找第二段
            int k = r + 1;
            while(k < n && text.charAt(k) == text.charAt(i)){
                k++;
            }
            // k - i就是第二段+第一段的长度
            // 对该字符的总数和 k - i对比
            // 如果k-i小，那么可以构成k - i 否则只能构成 k - i
            res = Math.max(res, Math.min(k-i,map.getOrDefault(text.charAt(i),0)));
            i = r;
        }
        return res;
    }
    public static void main(String[] args){
        String text = "bbababaaaa";
        System.out.print(maxRepOpt1(text));
    }
}