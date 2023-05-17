// 力扣18 四数之和
// 思路分析： 在三数之和的基础上加一层循环，并且进行剪枝，考虑大数越界

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return result;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n-3 ; i++){
            // 去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            // 剪枝：最大的三个数加nums[i]仍然小于target
            if((long)nums[i] + nums[n-3] + nums[n-2] + nums[n-1] < target){
                continue;
            }
            // 剪枝：递增序列最小的四个数都比target大break
            if((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                break;
            }
            for(int j = i + 1; j < n-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                if((long)nums[i] + nums[j] + nums[n-2] + nums[n-1] < target){
                    continue;
                }
                if((long)nums[i] + nums[j] + nums[j+1] + nums[j+2] > target){
                    break;
                }
                int left = j + 1;
                int right = n - 1;
                while(left < right){
                    if((long)nums[i] + nums[j] + nums[left] +nums[right] == target){                            
                        while(left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        right--;
                        left++;
                    }else if((long)nums[i] + nums[j] + nums[left] +nums[right] > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return result;
    }
}