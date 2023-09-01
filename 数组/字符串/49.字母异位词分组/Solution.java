// 力扣49.分母异位词
// 解法： 法1. 哈希表 + 排序, 排序后的字符串作为key值，字符串数组作为value值
// 法2. 哈希表 + 统计频率，记录每个词中字母出现频率，字母频率转化成字符串作为key值

// 两种方法本质上的区别就是用谁做key
// 需要注意的是 数组不能做哈希表的key，这涉及到了map.put的底层实现，需要重写hashcode方法，显然不现实，因此将频率转字符串
// hashcode 与内存地址相关，频率数组是循环中new出来的，因此hash值不可能相同


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static  List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int curPos = 0;
        for(int i = 0; i < strs.length; i++){
            int [] fres = new int[26];
            for(char c: strs[i].toCharArray()){
                fres[c-'a']++;
            }
            StringBuffer sb = new StringBuffer("");
            for (int j = 0; j < 26; j++) {
                if (fres[j] != 0) {
                    sb.append((char) ('a' + j));
                    sb.append(fres[j]);
                }
            }
            String key = sb.toString();
            if(map.containsKey(key)){
                int pos = map.get(key);
                res.get(pos).add(strs[i]);
            }else{
                map.put(key,curPos++);
                res.add(new ArrayList(Arrays.asList(strs[i])));
            }

        }
        return res;
    }
    public static void main(String [] args){
        // String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {""};
        groupAnagrams(strs);
    }
}