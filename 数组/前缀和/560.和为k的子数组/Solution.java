// 数据范围包括负数，因此简单的双指针滑动窗口不适合
// 法3.前缀和方案 时间复杂度O(n^2) 空间复杂度O(n)
// 法4.前缀和+ 哈希表，转化为两数之和 (看是否有 sum[i] - k)

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0 ;
        int[] sums = new int[n];
        // key 前缀和 value 该数值出现次数
        Map<Integer,Integer> map = new HashMap<>();
        sums[0] = nums[0];
        map.put(sums[0],1);
        if(sums[0] == k){
            res++;
        }
        for(int i = 1; i < n; i++){
            sums[i] = sums[i-1] + nums[i];
            // 前缀差
            if(map.containsKey(sums[i] - k)){
                res+= map.get(sums[i] - k);
            }
            // 考虑本位前缀和 
            if(sums[i] == k){
                res++;
            }
            map.put(sums[i],map.getOrDefault(sums[i],0)+1);
        }
        return res;
    }
}