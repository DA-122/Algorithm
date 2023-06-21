// ¹þÏ£

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