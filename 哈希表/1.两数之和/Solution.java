// ����1 ����֮��
// ˼·������ 1.��ϣ��(һ�α�������)
// 2.˫ָ�루���������£�

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])&&map.get(target-nums[i])!=i){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            }
            map.put(nums[i],i);
        }
        return result;
    }    
    public int[] twoSum2(int[] nums, int target) {
        int [] result = new int[2];
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] > target){
                right--;
            }else if(nums[left] + nums[right] < target){
                left++;
            }else{
                result[0] = left;
                result[1] = right;
                break;
            }
        }
        return result;
    }
}