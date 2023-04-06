// 力扣53 最大子数组和
// 思路分析：求一个连续子数组，该连续子数组元素之和在所有连续子数组中最大。数组中有正数也有负数，因为要求连续，所以再加元素时，要考虑元素是否为负
// 应该计算已经算过的元素和，看是否能加入到子数组中
// dp数组: dp[i] 以i结尾的最大连续子数组和
// 递推公式: dp[i-1] > 0,  dp[i] = dp[i-1]+nums[i]
// dp[i-1] <= 0 , dp[i] = nums[i];
// 初始化: dp[0] = nums[0] 
public class Solution {
    // 排除法 + dp
    public static int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length+1];
        if(nums[0] > 0){
            dp[0] = nums[0];
        }else{
            dp[0] = 0;
        }
        int ans = dp[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(0,dp[i-1]+nums[i]);
            max = Math.max(nums[i],max);
            ans = Math.max(dp[i],ans);
        }
        return max>0? ans:max;
    }
    // 纯dp
    public static int maxSubArray2(int[] nums) {
        int dp[] = new int[nums.length];
        int ans = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(dp[i-1] > 0){
                dp[i] = dp[i-1]+nums[i];
            }else{
                dp[i] = nums[i];
            }
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums1));
    }
}