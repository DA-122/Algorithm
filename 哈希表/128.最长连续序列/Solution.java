// 力扣128 最长连续序列
// 思路分析：题目要求O(n)复杂度
// 因此想到哈希表+visited数组去重复。

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        boolean[] visited = new boolean[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            map.put(nums[i],i);
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int left =nums[i], right =nums[i]+1;
            while( map.containsKey(right)&& !visited[map.get(right)]){
                visited[map.get(right)] = true;
                right++;
            }
            while(map.containsKey(left) && !visited[map.get(left)]){
                visited[map.get(left)] = true;
                left--;
            }
            res = Math.max(res,right-left-1);
        }
        return res;
    }
    // 一个set即可，访问过后remove访问元素
    public int longestConsecutive2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int maxlen =  1;
        for(int num: nums){
            set.add(num);
        }
        for(int num: nums){
            int left = num - 1, right = num + 1;
            while(set.contains(right)){
                set.remove(right);
                right++;
            }
            while(set.contains(left)){
                set.remove(left);
                left--;
            }
            maxlen = Math.max(right - left - 1, maxlen);

        }
        return maxlen;
    }

}