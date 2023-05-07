// 力扣1419.数青蛙
// 思路分析：模拟

import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        String s = "croak";
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),i);
        }
        int [] frequency = new int[5];
        int cur = 0;
        int result = 0;
        for(int i = 0; i < croakOfFrogs.length(); i++){
            char word = croakOfFrogs.charAt(i);
            if(!map.containsKey(word)){
                result = -1;
                break;
            }
            if(word == 'c'){
                if(cur == result){
                    cur++;
                    result++;
                }else{
                    cur++;
                }
                frequency[map.get(word)]++;
            }else{
                int index = map.get(word);
                frequency[index]++;
                if(frequency[index] > frequency[index-1]){
                    result = -1;
                    break;
                }
                if(word == 'k'){
                    cur--;
                }
            }
        }
        for(int i = 1; i < s.length(); i++){
            if(frequency[i]!=frequency[i-1]){
                result = -1;
                break;
            }
        }

        return result;
    }
}