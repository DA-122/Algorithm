// 力扣494 目标和
/*
 * 思路分析:乍一看可能会想到用回溯，但是回溯超时，状态空间太大
 * 首先是数学分析，给nums[]和target，在nums[]每项前添加+-号来组成target
 * 假设加号和为x,减号和为sum-x,
 * 有 x-(sum-x)=target
 * 即 sum+target=x*2
 * 
 * 先排除一些情况: 
 * 情况1: (sum+target)%2!=0，不存在解法
 * 情况2: abs(target) > sum 不可能发生
 * 
 * 实际上就转化为了从weight为nums[]的数组中，填满capacity为x的背包
 * dp数组: dp[j] 凑满j有多少种方案（一维数组）
 * 递推公式: dp[j] = dp[j]+dp[j-nums[i]];
 * 迭代方向：j从后往前，防止一个数字反复添加计算
 */
class Solution {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
        }
        if(Math.abs(target)>sum)
            return 0;
        if((sum+target)%2==1)
            return 0;
        int x = (sum+target)/2;
        int dp[] = new int [x+1];
        dp[0] = 1;
        for(int i=0; i<nums.length; i++){
            for(int j= x; j>=nums[i]; j--){
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[x];
    }

    public static void main(String[] args){
        int[] nums ={1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums,target));
    }
    
}