// 使用前缀和+哈希表 复杂度 O(n)
// 思路分析：问题转化+前缀和+哈希表

import java.util.HashMap;
class Solution {
    public static int countSubarrays(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        int pointer = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > k){
                sum+=1;
            }else if(nums[i] < k){
                sum-=1;
            }else{
                pointer = i;
                break;
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        for(int i = pointer; i < nums.length; i++){
            if(nums[i] > k){
                sum+=1;
            }else if(nums[i] < k){
                sum-=1;
            }
            ans=ans+map.getOrDefault(sum,0)+map.getOrDefault(sum-1,0);
        }

        return ans;
    }
    public static void main(String[] args){
        int[] nums = {3,2,1,4,5};
        int k = 4;
        System.out.println(countSubarrays(nums, k));
    }
}