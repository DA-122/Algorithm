// 最接近的三数之和
// 思路分析： 肯定是排序 + 双指针
// 时间复杂度O(n^2) 空间复杂度O(1)
// 优化：1. 双指针在移动时，如果遇到相同的元素，可以跳过
// 2. 如果nums[i] + nums[i+1] + nums[i+2] > target，那之后所有的遍历都比target大，因此可以省去后续的遍历
// 3. 如果nums[i] + nums[n-1] + nums[n-2] < target，之后的双指针都比target小，可以省去双指针，直接进入后序遍历

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++){
            if( i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            // 剪枝2：如果排序后的前三个数字之和大于target，后面都只会比target更大
            int s = nums[i] + nums[i + 1] + nums[i + 2];
            if(s > target){
                if(s - target < min){
                    res = s;
                }
                break;
            }
            // 剪枝3：如果排序后nums[i] 加后两个数字之和小于target，就不需要下面的双指针了
            s = nums[i] + nums[n-2] + nums[n-1];
            if(s < target){
                if(target - s < min){
                    min = target - s;
                    res = s;
                }
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < min){
                    min = Math.abs(sum - target);
                    res = sum;
                }
                // 优化1
                if(sum > target){
                    right--;
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }else if(sum < target){
                    left++;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }else{
                    return target;
                }
            }
        }
        return res;
    }
}