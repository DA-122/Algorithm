import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// 力扣763：划分字母区间
// 思路1： 贪心算法（较优）
// 思路2： 转化成不重叠区间，双指针

public class Solution{
    public static void main(String[] args){
        String str = "ababcbacadefegdehijhklij";
        partitionLabelsGreedy(str);
    }
    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> mapFront = new HashMap<>();
        Map<Character, Integer> mapBack = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!mapFront.containsKey(s.charAt(i))){
                mapFront.put(s.charAt(i), i);
            }
        }
        for(int i = s.length() - 1; i >= 0; i--){
            if(!mapBack.containsKey(s.charAt(i))){
                mapBack.put(s.charAt(i), i);
            }
        }
        // 转化成合并区间问题
        int [][] ranges =  new int [mapFront.size()][2];
        int cnt = 0;
        for(Character c : mapFront.keySet()){
            ranges[cnt][0] = mapFront.get(c);
            ranges[cnt][1] = mapBack.get(c);
            cnt++;
        }
        List<Integer> res = new ArrayList<>();
        Arrays.sort(ranges, (a,b)->(a[0] - b[0]));
        int left = -1, right = -1;
        for(int i = 0; i < ranges.length; i++){
            if(left == -1){
                left = ranges[i][0];
                right = ranges[i][1];
            }else{
                if(ranges[i][0] < right){
                    right = Math.max(right, ranges[i][1]);
                }else{
                    res.add(right - left + 1);
                    left = ranges[i][0];
                    right = ranges[i][1];
                }
            }
        }
        res.add(right - left + 1);
        return res;
    }
    public static List<Integer> partitionLabelsGreedy(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = s.length() - 1; i >= 0; i--){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i + 1);
            }
        }
        int left = 0;
        int max = 0;
        List<Integer> res = new ArrayList<>();
        for(int i  = 0; i < s.length(); i++){
            if(i == max){
                if(max != 0){
                    res.add(max - left);
                }
                left = i ;
                max = map.get(s.charAt(i));
            }else{
                max = Math.max(max, map.get(s.charAt(i)));
            }
        }
        res.add(max - left);
        return res;
    }

}