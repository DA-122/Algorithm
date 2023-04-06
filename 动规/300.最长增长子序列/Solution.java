// 力扣300 最长增长子序列
// dp数组：dp[i]表示以i元素结尾的最长增长子序列的长度
// 递推公式: dp[i] = dp[i-1]+1

public class Solution {
    public static int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        int max = 0;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i]++;
            max = Math.max(dp[i],max);
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }
}