// 力扣41 缺失的第一个正数
// 法1. 无空间复杂度要求，哈希表，将所有元素加入到哈希表中，从1到N遍历，判断数是否在表中
// 小优化，由于用例有负数，负数不用加入到哈希表中。
// 法2. 有空间复杂度要求，哈希表 + 置换（原地哈希，将nums数组改造成哈希表）

import java.util.Set;
import java.util.HashSet;

public class Solution {

    // 法1 时间复杂度O(n) 空间复杂度O(n)
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num > 0){
                set.add(num);
            }
        }
        for(int i = 1; i < n+1; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return n + 1;
    }
    // 法2 时间复杂度O(n) 空间复杂度O(1)
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] > 0 && nums[i] <= n){
                int pos = nums[i] - 1;
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
                if(nums[i] == nums[pos]){
                    break;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] != i+1){
                return i + 1;
            }
        }
        return n + 1;
    }
}
