import java.util.Arrays;

public class Solution{
    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int [] sums = new int[nums.length-1];
        // i-1对值
        for(int i = 0; i < sums.length; i++){
            sums[i] = nums[i+1] -nums[i];
        }
        int [][] dp = new int[sums.length+1][p+1];
        for(int i = 0; i <= p; i++){
            dp[0][i] = 0;
            dp[1][i] = sums[0];
        }
        for(int i = 2; i < sums.length; i++){
            for(int j = 0; j < p+1; j++){
                if(j == 0)
                    // 没有空位
                    dp[i][j] = dp[i-1][j];
                else
                    //选择i和i-2 或者选择i-1
                    dp[i][j] = Math.min(dp[i-2][j-1]+sums[i-1] ,dp[i-1][j]);
            }
        }
        return dp[sums.length-1][p];
    }

    public static void main(String[] args){
        int[] nums = {10,1,2,7,1,3};
        System.out.println(minimizeMax(nums, 2));
    }
}