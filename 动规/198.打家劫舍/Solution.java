// 力扣198 打家劫舍
// 思路分析，从nums.lenght家选出偷窃金额最高的几家，且不能相邻
// 到第i家时，拿意味着i-1家不拿，dp[i] = dp[i-2]+nums[i]
//           不拿意味着i-1家可拿可不拿,只需要看i-1家如何操作最大化 dp[i] = dp[i-1]
// dp数组,,长度为nums.length+1, dp[i]存放到第i家时，所能偷窃的最大金额
// 递推公式 dp[i] = max(dp[i-2]+nums[i],dp[i-1])
// 初始化: dp[0] = 0, dp[1] = nums[0]
class Solution {
    public static int rob(int[] nums) {
        int[] values = new int [nums.length+1];
        values[0] = 0;
        values[1] = nums[0];
        for(int i = 2; i < values.length; i++){
            values[i] = Math.max(values[i-2]+nums[i-1 ] ,values[i-1]);
        }
        return values[nums.length];
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
     }
}