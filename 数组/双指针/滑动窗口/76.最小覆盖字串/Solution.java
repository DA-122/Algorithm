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
    public static String minWindow2(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        String res = "";
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
                int left = 0; int right = 0;
        for(char c: t.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        int diff = map.size();
        // 向右扩张
        while(right < s.length()){
            char r = s.charAt(right);
            if(map.containsKey(r)){
                // 所需字符数减1
                if(map.get(r) == 1){
                    diff--;
                }
                map.put(r,map.get(r) - 1);
            }
            // 所需字符足够
            if(diff == 0){
                // 左边界收缩
                // 不包含left字符 或者left字符有冗余
                while(left < right){
                    char l = s.charAt(left);
                    if(map.containsKey(l)){
                        if(map.get(l) < 0){
                            map.put(l,map.get(l) + 1);
                        }else{
                            break;
                        }
                    }
                    left++;
                }
                // 更新 res
                if(right - left + 1 < min){
                    res = s.substring(left,right + 1);
                    min = right - left + 1;
                }
            }
            right++;
        }
        
        return res;
    }


    public static void main(String [] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow2(s,t));
    }
}
