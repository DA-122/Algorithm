// 力扣76.最小覆盖字符串
// 思路分析：双指针 滑动窗口 + 哈希表（存储字符数量）
// 

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        // 记录t中每个字符未出现的次数
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        // 记录t中有多少个字符未在s中出现
        int remains = t.length();
        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // 结果指针
        int start =0, end = 0;
        // 记录当前最小长度
        int min = s.length()+1;
        // 滑动窗口边界指针
        int left = 0, right = 0;
        while(left < n || remains > 0){
            while(right < n && remains > 0){
                char c = s.charAt(right);
                // 包含这个字符 则哈希表字符数量-1
                if(map.containsKey(c)){
                    if(map.get(c) > 0){
                        remains--;
                    }
                    map.put(c,map.get(c)-1);
                }
                right++;
            }
            // remains > 0; 说明找不到
            if(remains > 0){
                break;
            }else{
                if(right-left < min){
                    start = left;
                    end = right;
                    min = right - left;
                }
                if(map.containsKey(s.charAt(left))){
                    if(map.get(s.charAt(left))>= 0){
                        remains++;
                    }
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
                }
                left++;
            }
        }
        return min==s.length()+1 ? "":s.substring(start,end);
    }
    public static void main(String [] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
}
