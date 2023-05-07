// 周赛342. 滑动子数组的美丽值
// 思路：滑动窗口+哈希表
// 注意理解第x小，重复元素也要计算

import java.util.TreeMap;

public class Solution{
    //! 超时做法
    // 滑动窗口+哈希表O(U(n-k))  U = 50
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int result [] = new int[nums.length-k+1];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0; i < k; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int counter = 0;
        for(int key : map.keySet()){
            counter+=map.get(key);
            if(counter >= x){
                result[0] = key < 0 ? key : 0;
                break;
            }
        }
        for(int i = 1; i < nums.length-k+1; i++){
            map.put(nums[i-1],map.get(nums[i-1])-1);
            map.put(nums[i+k-1],map.getOrDefault(nums[i+k-1],0)+1);
            counter = 0;
            for(int key : map.keySet()){
                if(map.get(key) !=0)
                    counter+=map.get(key);
                if(counter >= x){
                    result[i] = key < 0 ? key : 0;
                    break;
                }
            }
        }
        return result;
    }
    // 用长度为50的数组来表示哈希表
    public int[] getSubarrayBeauty2(int[] nums, int k, int x) {
        int range = 50;
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] cnt = new int[range * 2 + 1];
        for (int i = 0; i < k - 1; ++i) // 先往窗口内添加 k-1 个数(把-50向右移动50)
            cnt[nums[i] + range]++;
        for (int i = k - 1; i < n; ++i) {
            cnt[nums[i] + range]++; // 最后一个数字进入窗口（保证窗口有恰好 k 个数）
            int counter = 0;
            for (int j = 0; j < range; ++j) { // 暴力枚举负数范围 [-50,-1]
                counter += cnt[j];
                if (counter >= 0) { // 找到美丽值
                    ans[i - k + 1] = j - range;
                    break;
                }
            }
            cnt[nums[i - k + 1] + range]--; // 窗口第一个数字离开
        }
        return ans;
    }

    public static void main(String[] args){
        int nums[] = {-1,-2,-3,-4,-5};
        getSubarrayBeauty(nums, 2, 2);
    }
}

