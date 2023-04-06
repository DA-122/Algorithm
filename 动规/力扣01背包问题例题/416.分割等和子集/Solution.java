// 力扣416 分割等和子集
// 思路分析:相当于capacity = sum / 2, weight[] = nums[], value = nums[]的01背包问题
class Solution {
    public static boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        int[] dp = new int [target+1];
        for(int i = 0; i <= target; i++){
            if(nums[0] > i){
                dp[i] = 0;
            }else{
                dp[i] = nums[0];
            }
        }
        for(int i = 1 ; i < nums.length; i++){
            for(int j = target; j >= 0; j--){
                if(nums[i] > j){
                    dp[j] = dp[j];
                }else{
                    dp[j] = Math.max(dp[j],dp[j-nums[i]] + nums[i]);
                    if(dp[j] == target)
                        return true;
                }
            }
        }
        return dp[target] == target;
    }
    public static void main(String[] args){
        int[]testCase = {1,5,11,5};
        System.out.println("Iteration:"+canPartition(testCase));
    }
}