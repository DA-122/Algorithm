// 力扣209 长度最小的子数组 
// 思路分析：1.滑动窗口（双指针） 时间复杂度O(N)，空间复杂度O(1)
// 向右拓展到sum >= target，记录长度，然后左侧收缩继续向右拓展
// 2.前缀和+二分查找 时间复杂度O(NlogN) 空间复杂度O(N)
// 计算nums前缀和，然后以每个前缀和sums[i]为起点，sums[i]+target为终点，二分查找终点位置

public class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int min = nums.length+1;
        int left =0, right =0;
        int curSum = 0;
        while(right < nums.length || curSum >= target){
            while(right < nums.length && curSum < target){
                curSum += nums[right];
                right++;
            }
            // 如果找不到子数组sum>=target就可以break了
            if(curSum >= target){
                min = Math.min(min,right-left);
                curSum -= nums[left];
                left++;
            }else{
                break;
            }
        }
        return min==nums.length+1? 0:min;
    }
    public static void main(String[] args){
        int target = 11 ;
        int [] nums = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(target, nums));
    }
    
}
