// 136.只出现一次的数字
// 题目分析：非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
// 思路分析：1. 哈希表（空间复杂度O(N)）
// 2. 异或(任何数与0异或都是自身) （空间复杂度O(1)）

class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result^=nums[i];
        }   
        return result;
    }
}