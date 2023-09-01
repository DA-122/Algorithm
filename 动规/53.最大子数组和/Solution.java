// 力扣53 最大子数组和
// 思路分析：求一个连续子数组，该连续子数组元素之和在所有连续子数组中最大。数组中有正数也有负数，因为要求连续，所以再加元素时，要考虑元素是否为负
// 应该计算已经算过的元素和，看是否能加入到子数组中
// dp数组: dp[i] 以i结尾的最大连续子数组和
// 递推公式: dp[i-1] > 0,  dp[i] = dp[i-1]+nums[i]
// dp[i-1] <= 0 , dp[i] = nums[i];
// 初始化: dp[0] = nums[0] 
public class Solution {
    // dp 可以看到 dp[i] 只与 dp[i-1] 有关
    public static int maxSubArray2(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int dp[] = new int[n+1];
        for(int i = 1; i < n + 1; i++){
            dp[i] = Math.max(dp[i-1]+ nums[i-1], nums[i-1]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    // 滚动数组优化
    public int maxSubArray3(int[] nums) {
        int n = nums.length;
        int pre = nums[0];
        int res = pre;
        for(int i = 1; i < n; i++){
            pre = Math.max(pre + nums[i], pre);
            res = Math.max(pre,res);
        }
        return res;
    }


    public static void main(String[] args){
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(nums1));
    }
}