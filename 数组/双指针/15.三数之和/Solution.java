// 力扣15. 三数之和
// 思路分析： 哈希表无法去重
// 排序 + 双指针 + 剪枝
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i< nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                // 去重复
                if(nums[i] + nums[left] + nums[right] == 0){
                    if((left > i + 1 &&nums[left] == nums[left-1]) || (right < nums.length - 2 &&nums[right] == nums[right+1])){
                        left++ ;
                        right--;
                        continue;
                    }
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    right--;
                    left++;
                }else if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else
                    left++;
            }
        }
        return result;
    }
}