// 力扣454 两数之和
// 思路分析：分组 哈希 时间复杂度O(N^2)
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int ans = 0;
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map1.put(nums1[i]+nums2[j],map1.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map2.put(nums3[i]+nums4[j],map2.getOrDefault(nums3[i]+nums4[j],0)+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map1.entrySet()){
            int key = entry.getKey();
            if(map2.containsKey(-key)){
                ans+= entry.getValue()*map2.get(-key);
            }
        }
        return ans;

    }
}