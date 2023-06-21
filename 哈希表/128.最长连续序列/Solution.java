// ����128 ���������
// ˼·��������ĿҪ��O(n)���Ӷ�
// ����뵽��ϣ��+visited����ȥ�ظ���

import java.util.HashMap;
import java.util.Map;

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
}